package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todolistauth")
public class AuthEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authId;
	
	@Column(name = "userid")
	private int userId;
	
	@NotBlank(message = "Password field cannot be blank")
	private String userpassword;
	private String usertaskrole;
	
	public AuthEntity() {
		
	}
	
	public AuthEntity(int authId, int userId, String userpassword, String usertaskrole) {
		this.authId = authId;
		this.userId = userId;
		this.userpassword = userpassword;
		this.usertaskrole = usertaskrole;
	}
	
	public AuthEntity(int userId, String userpassword, String usertaskrole) {
		this.userId = userId;
		this.userpassword = userpassword;
		this.usertaskrole = usertaskrole;
	}
	
	
}
