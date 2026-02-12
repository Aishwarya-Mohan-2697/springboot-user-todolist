package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoginRequestEntity;
import com.example.demo.entity.LoginResponse;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public LoginResponse login(@RequestBody LoginRequestEntity loginRequest) {
		return loginService.performLogin(loginRequest);
	}

}
