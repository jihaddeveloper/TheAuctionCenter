package com.example.theauctioncenter.services;

/*
 * Author: Jihad
 * Date: 24/07/2018
 * About: ClientDumy Service Class
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theauctioncenter.entities.ClientDumyEntity;
import com.example.theauctioncenter.repositories.ClientDumyRepository;

@Service
public class ClientDumyService {
	
	@Autowired
	private ClientDumyRepository clientDumyRepository;
	
	public ClientDumyEntity FindClient(String name) {
		return clientDumyRepository.findByName(name);
	}
	
	public ClientDumyEntity FindClientId(Long id) {
		return clientDumyRepository.findById(id).orElse(null);
	}
	
	public ClientDumyEntity SaveDumyClient(ClientDumyEntity clientDumyEntity) {
		return clientDumyRepository.save(clientDumyEntity);
	}
	
	

}
