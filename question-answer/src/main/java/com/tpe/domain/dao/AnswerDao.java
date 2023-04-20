package com.tpe.domain.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tpe.domain.Answer;
import com.tpe.util.HibernateUtil;

public class AnswerDao extends HibernateDao<Answer> {
	
	public AnswerDao() {
		classType=Answer.class;
	}

	@Override
	public List<Answer> getAll() {
Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Answer> criteriaQuery = cBuilder.createQuery(Answer.class);
		Root<Answer> root = criteriaQuery.from(Answer.class);
		
		criteriaQuery.select(root);
		Query<Answer> query = session.createQuery(criteriaQuery);
		
		List<Answer> resultList = query.getResultList();
		
		return resultList;
	}

}
