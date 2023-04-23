package com.tpe;

import java.util.List;

import com.tpe.dao.AnswerDao;
import com.tpe.domain.Answer;
import com.tpe.domain.Question;
import com.tpe.domain.QuestionDetail;
import com.tpe.domain.enums.QuestionPriority;
import com.tpe.service.AnswerService;
import com.tpe.service.IAnswerService;
import com.tpe.service.IQuestionDetailService;
import com.tpe.service.IQuestionService;
import com.tpe.service.QuestionDetailService;
import com.tpe.service.QuestionService;
import com.tpe.util.HibernateUtil;

public class Client {
	
	static IQuestionService qService = new QuestionService();
	static IQuestionDetailService qDService = new QuestionDetailService();
	static IAnswerService anService = new AnswerService();
	
	public static void main(String[] args) throws InterruptedException {
		
//		Question question = new Question();
//		question.setName("What is Hibernate");
//		question.setPriority(QuestionPriority.CRITICAL);
		
		Client client =new Client();
//		client.saveQuestion(question);
		
		Question questionFound = client.findQuestion(101L);
//		client.deleteQuestion(questionFound.getId());
		
//		Thread thead1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				Question q = new Question();
//				q.setName("What is thread?");
//				q.setPriority(QuestionPriority.HIGH);
//				client.saveQuestion(q);
//				
//			}
//		});
//		thead1.start();
//		
//		
//		Thread thead2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				Question q = new Question();
//				q.setName("What is NodeJS?");
//				q.setPriority(QuestionPriority.HIGH);
//				client.saveQuestion(q);
//				
//			}
//		});
//		
//		thead2.start();
		
//		QuestionDetail detail = new QuestionDetail();
//		detail.setDescription("It is about the relation");
//		detail.setQuestion(questionFound);
//		
//		client.saveQuestionDetail(detail);
		
//		Answer answer = new Answer();
//		answer.setName("Answer1");
//		answer.setDescription("There are a few relation such as: onetoone,onetomany,manytoone,manytomany");
//		answer.setQuestion(questionFound);
//		
//		client.saveAnswer(answer);
		
//		Answer answer2 = new Answer();
//		answer2.setName("Answer2");
//		answer2.setDescription("One you can create by uni and bi-directional onetoone relation");
//		answer2.setQuestion(questionFound);
//		
//		client.saveAnswer(answer2);
		
//		Answer findAnswer = client.findAnswer(121L);
//		findAnswer.setName("Answer3");
//		client.updateAnswer(findAnswer);
		
//		List<Answer> answerList = client.findAnswersByQId(101L);
//		
//		for (Answer answer : answerList) {
//			System.out.println(answer.getId()+" : "+answer.getName()+" : "+answer.getDescription());
//		}
		
//		Lazy olursa LazyInitalizationException verir
//		questionFound.getAnswerList().size();
		
//		thead1.join();
//		thead2.join();
		
		HibernateUtil.getSessionFactory().close();
		
	}
	
	private List<Answer> findAnswersByQId(Long id){
		return anService.getAllAnswerByQuestionId(id);
	}
	
	private void updateAnswer(Answer answer) {
		anService.update(answer);
	}
	
	private void saveAnswer(Answer answer) {
		anService.save(answer);
	}
	
	private Answer findAnswer(Long id) {
		return anService.find(id);
	}
	
	private Question findQuestion(Long id) {
		return qService.find(id);
		}

	private /*synchronized*/ void saveQuestion(Question question) {
		qService.save(question);
		}
	
	private void saveQuestionDetail(QuestionDetail questionDetail) {
		qDService.save(questionDetail);
		}
	
	private void deleteQuestion(Long id) {
		qService.delete(id);
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
