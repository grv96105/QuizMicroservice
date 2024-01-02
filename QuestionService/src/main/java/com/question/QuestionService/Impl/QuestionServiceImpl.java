package com.question.QuestionService.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.QuestionService.Entities.Question;
import com.question.QuestionService.Repository.QuestionRepository;
import com.question.QuestionService.Services.QuestionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public Question add(Question quiz) {
		// TODO Auto-generated method stub
		return questionRepo.save(quiz);
	}

	
	@Override
	public List<Question> get() {
		// TODO Auto-generated method stub
		return questionRepo.findAll();
	}

	@Override
	public Question get(Long id) {
		// TODO Auto-generated method stub
		Question quiz = new Question();
		quiz.setQuestion("Question not found");
		return questionRepo.findById(id).orElse(quiz);
	}

	@Override
	public List<Question> getByQuizId(Long id) {
//		To delay the response to check the Timeout error and condition
//		log.info("Question Service Started");
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		log.info("Question Service Ended");
		return questionRepo.findByQuizId(id);
	}

}
