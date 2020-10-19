package com.example.theauctioncenter.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/*
 * Author: Jihad
 * Date: 30/07/2018
 * About: RoleEntity Class
 * */

@Entity
@Table(name="role")
public class RoleEntity {

	@Id
	@NotEmpty
	@Column(name="role_name")
	private String roleName;
	
	@ManyToMany(mappedBy="roles")
	@Column(name="users")
	private List<UserEntity> users;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public RoleEntity(String roleName, List<UserEntity> users) {
		this.roleName = roleName;
		this.users = users;
	}

	public RoleEntity(String roleName) {
		this.roleName = roleName;
	}

	public RoleEntity() {
	}

}
