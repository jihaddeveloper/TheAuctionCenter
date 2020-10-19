package com.example.theauctioncenter.services;

/*
 * Author: Jihad
 * Date: 31/07/2018
 * About: Role Service Class
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theauctioncenter.repositories.RoleRepository;



@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

}
