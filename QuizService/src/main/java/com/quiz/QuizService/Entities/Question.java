package com.quiz.QuizService.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class Question {
	
	private Long id;
	
	private String question;
	
	private Long quizId;
	
}
