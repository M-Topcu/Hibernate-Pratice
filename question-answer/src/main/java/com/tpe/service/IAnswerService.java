package com.tpe.service;

import java.util.List;

import com.tpe.domain.Answer;

public interface IAnswerService {

	void save(Answer answer);
	void update(Answer answer);
	void delete(Long id);
	Answer find(Long id);
	List<Answer> getAllAnswers();
	List<Answer> getAllAnswerByQuestionId(Long id);
	
}
