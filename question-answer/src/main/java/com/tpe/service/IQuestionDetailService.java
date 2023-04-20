package com.tpe.service;

import java.util.List;

import com.tpe.domain.QuestionDetail;

public interface IQuestionDetailService {
	
	void save(QuestionDetail questionDetail);
	void update(QuestionDetail questionDetail);
	void delete(Long id);
	QuestionDetail find(Long id);
	List<QuestionDetail> getAllQuestionDetail();

}
