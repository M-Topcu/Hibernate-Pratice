package com.tpe.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_qdetail")
public class QuestionDetail extends BaseEntity{
	
	private String description;
	
	@OneToOne
	@JoinColumn(name="question_id")
	private Question question;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
