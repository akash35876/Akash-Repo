package com.akash.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akash.question_service.dao.QuestionDao;
import com.akash.question_service.model.Question;
import com.akash.question_service.model.QuestionWrapper;
import com.akash.question_service.model.Response;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
		List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
		return new ResponseEntity<>(questions, HttpStatus.OK);

	}

	public ResponseEntity<List<QuestionWrapper>> getALLQuestionsForQuiz() {
		List<Question> questions = questionDao.getAllQuestions();
		List<QuestionWrapper> data = new ArrayList<>();
		for (Question model : questions) {
			QuestionWrapper object = new QuestionWrapper();
			object.setQuestionTitle(model.getQuestionTitle());
			object.setOption1(model.getOption1());
			object.setOption2(model.getOption2());
			object.setOption3(model.getOption3());
			object.setOption4(model.getOption4());
			object.setId(model.getId());
			data.add(object);
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionfromId(List<Integer> questionIds) {
		// TODO Auto-generated method stub
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();

		for (Integer id : questionIds) {
			questions.add(questionDao.findById(id).get());
		}
		for (Question model : questions) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(model.getId());
			wrapper.setQuestionTitle(model.getQuestionTitle());
			wrapper.setOption1(model.getOption1());
			wrapper.setOption2(model.getOption2());
			wrapper.setOption3(model.getOption3());
			wrapper.setOption4(model.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> response) {

		int right = 0;

		for (Response responses : response) {
			Question question = questionDao.findById(responses.getId()).get();
			if (responses.getResponse().equals(question.getRightAnswer())) {
				right++;
			}
		}
		return new ResponseEntity<Integer>(right, HttpStatus.OK);
	}

}
