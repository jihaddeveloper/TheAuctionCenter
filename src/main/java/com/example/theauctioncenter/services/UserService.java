package com.example.theauctioncenter.services;

/*
 * Author: Jihad
 * Date: 31/07/2018
 * About: User Service Class
 * */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.theauctioncenter.entities.RoleEntity;
import com.example.theauctioncenter.entities.UserEntity;
import com.example.theauctioncenter.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void createAdmin(UserEntity user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		RoleEntity userRole = new RoleEntity("ADMIN");
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public void createUser(UserEntity user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		RoleEntity userRole = new RoleEntity("USER");
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public UserEntity findOneUser(String email) {
		return userRepository.findById(email).orElse(null);
	}

	public boolean isUserPresent(String email) {
		UserEntity user = userRepository.findById(email).orElse(null);
		if(user != null)
			return true;
		
		return false;
	}

	public List<UserEntity> findAllUsers() {
		return userRepository.findAll();
	}

	public List<UserEntity> findByName(String name) {
		return userRepository.findByNameLike("%"+name+"%");
	}
	
}
