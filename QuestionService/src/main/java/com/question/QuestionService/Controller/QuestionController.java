package com.question.QuestionService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.question.QuestionService.Entities.Question;
import com.question.QuestionService.Services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	//create
	@PostMapping
	public Question create(@RequestBody Question quiz) {
		return questionService.add(quiz);
	}
	
	//getAll
	@GetMapping
	public List<Question> get(){
		return questionService.get();
	}
	
	@GetMapping("/{id}")
	public Question getById(@PathVariable("id") Long id) {
		return questionService.get(id);
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getByQuizId(@PathVariable("quizId") Long quizId) {
		return questionService.getByQuizId(quizId);
	}
}
