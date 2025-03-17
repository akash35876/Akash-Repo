package com.security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.model.Users;
import com.security.demo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo  userRepo;
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	AuthenticationManager authmanager;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Users register(Users users) {
		users.setPassword(encoder.encode(users.getPassword()));
		return userRepo.save(users);
		
	}

	public String verify(Users users) {
		Authentication authication =
				authmanager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
		if(authication.isAuthenticated()) {
			return jwtService.generateToken(users.getUsername());
		}
		return "failure";
	}
}
