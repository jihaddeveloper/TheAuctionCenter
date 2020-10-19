package com.example.theauctioncenter.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



public class DumyClientRegistrationForm {
	
	@NotEmpty
	@Size(min=3, max=100)
	private String name;
	
	@NotEmpty
	@Email
	private String email;

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

}
