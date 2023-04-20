package com.tpe.domain.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tpe.domain.QuestionDetail;
import com.tpe.util.HibernateUtil;

public class QuestionDetailDao extends HibernateDao<QuestionDetail> {
	
	public QuestionDetailDao() {
		classType=QuestionDetail.class;
	}

	@Override
	public List<QuestionDetail> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<QuestionDetail> criteriaQuery = cBuilder.createQuery(QuestionDetail.class);
		Root<QuestionDetail> root = criteriaQuery.from(QuestionDetail.class);
		
		criteriaQuery.select(root);
		Query<QuestionDetail> query = session.createQuery(criteriaQuery);
		
		List<QuestionDetail> resultList = query.getResultList();
		
		return resultList;
	}

}
