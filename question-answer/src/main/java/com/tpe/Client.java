package com.tpe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpe.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		
	}
	
	public void saveQuestion() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		tx.commit();
		session.close();
	}
}
