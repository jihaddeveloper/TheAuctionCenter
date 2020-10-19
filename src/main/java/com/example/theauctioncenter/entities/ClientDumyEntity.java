package com.example.theauctioncenter.entities;

/*
 * Author: Jihad
 * Date: 24/07/2018
 * About: ClientDumy Entity
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.example.theauctioncenter.base_entity.BaseEntity;

@Entity
@Table(name="client_dumy_entity")
public class ClientDumyEntity extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	
	@NotNull
	@Column(name="name",length=100,unique=false)
	private String name;
	
	@Email
	@NotNull
	@Column(name="email",length=100)
	private String email;
	
	public ClientDumyEntity() {
		
	}	
	
	public ClientDumyEntity(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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

	@Override
	public String toString() {
		return "ClientDumyEntity [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}
