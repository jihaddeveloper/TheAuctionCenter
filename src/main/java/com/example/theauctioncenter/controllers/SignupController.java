package com.example.theauctioncenter.controllers;
/*
 * Author: Jihad
 * Date: 05/04/2018
 * About: Signup Controller Class
 * */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signupForm() {

		logger.debug("User Signup Form View Works");
		
		return "/client/signupForm";
	}
	
	

}
