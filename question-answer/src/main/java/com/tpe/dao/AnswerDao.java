package com.tpe.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
		
		session.close();
		
		return resultList;
	}
	
	public List<Answer> findAllByQuestionId(Long id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query<Answer> query = session.createQuery("FROM Answer a WHERE a.question.id=:questionId",Answer.class);
		query.setParameter("questionId",id);
		List<Answer> resultList = query.getResultList();
		
		tx.commit();
		session.close();
		return resultList;
	}

}
