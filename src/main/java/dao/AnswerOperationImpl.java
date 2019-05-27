package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bean.Answer;
import bean.Question;
import bean.Student;

public class AnswerOperationImpl implements AnswerOperation {

	SessionFactory sf;
	Session session;
	Transaction tx;
	
	
	
	/**
	 * 
	 */
	public AnswerOperationImpl() {
		super();
	
		sf = helpingClasses.SessionFact.getSessionFactory();
		session = sf.openSession();
	}

	public long insert(Answer answer) {
		
		tx = session.beginTransaction();
		
		try {
			long l = (Long) session.save(answer);
			tx.commit();
			return l;
		} catch (Exception e) {
			System.out.println("rollback---------------------------------");
			tx.rollback();
			return 0;
		}
	
	}

	public long upDate(long id, Answer answer) {
		
		
		tx = session.beginTransaction();
		
		answer.setId(id);
		
		try {
			session.update(answer);
			tx.commit();
			return id;
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return 0;
	}

	public boolean delete(long id) {

		tx = session.beginTransaction();
		
		Answer answer = session.get(Answer.class, id);
		
		
		try {
			session.delete(answer);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}

	public Answer selectAnswer(long id) {
		
		String hql = "select form Answer where id ="+id;
		
		Query query = session.createQuery(hql);
		
		Answer answer = (Answer)((org.hibernate.query.Query) query).uniqueResult();
		
		if(answer != null) {
			return answer;
		}
		return null;
	}

	public List<Answer> selectAllAnswer() {

		String hql = "from bean.Answer";
		Query query = session.createQuery(hql);
		
		List<Answer> answers = query.getResultList();
		
		if(answers != null) {
			System.out.println("return answer ");
			return answers;
		}
		System.out.println("return null");
		
		return null;
	}

	public Answer selectByQuestion(Question question) {

		Criteria criteria = session.createCriteria(Answer.class);
		criteria.add(Restrictions.eq("question", question));
		
		Answer answer =(Answer) criteria.uniqueResult();
		
		if(answer != null) {
			return answer;
		}
		return null;
	}

	public List<Answer> searchByStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Answer> wrongOrRight(String wrongOrRight) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Answer> wrongOrRight(String wrongOrRight, Student studnet) {
		// TODO Auto-generated method stub
		return null;
	}

}
