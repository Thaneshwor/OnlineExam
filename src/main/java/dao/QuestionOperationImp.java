package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;

import bean.Option;
import bean.Question;
import bean.Student;
import bean.Subject;

public class QuestionOperationImp implements QuestionOperation {

	SessionFactory sf;
	Session session;
	Transaction tx;

	public QuestionOperationImp() {
		sf = helpingClasses.SessionFact.getSessionFactory();
		session = sf.openSession();
	}

	public long insertQuestion(Question q) {

		long id = 0l;
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			id = (Long) session.save(q);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Error occure while saving subject");
			if (tx != null) {
				System.out.println("rollback");
				tx.rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}

		}

		return id;
	}

	public long upDate(long q_id, Question q) {
		long id1 = 0l;

		Question question = session.get(Question.class, q_id);

		try {

			tx = session.beginTransaction();

			question.setSubject(q.getSubject());
			question.setQuestion(q.getQuestion());
			question.setAnswer(q.getAnswer());
			question.setMark(q.getMark());

			session.update(question);

			tx.commit();

		} catch (Exception e) {
			System.out.println(e);

			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (session != null) {
				session.close();
			}
		}

		return id1;

	}

	public boolean delete(long id) {

		try {
			tx = session.beginTransaction();
			Question question = session.get(Question.class, id);

			session.delete(question);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Error occure while saving subject");
			if (tx != null) {
				System.out.println("rollback");
				tx.rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}

		}

		return false;
	}

	public Question selectQuestion(long id) {

		Transaction tx = session.beginTransaction();
		Question q = session.get(Question.class, id);

		tx.commit();
		if (q != null) {
			return q;
		}

		return null;
	}

	public ArrayList<Question> selectAllQuestion() {
		List<Question> questions = null;
		try {

			tx = session.beginTransaction();

			Criteria cr = session.createCriteria(Question.class);
			questions = cr.list();
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				System.out.println("Roll Back-----------------" + e);
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (questions.size() > 0) {
			return (ArrayList<Question>) questions;
		}
		return null;

	}

	public ArrayList<Question> searchByName(String name) {

		return null;
	}

	public Question searchById(long id) {

		tx = session.beginTransaction();
		Question q = session.get(Question.class, id);

		if (q != null) {
			return q;
		}
		return null;
	}

	public List<Question> selectBySubjcet(Subject sub) {

		tx = session.beginTransaction();

		Criteria cr = session.createCriteria(Question.class);
		// Add restriction.
		cr.add(Restrictions.eq("subject", sub));
		List results = cr.list();
		tx.commit();
		return results;
	}

	public static void main(String[] args) {
		QuestionOperation qo = new QuestionOperationImp();
		Subject sub = new SubjectOperationImp().searchById(3);

		List<Question> list = qo.selectBySubjcet(sub);

		ListIterator<Question> lit = list.listIterator();

		while (lit.hasNext()) {
			System.out.println(lit.next().getQuestion());
		
		}

	}

	public List<Question> selectNotIn(Subject subject, Student student) {
		
		String hql = "from Question where que_id not in( select question from Answer where student="+student.getS_id()+" and subject_id"
				+ "="+subject.getSub_id()+")";
		Query query = session.createQuery(hql);
		
		List<Question> questions = query.getResultList();
		
		if(questions.size()>0) {
			System.out.println("list with data");
			return questions;
		}
		System.out.println("list without data");
		return null;
	}

}
