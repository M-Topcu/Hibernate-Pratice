package com.tpe.domain;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(generator="sequence",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="sequence",sequenceName="question_answer_seq",initialValue = 100,allocationSize = 5)
	private long id;
	
	@Version
	private Long versiyon;
	
	private LocalDateTime createOn = LocalDateTime.now();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getVersiyon() {
		return versiyon;
	}

	public LocalDateTime getCreateOn() {
		return createOn;
	}
	
	
}
