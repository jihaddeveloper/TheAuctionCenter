package com.example.theauctioncenter.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Author: Jihad
 * Date: 05/08/2018
 * About: Login Controller Class
 * */

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class); 
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm() {
		logger.debug("Rendering Login Form Page");
		return "/client/loginForm";
	}
}
