package com.example.theauctioncenter.entities;

/*
 * Author: Jihad
 * Date: 30/07/2018
 * About: UserEntity Class
 * */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_entity")
public class UserEntity {
	
	@Id
	@Email(message="Please enter a valid email ")
	@NotEmpty(message="This field can't be empty")
	@Column(name="email",unique=true)
	private String email;
	
	@NotEmpty(message="This field can't be empty")
	@Size(min=5, max=30, message="Name should be between 5 to 30 characters")
	@Column(name="name",length=100,unique=false)
	private String name;
	
	@NotEmpty(message="This field can't be empty")
	@Size(min=6, message="Password should be atleast 6 characters")
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@Column(name="tasks")
	private List<TaskEntity> tasks;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@Column(name="roles")
	@JoinTable(name="user_roles", joinColumns= {@JoinColumn(name="user_email", referencedColumnName="email")}, inverseJoinColumns= {@JoinColumn(name="user_role_name", referencedColumnName="role_name")})
	private List<RoleEntity> roles;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<TaskEntity> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	public UserEntity(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public UserEntity() {
	}

}
