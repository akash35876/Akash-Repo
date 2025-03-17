package com.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.Users;
import com.security.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@PostMapping("/register")
	public Users register(@RequestBody Users users) {
		return userService.register(users);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users users) {
		System.out.println(users);
		return userService.verify(users);
	}
}
