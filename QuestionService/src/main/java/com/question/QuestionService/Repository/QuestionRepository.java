package com.question.QuestionService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.QuestionService.Entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	public List<Question> findByQuizId(Long quizId);

}
