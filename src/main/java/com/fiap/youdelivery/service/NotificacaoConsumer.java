package com.fiap.youdelivery.service;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fiap.youdelivery.entities.Morador;
import com.fiap.youdelivery.entities.Notificacao;
import com.fiap.youdelivery.exception.ResourceNotFoundException;
import com.fiap.youdelivery.repository.IMoradorRepository;
import com.fiap.youdelivery.repository.INotificacaoRepository;

@Service
public class NotificacaoConsumer {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private IMoradorRepository moradorRepository;
    @Autowired
    private INotificacaoRepository notificacaoRepository;

    @KafkaListener(topics = "topico-notificacao", groupId = "notificacao-group")
    public void consumir(String mensagem) {
        // Processa a mensagem recebida do Kafka
    	System.out.println("Mensagem recebida: " + mensagem);
        String[] partes = mensagem.split("\\|");
        String emailDestinatario = partes[0].split(":")[1];
        String assunto = partes[1].split(":")[1];
        String conteudoMensagem = partes[2].split(":")[1];

        // Envio de email
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailDestinatario);
        email.setSubject(assunto);
        email.setText(conteudoMensagem);
        mailSender.send(email);

        // Registro da notificação
        Morador morador = moradorRepository.findByEmail(emailDestinatario)
            .orElseThrow(() -> new ResourceNotFoundException("Morador não encontrado"));

        Notificacao notificacao = new Notificacao();
        notificacao.setMensagem(conteudoMensagem);
        notificacao.setConfirmado(false);
        notificacao.setDataEnvio(LocalDateTime.now());
        notificacao.setMorador(morador);

        notificacaoRepository.save(notificacao);
        System.out.println("Notificação salva no banco de dados para o morador: " + emailDestinatario);
    }
}