package com.example.theauctioncenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.theauctioncenter.entities.TaskEntity;
import com.example.theauctioncenter.entities.UserEntity;
import com.example.theauctioncenter.services.TaskService;
import com.example.theauctioncenter.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TheAuctionCenterApplication.class)
public class TheAuctionCenterApplicationTests2 {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService; 
	
	@Before
	public void initDB() {
		
		{
			UserEntity newUser= new UserEntity("jihadAdmin@gmail.com", "AdminJihad", "123456");
			userService.createAdmin(newUser);
			//System.out.println(userService.findOneUser("jihadAdmin@gmail.com"));
		}
		
		{
			UserEntity newUser= new UserEntity("jihadUser@gmail.com", "UserJihad", "123456");
			userService.createUser(newUser);
			//System.out.println(userService.findOneUser("jihadUser@gmail.com"));
		}
		
		
		TaskEntity userTask = new TaskEntity("01/08/2018", "10.00 AM", "06.00 PM", "Coding");
		UserEntity user = userService.findOneUser("jihadUser@gmail.com");
		taskService.addTask(userTask, user);
	}
	
	@Test
	public void testUser() {
		UserEntity user = userService.findOneUser("jihadUser@gmail.com");
		assertNotNull(user);
		UserEntity admin = userService.findOneUser("jihadAdmin@gmail.com");
		assertEquals(admin.getEmail(), "jihadAdmin@gmail.com");
	}
	
	@Test
	public void testTask() {
		UserEntity user = userService.findOneUser("jihadUser@gmail.com");
		List<TaskEntity> task = taskService.findUserTask(user);
		assertNotNull(task);
	}
	
	public void showUserAdmin() {
		System.out.println("Admin : "+userService.findOneUser("jihadAdmin@gmail.com"));
		System.out.println("User : "+userService.findOneUser("jihadUser@gmail.com"));
	}

}
