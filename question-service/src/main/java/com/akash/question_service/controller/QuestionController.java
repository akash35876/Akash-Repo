package com.akash.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akash.question_service.model.Question;
import com.akash.question_service.model.QuestionWrapper;
import com.akash.question_service.model.Response;
import com.akash.question_service.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("generate")
    public ResponseEntity<List<Integer>>getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer numQuestions){
    	
    	return questionService.getQuestionsForQuiz(categoryName,numQuestions);
    }
    
    @GetMapping("getAllQuestions")
    public ResponseEntity<List<QuestionWrapper>> getALLQuestionsForQuiz(){
    	return questionService.getALLQuestionsForQuiz();
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>>getQuestionsfromId(@RequestBody List<Integer> questionIds){
    	return questionService.getQuestionfromId(questionIds);
    }
    
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response){
    	return questionService.getScore(response);
    }
    

}
