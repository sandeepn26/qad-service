package com.qad.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Credentials {

	String email;
	
	String password;

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
	
	@Override
	public String toString() {
		return new ToStringBuilder("{").append(this.email).append(this.password).build();
	}
}
