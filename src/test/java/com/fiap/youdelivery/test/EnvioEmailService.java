package com.fiap.youdelivery.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void testarEnvioDeEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("edcarlos.adm1@gmail.com");
		message.setSubject("Teste de Envio de Email");
		message.setText("Este é um teste de envio de e-mail pelo Spring Boot.");
		mailSender.send(message);
		System.out.println("E-mail de teste enviado.");
	}
}
