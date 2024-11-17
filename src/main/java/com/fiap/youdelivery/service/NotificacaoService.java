package com.fiap.youdelivery.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fiap.youdelivery.entities.Morador;
import com.fiap.youdelivery.entities.Notificacao;
import com.fiap.youdelivery.exception.ResourceNotFoundException;
import com.fiap.youdelivery.repository.IMoradorRepository;
import com.fiap.youdelivery.repository.INotificacaoRepository;

@Service
public class NotificacaoService {
	    @Autowired
	    private JavaMailSender mailSender;
	    @Autowired
	    private INotificacaoRepository notificacaoRepository;
	    @Autowired
	    private IMoradorRepository moradorRepository;
	 
	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;
	    private final String TOPICO_NOTIFICACAO = "topico-notificacao";
	    
	    public void enviarNotificacaoPorEmail(String emailDestinatario, String assunto, String mensagem) {
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(emailDestinatario);
	        email.setSubject(assunto);
	        email.setText(mensagem);
	        mailSender.send(email);
	        System.out.println("E-mail enviado para: " + email);
	        
	        Morador morador = moradorRepository.findByEmail(emailDestinatario)
	               .orElseThrow(() -> new ResourceNotFoundException("Morador não encontrado"));

	        Notificacao notificacao = new Notificacao();
	        notificacao.setMensagem(mensagem);
	        notificacao.setConfirmado(false);  // Inicialmente não confirmado
	        notificacao.setDataEnvio(LocalDateTime.now());  // Hora atual
	        notificacao.setMorador(morador);  // Associando o morador
            
	        // Salvar a notificação no banco
	        notificacaoRepository.save(notificacao);
	    }
	    public Notificacao confirmarRecebimento(Long notificacaoId) {
	        Notificacao notificacao = notificacaoRepository.findById(notificacaoId)
	              .orElseThrow(() -> new ResourceNotFoundException("Notificação não encontrada"));
	        notificacao.setConfirmado(true);
	        notificacao.setDataConfirmacao(LocalDateTime.now());
	        return notificacaoRepository.save(notificacao);
	    }
	    
	    public void enviarNotificacaoKafka(String emailDestinatario, String assunto, String mensagem) {
	        String notificacaoMensagem = String.format("Email:%s|Assunto:%s|Mensagem:%s", emailDestinatario, assunto, mensagem);
	        kafkaTemplate.send(TOPICO_NOTIFICACAO, notificacaoMensagem);
	        System.out.println("Notificação enviada para o Kafka.");
	    }
	    
//	    public void confirmarRecebimento(Long notificacaoId) {
//	        Notificacao notificacao = notificacaoRepository.findById(notificacaoId)
//	              .orElseThrow(() -> new ResourceNotFoundException("Notificação não encontrada"));
//	        notificacao.setConfirmado(true);
//	        notificacao.setDataConfirmacao(LocalDateTime.now());
//	        notificacaoRepository.save(notificacao);
//	    }

}
