package com.fiap.youdelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {
	    @Autowired
	    private JavaMailSender mailSender;

	    public void enviarNotificacaoPorEmail(String emailDestinatario, String assunto, String mensagem) {
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(emailDestinatario);
	        email.setSubject(assunto);
	        email.setText(mensagem);
	        mailSender.send(email);
	        System.out.println("E-mail enviado para: " + email);
	    }
}
