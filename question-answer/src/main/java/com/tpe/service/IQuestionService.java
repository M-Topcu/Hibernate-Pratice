package com.tpe.service;

import java.util.List;

import com.tpe.domain.Question;

public interface IQuestionService {
	
	void save(Question question);
	void update(Question question);
	void delete(Long id);
	Question find(Long id);
	List<Question> getAllQuestion();

}
