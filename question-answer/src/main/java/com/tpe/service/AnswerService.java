package com.tpe.service;

import java.util.List;

import com.tpe.dao.AnswerDao;
import com.tpe.domain.Answer;
import com.tpe.exception.ResourceNotFoundException;

public class AnswerService implements IAnswerService {
	
	private static final AnswerDao answerDao= new AnswerDao();

	@Override
	public void save(Answer answer) {
		answerDao.save(answer);

	}

	@Override
	public void update(Answer answer) {
		answerDao.update(answer);

	}

	@Override
	public void delete(Long id) {
		answerDao.delete(id);

	}

	@Override
	public Answer find(Long id) {
		Answer answer= answerDao.find(id).orElseThrow(()->new 
				ResourceNotFoundException("Answer not found with id " + id));
		return answer;
	}

	@Override
	public List<Answer> getAllAnswers() {
		return answerDao.getAll();
	}

	@Override
	public List<Answer> getAllAnswerByQuestionId(Long id) {
		List<Answer> list = answerDao.findAllByQuestionId(id);
		return list;
	}

}
