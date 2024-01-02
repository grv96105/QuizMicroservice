package com.quiz.QuizService.Services;

import java.util.List;

import com.quiz.QuizService.Entities.Quiz;

public interface QuizService {

	public Quiz add(Quiz quiz);
	
	public List<Quiz> get();
	
	public Quiz get(Long id);
}
