package com.example.theauctioncenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.theauctioncenter.entities.ClientDumyEntity;
import com.example.theauctioncenter.services.ClientDumyService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TheAuctionCenterApplication.class)
public class TheAuctionCenterApplicationTests {

	@Autowired
	ClientDumyService clientDumyService;  
	
	@Test
	public void findByNameTest() {
		
		ClientDumyEntity clientDumyEntity= new ClientDumyEntity(1L, "Supto","supto@gmail.com");
		
		clientDumyService.SaveDumyClient(clientDumyEntity);
		
		System.out.println(clientDumyService.FindClient("Supto"));
	}

}
