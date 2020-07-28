package com.janiv.api.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	
	private String mobilenumber;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}
	public JwtRequest(String username, String password) {
		this.setMobilenumber(username);
		this.setPassword(password);
	}
	 
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
}
