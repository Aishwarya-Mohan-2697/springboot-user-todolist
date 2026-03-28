package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginRequestEntity;
import com.example.demo.entity.LoginResponse;
import com.example.demo.entity.UserAuthViewEntity;
import com.example.demo.repository.UserAuthViewRepository;

@Service
public class LoginService {
	@Autowired
	private UserAuthViewRepository userAuthViewRepository;
	
	@Autowired
	private JwtService jwtService;
	
	public LoginResponse performLogin(LoginRequestEntity loginRequest) {
		String userNameReq = loginRequest.getUserName();
		String userPassReq = loginRequest.getUserPassword();
		System.out.println("LoginService: performLogin called for user: " + userNameReq);
		
		UserAuthViewEntity userAuthDetails = userAuthViewRepository.findByUserName(userNameReq);
		if(userAuthDetails == null) {
			throw new RuntimeException("User not found");
		}
		
		System.out.println("LoginService: Retrieved user details for user: " + userAuthDetails.getUserName());
		
		// Simple plain text password comparison
		if(!userAuthDetails.getUserPassword().equals(userPassReq)) {
			throw new RuntimeException("Invalid credentials");
		}
		
		String token = JwtService.generateToken(userNameReq);
		
		return new LoginResponse(token);
	}
}
