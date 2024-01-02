package com.quiz.QuizService.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizService.Entities.Quiz;
import com.quiz.QuizService.Services.QuizService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//create
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}
	
	//getAll
	@GetMapping
//	@CircuitBreaker(name="question", fallbackMethod = "fallbackMethodList")  //to implement the circuit breaker
//	@TimeLimiter(name = "question") 	//to implement timeout 
//	@Retry(name = "question")			//to overcome timeout issue
	public List<Quiz> get(){
		return quizService.get();
	}
	
	
	@GetMapping("/{id}")
	public Quiz getById(@PathVariable("id") Long id) {
		return quizService.get(id);
	}
	
	
	public String fallbackMethod(RuntimeException runtimeException) {
		return "Oops! Something went wrong, Please try after sometime.";
		
	}
	
	public CompletableFuture<List<Quiz>> fallbackMethodList(RuntimeException exception){
		Quiz quiz = new Quiz();
		quiz.setTitle("Oops! Something went wrong, Please try after sometime.");
		List<Quiz> quizzes =  new ArrayList<Quiz>();
		quizzes.add(quiz);
		return CompletableFuture.supplyAsync(()->quizzes);
	}
}
