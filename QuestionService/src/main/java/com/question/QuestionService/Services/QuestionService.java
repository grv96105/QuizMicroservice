package com.question.QuestionService.Services;

import java.util.List;

import com.question.QuestionService.Entities.Question;


public interface QuestionService {

	public Question add(Question quiz);
	
	public List<Question> get();
	
	public Question get(Long id);
	
	public List<Question> getByQuizId(Long quizId);
}
