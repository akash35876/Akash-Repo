package com.akash.app.Rest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.akash.app.Rest.model.User;
import com.akash.app.Rest.repo.UserRepo;
 

@org.springframework.web.bind.annotation.RestController
public class ResController {

	@Autowired
	UserRepo repo;
	
	
	  @GetMapping("/") public String getpage() { return "Welcome"; }
	 
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return repo.findAll();
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		repo.save(user);
		return "saved";
		
	}
	
	@PutMapping("update/{id}")
	public String updateUser(@PathVariable long id,@RequestBody User user) {
		User updateuser = repo.findById(id).get();
		updateuser.setAddress(user.getAddress());
		updateuser.setAge(user.getAge());
		updateuser.setName(user.getName());
		updateuser.setOccupation(user.getOccupation());
		repo.save(updateuser);
		return "Updated Successfully";
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		 repo.deleteById(id);
		 return "deleted Successfully";
	}
	
	@GetMapping("/register")
    public ResponseEntity<String> getIndexPage() throws IOException {
        Path path = Paths.get("src/main/resources/templates/index.html");
        String content = Files.readString(path);
        return ResponseEntity.ok().body(content);
    }
	
	@PostMapping("/registersave")
	public String registersaveUser(@ModelAttribute User user) throws IOException {
		repo.save(user);
		 Path path = Paths.get("src/main/resources/templates/index.html");
	     String content = Files.readString(path);
		return content;
	}
	
}
