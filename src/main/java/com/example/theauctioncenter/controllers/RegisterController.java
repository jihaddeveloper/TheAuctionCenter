package com.example.theauctioncenter.controllers;

/*
 * Author: Jihad
 * Date: 31/07/2018
 * About: Registration Controller Class
 * */
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.theauctioncenter.entities.UserEntity;
import com.example.theauctioncenter.services.UserService;

@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {

		model.addAttribute("userEntity", new UserEntity());

		logger.debug("User Register Form View Works");
		
		return "client/registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@Valid UserEntity userEntity, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "client/registerForm";
		}
		if (userService.isUserPresent(userEntity.getEmail())) {

			model.addAttribute("exist", true);

			logger.debug("User Register Data Missmatch");
			
			return "client/registerForm";

		}
		userService.createUser(userEntity);

		logger.debug("User Register Works");
		
		return "client/regSuccess";

	}

}
