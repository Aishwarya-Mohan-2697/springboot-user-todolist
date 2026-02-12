package com.example.demo.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userauth")
@Immutable
public class UserAuthViewEntity {
	@Id
	@Column(name = "userid")
	private int userId;
	@Column(name = "username", length=30)
	private String userName;
	@Column(name = "userpassword")
	private String userPassword;
	
	public UserAuthViewEntity() {
		
	}
	
	public UserAuthViewEntity(int userId, String userName, String userPassword) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getUserPassword() {
		return this.userPassword;
	}
	


}
