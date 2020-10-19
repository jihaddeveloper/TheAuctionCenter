package com.example.theauctioncenter.controllers;

/*
 * Author: Jihad
 * Date: 30/07/2018
 * About: Task Controller Class
 * */

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.theauctioncenter.entities.TaskEntity;
import com.example.theauctioncenter.services.TaskService;
import com.example.theauctioncenter.services.UserService;

@Controller
public class TaskController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addTaskForm" , method=RequestMethod.GET)
	public String taskAddForm(String email, Model model, HttpSession httpSession ) {
		
		httpSession.setAttribute("email", email);
		model.addAttribute("taskEntity", new TaskEntity());
		
		logger.debug("Task Add Form View Works");
		
		return "client/taskForm";
	}
	
	@RequestMapping(value="/addTask" , method=RequestMethod.POST)
	public String taskAdd(@Valid TaskEntity taskEntity, BindingResult bindingResult, HttpSession httpSession, Model model) {
		
		if(bindingResult.hasErrors()) {
			
			logger.debug("Add Task Data Missmatch");
			
			return "client/taskForm";
		}
		
		String email = (String) httpSession.getAttribute("email");
		taskService.addTask(taskEntity, userService.findOneUser(email));
		
		logger.debug("Add Task Successful");
		
		return "redirect:/users";
	}

}
