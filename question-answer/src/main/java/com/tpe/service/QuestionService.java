package com.tpe.service;

import java.util.List;

import com.tpe.dao.QuestionDao;
import com.tpe.domain.Question;
import com.tpe.exception.ResourceNotFoundException;

public class QuestionService implements IQuestionService {
	
	private static final QuestionDao questionDao= new QuestionDao();

	@Override
	public void save(Question question) {
		
		questionDao.save(question);

	}

	@Override
	public void update(Question question) {
		questionDao.update(question);

	}

	@Override
	public void delete(Long id) {
		questionDao.delete(id);

	}

	@Override
	public List<Question> getAllQuestion() {
		return questionDao.getAll();
		
	}

	@Override
	public Question find(Long id) {
		
		return questionDao.find(id).orElseThrow(()->new ResourceNotFoundException("Question not found with id " + id));
	}

}
