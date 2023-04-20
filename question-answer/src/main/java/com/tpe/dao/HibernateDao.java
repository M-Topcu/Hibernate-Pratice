package com.tpe.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpe.util.HibernateUtil;

public abstract class HibernateDao<T> implements GenericDao<T> {
	
	protected Class <T> classType;
	
	@Override
	public void save(T t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(t);
		
		
		tx.commit();
		session.close();
		
	}
	
	@Override
	public void update(T t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(t);
		
		
		tx.commit();
		session.close();
		
	}
	
	@Override
	public void delete(Long id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		T t = session.load(classType, id);
		
		session.delete(t);
		
		
		tx.commit();
		session.close();
		
	}
	
	@Override
	public Optional<T> find(Long id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		T t = session.get(classType, id);
		
		Optional<T> opt = Optional.ofNullable(t);
		
		
		tx.commit();
		session.close();
		return opt;
	}
	
	
}
