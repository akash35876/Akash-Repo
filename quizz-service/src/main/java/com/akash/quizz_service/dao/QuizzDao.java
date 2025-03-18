package com.akash.quizz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.quizz_service.model.Quiz;

@Repository
public interface QuizzDao extends JpaRepository<Quiz, Integer> {

}
