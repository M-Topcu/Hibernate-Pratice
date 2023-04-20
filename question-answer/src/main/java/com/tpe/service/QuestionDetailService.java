package com.tpe.service;

import java.util.List;

import com.tpe.dao.QuestionDetailDao;
import com.tpe.domain.QuestionDetail;
import com.tpe.exception.ResourceNotFoundException;

public class QuestionDetailService implements IQuestionDetailService {
	
	private static final QuestionDetailDao questionDetailDao = new QuestionDetailDao();

	@Override
	public void save(QuestionDetail questionDetail) {
		questionDetailDao.save(questionDetail);

	}

	@Override
	public void update(QuestionDetail questionDetail) {
		questionDetailDao.update(questionDetail);

	}

	@Override
	public void delete(Long id) {
		questionDetailDao.delete(id);

	}

	@Override
	public List<QuestionDetail> getAllQuestionDetail() {
		return questionDetailDao.getAll();
	}

	@Override
	public QuestionDetail find(Long id) {
		return questionDetailDao.find(id).orElseThrow(()->new ResourceNotFoundException("QuestionDetail not found with id " + id));
	}

}
