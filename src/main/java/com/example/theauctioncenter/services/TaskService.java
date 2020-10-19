package com.example.theauctioncenter.services;

/*
 * Author: Jihad
 * Date: 31/07/2018
 * About: Task Service Class
 * */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theauctioncenter.entities.TaskEntity;
import com.example.theauctioncenter.entities.UserEntity;
import com.example.theauctioncenter.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(TaskEntity task, UserEntity user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<TaskEntity> findUserTask(UserEntity user){
		return  taskRepository.findByUser(user);
	}
}
