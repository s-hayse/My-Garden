package com.mygarden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SendMail {
	
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendEmail (@RequestBody String toEmail, String subject, String message) {
		SimpleMailMessage newMessage = new SimpleMailMessage();
		newMessage.setTo(toEmail);
		newMessage.setSubject(subject);
		newMessage.setText(message);
		emailSender.send(newMessage);
		
	}

	
}