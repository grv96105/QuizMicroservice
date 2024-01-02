package com.quiz.QuizService.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizService.Entities.Quiz;
import com.quiz.QuizService.Repository.QuizRepository;
import com.quiz.QuizService.Services.QuestionClient;
import com.quiz.QuizService.Services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public Quiz add(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		// TODO Auto-generated method stub
		List<Quiz> quizzes = quizRepo.findAll();
		
		quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return quizzes;
	}

	@Override
	public Quiz get(Long id) {
		// TODO Auto-generated method stub
		Quiz errorQuiz = new Quiz();
		errorQuiz.setTitle("Quiz Not Found");
		Quiz quiz = quizRepo.findById(id).orElse(errorQuiz);
		quiz.setQuestions(questionClient.getQuestionOfQuiz(id));
		return quiz;
	}

}
