package com.example.HealthCare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HealthCare.model.BlogPost;
import com.example.HealthCare.service.BlogService;

@RestController
@RequestMapping("/api")
public class BlogController {

	@Autowired
	private  BlogService serv;

	@GetMapping("/blogposts")
	public List<BlogPost> showBlog() {

		return serv.getBlog();
	}
	@GetMapping("/blogposts/{id}")
	public Optional<BlogPost> showId(@PathVariable int id){
		return serv.getId(id);
	}

}
