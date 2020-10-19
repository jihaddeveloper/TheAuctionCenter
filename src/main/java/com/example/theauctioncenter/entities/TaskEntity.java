package com.example.theauctioncenter.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/*
 * Author: Jihad
 * Date: 30/07/2018
 * About: TaskEntity Class
 * */

@Entity
@Table(name="task")
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@NotEmpty(message="Please enter a date")
	@Column(name="date")
	private String date;
	
	@NotEmpty(message="Please enter a starttime")
	@Column(name="start_time")
	private String startTime;
	
	@NotEmpty(message="Please enter a endtime")
	@Column(name="end_time")
	private String endTime;
	
	@NotEmpty(message="Please enter a task description")
	@Column(name="description",length=1000)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="email")
	private UserEntity user;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public TaskEntity(Long id, String date, String startTime, String endTime, String description,
			UserEntity user) {
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.user = user;
	}

	public TaskEntity(String date, String startTime, String endTime, String description, UserEntity user) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.user = user;
	}

	public TaskEntity(String date, String startTime, String endTime, String description) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	public TaskEntity() {
	}

}
