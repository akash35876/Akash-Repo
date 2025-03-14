package com.example.HealthCare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HealthCare.Dao.BlogRepositry;
import com.example.HealthCare.model.BlogPost;

@Service
public class BlogService {
	@Autowired 
	
	private BlogRepositry repo;
	
	public List<BlogPost> getBlog(){
		 List<BlogPost> e= repo.findAll();
		 System.out.println("Getting Data From DB"+e);
		return e;
	}
	   public Optional<BlogPost> getId(int id){
		   
		   Optional<BlogPost> a = repo.findById(id);
		   return a;
		   
	   }


}
