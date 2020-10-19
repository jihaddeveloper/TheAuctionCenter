package com.example.theauctioncenter.controllers;
/*
 * Author: Jihad
 * Date: 04/08/2018
 * About: Profile Controller Class
 * */

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.theauctioncenter.entities.UserEntity;
import com.example.theauctioncenter.services.TaskService;
import com.example.theauctioncenter.services.UserService;

@Controller
public class ProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/profile" , method=RequestMethod.GET)
	public String viewProfile(Model model, Principal principal) {

		
		String email = principal.getName();
		UserEntity userEntity = userService.findOneUser(email);
		model.addAttribute("tasks", taskService.findUserTask(userEntity));
		
		logger.debug("Profile View Works");
		
		return "client/profile";
	}

}
