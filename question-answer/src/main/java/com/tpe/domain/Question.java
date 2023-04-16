package com.tpe.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tpe.domain.enums.QuestionPriority;

@Entity
@Table(name="t_question")
public class Question extends BaseEntity{
	
	@Column(nullable= false, unique=true, length = 200)
	private String name;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private QuestionPriority priority;
	
	@OneToOne(mappedBy="question", orphanRemoval = true)
	private QuestionDetail questionDetail;
	
	@OneToMany(mappedBy="question",  orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Answer> answerList = new ArrayList<>();

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuestionPriority getPriority() {
		return priority;
	}

	public void setPriority(QuestionPriority priority) {
		this.priority = priority;
	}

	public QuestionDetail getQuestionDetail() {
		return questionDetail;
	}

	public void setQuestionDetail(QuestionDetail questionDetail) {
		this.questionDetail = questionDetail;
	}
	
	
}
