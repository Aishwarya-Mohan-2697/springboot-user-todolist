package com.example.demo.entity;

public class LoginRequestEntity {
	private String userName;
	private String userPassword;
	
	public LoginRequestEntity(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return this.userPassword;
	}
	
	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
