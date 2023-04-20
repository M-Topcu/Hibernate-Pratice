package com.tpe.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tpe.domain.Question;
import com.tpe.util.HibernateUtil;

public class QuestionDao extends HibernateDao<Question> {

	public QuestionDao() {
		classType=Question.class;
	}
	
	@Override
	public List<Question> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Question> criteriaQuery = cBuilder.createQuery(Question.class);
		Root<Question> root = criteriaQuery.from(Question.class);
		
		criteriaQuery.select(root);
		Query<Question> query = session.createQuery(criteriaQuery);
		
		List<Question> resultList = query.getResultList();
		
		return resultList;

	}

}
