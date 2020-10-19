package com.example.theauctioncenter.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Author: Jihad
 * Date: 31/07/2018
 * About: Use Controller Class
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.theauctioncenter.services.UserService;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users" , method=RequestMethod.GET)
	public String usersList(Model model, @RequestParam(defaultValue="") String name) {

		model.addAttribute("users", userService.findByName(name));
		
		logger.debug("Users List View Works");
		
		return "client/usersList";
	}
	
}
