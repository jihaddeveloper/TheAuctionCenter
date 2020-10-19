package com.example.theauctioncenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.theauctioncenter.entities.UserEntity;
import com.example.theauctioncenter.services.UserService;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;

@SpringBootApplication
@EnableEmailTools
public class TheAuctionCenterApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(TheAuctionCenterApplication.class, args);
	}
	
	
	//Admin Create
	
	@Override
	public void run(String... args) throws Exception  {
		{
			UserEntity newAdmin=new UserEntity("admin@gmail.com", "Admin", "123456");
			userService.createAdmin(newAdmin);
		}

	}
	
	
}
