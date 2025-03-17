package com.security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.demo.model.UserPrincipal;
import com.security.demo.model.Users;
import com.security.demo.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo userrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
    	Users users = userrepo.findByUsername(username);
    	
    	if(users==null) {
    		System.out.println("User Not Found");
    		throw new UsernameNotFoundException("user not found");
    	}
    	
    	return new UserPrincipal(users);
    }
    
}
