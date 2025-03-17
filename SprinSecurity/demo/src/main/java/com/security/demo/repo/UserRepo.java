package com.security.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.demo.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	
	Users findByUsername(String username);
    
}
