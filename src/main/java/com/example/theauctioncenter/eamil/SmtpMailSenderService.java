package com.example.theauctioncenter.eamil;

/*
 * Author: Jihad
 * Date: 28/07/2018
 * About: Email Sender Service
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpMailSenderService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public SmtpMailSenderService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void mailSender(String from, String to, String subject, String body) throws MailException {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		
		simpleMailMessage.setFrom(from);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);
		
		javaMailSender.send(simpleMailMessage);
		
	}
	

}
