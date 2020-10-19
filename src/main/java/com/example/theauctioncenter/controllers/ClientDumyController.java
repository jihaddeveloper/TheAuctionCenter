package com.example.theauctioncenter.controllers;

/*
 * Author: Jihad
 * Date: 25/07/2018
 * About: ClientDumy Controller
 * */

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.theauctioncenter.dto.DumyClientRegistrationForm;
import com.example.theauctioncenter.entities.ClientDumyEntity;
import com.example.theauctioncenter.services.ClientDumyService;

@Controller
public class ClientDumyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientDumyController.class); 
	
	@Autowired
	private ClientDumyService clientDumyService;
	
	
	@RequestMapping(value="/SaveDumyClient", method=RequestMethod.POST)
	public String dumyClientRegister(@RequestBody @ModelAttribute @Valid DumyClientRegistrationForm dumyClientRegistrationForm, BindingResult result , HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "redirect:/ex";
		}
		
	    final String name = request.getParameter("name");
	    final String email = request.getParameter("email");
		
		ClientDumyEntity clientDumyEntity = new ClientDumyEntity();
		
		clientDumyEntity.setName(name);
		clientDumyEntity.setEmail(email);
		
		clientDumyService.SaveDumyClient(clientDumyEntity);
		logger.debug("Rendering Client Add Complete");
		return "redirect:/" +"Name : "+request.getParameter("name")+" ,,, " +"Email : "+request.getParameter("email");
	}
	
	@RequestMapping(value="/{client}", method=RequestMethod.GET)
	public String clientProfile(@PathVariable("client") String client, Model model) {
		logger.debug("Rendering Client Profile Page :"+ client);
		
		model.addAttribute("client", client);
		
		return "client/client_profile";
	}
	
	
	
	

}
