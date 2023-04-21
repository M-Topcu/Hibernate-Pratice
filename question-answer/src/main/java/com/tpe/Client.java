package com.tpe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpe.domain.Question;
import com.tpe.domain.QuestionDetail;
import com.tpe.domain.enums.QuestionPriority;
import com.tpe.service.IQuestionDetailService;
import com.tpe.service.IQuestionService;
import com.tpe.service.QuestionDetailService;
import com.tpe.service.QuestionService;
import com.tpe.util.HibernateUtil;

public class Client {
	
	static IQuestionService qService = new QuestionService();
	static IQuestionDetailService qDService = new QuestionDetailService();
	
	public static void main(String[] args) {
		
		Question question = new Question();
		question.setName("What is Hibernate");
		question.setPriority(QuestionPriority.CRITICAL);
		
		Client client =new Client();
//		client.saveQuestion(question);
		
		Question questionFound = client.findQuestion(100L);
		
		QuestionDetail detail = new QuestionDetail();
		detail.setDescription("It is about oop concept");
		detail.setQuestion(questionFound);
		
		client.saveQuestionDetail(detail);
		
		
		
		HibernateUtil.getSessionFactory().close();
		
	}
	
	private Question findQuestion(Long id) {
		return qService.find(id);
		}

	private void saveQuestion(Question question) {
		qService.save(question);
		}
	
	private void saveQuestionDetail(QuestionDetail questionDetail) {
		qDService.save(questionDetail);
		}

	
//	public <T> void save(T t) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		session.save(t);
//		
//		
//		tx.commit();
//		session.close();
//	}
//	
//	public <T> T  find(Long id, Class <T> c) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		T t =session.get(c,id);
//		
//		
//		tx.commit();
//		session.close();
//		
//		return t;
//	}
}
