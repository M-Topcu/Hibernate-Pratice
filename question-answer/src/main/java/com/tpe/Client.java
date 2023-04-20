package com.tpe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpe.domain.Question;
import com.tpe.domain.enums.QuestionPriority;
import com.tpe.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		
		Question question = new Question();
		question.setName("What is Java");
		question.setPriority(QuestionPriority.CRITICAL);
		
		Client client =new Client();
		client.save(question);
		
		
		
		
		HibernateUtil.getSessionFactory().close();
		
	}
	
	public <T> void save(T t) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(t);
		
		
		tx.commit();
		session.close();
	}
	
	public <T> T  find(Long id, Class <T> c) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		T t =session.get(c,id);
		
		
		tx.commit();
		session.close();
		
		return t;
	}
}
