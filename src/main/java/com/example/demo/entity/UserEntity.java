package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "todolistusers")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank(message = "Name must not be blank")
	@Column(name = "username", length=30, nullable = false, unique=true)
	private String userName;
	
	@Email(message = "Email format is invalid")
	@Column(name = "email", length = 255)
	private String email;
	private Date createdDate;
	private Date updatedDate;
	
	public UserEntity() {}
	
	public UserEntity(int userId, String userName, String email, Date createdDate, Date updatedDate) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public UserEntity(String userName, String email, Date createdDate, Date updatedDate) {
		this.userName = userName;
		this.email = email;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getUpdatedDate() {
		return this.updatedDate;
	}
	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
