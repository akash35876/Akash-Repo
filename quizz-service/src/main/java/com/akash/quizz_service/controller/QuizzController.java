package com.akash.quizz_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.quizz_service.model.QuizzDto;
import com.akash.quizz_service.service.QuizzService;


@RestController
@RequestMapping("squizz")
public class QuizzController {
	
	@Autowired
	QuizzService quizzservice;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuizz(@RequestBody QuizzDto quizzdto){
		
		return quizzservice.createQuizz(quizzdto.getCategoryName(),quizzdto.getNumQuestions(),quizzdto.getTitle());
	}
	

}
