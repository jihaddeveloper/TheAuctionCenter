package com.example.theauctioncenter.controllers;

/*
 * Author: Jihad
 * Date: 29/07/2018
 * About: Email Sender Controller
 * */

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.theauctioncenter.eamil.SmtpMailSenderService;

@Controller
public class MailSenderController {
	
	private static final Logger logger = LoggerFactory.getLogger(MailSenderController.class);
	
	@Autowired
	private SmtpMailSenderService smtpMailSenderService; 
	
	@Value("${spring.mail.username}")
	private String sender;
	
	@RequestMapping(value="/SendEmail", method=RequestMethod.POST)
	public String sendEmail(HttpServletRequest request) {
		
		final String from =  sender;
		final String to = request.getParameter("email");
		final String subject = "Registration Link";
		final String body = "Hello  " + request.getParameter("name");;

		try {
			smtpMailSenderService.mailSender(from, to, subject, body);
			logger.debug("Mail Sending Successful");
		}catch (Exception e) {
			logger.debug("Error Mail Sending" + e.getMessage());
		}
		return "index";
	}

}
