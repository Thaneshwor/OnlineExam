package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Query;
import javax.transaction.Transactional.TxType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import bean.Student;
import bean.Subject;

public class SubjectOperationImp implements  SubjectOperation {


	private Session currentSession;
	private Transaction currentTran;

	
	
	/**
	 * 
	 */
	public SubjectOperationImp() {
		
	}

	public long insertSubject(Subject s) {
		SessionFactory sf= helpingClasses.SessionFact.getSessionFactory();
		Session session = sf.openSession();
		
		Long id = 0l;
		Transaction tx ;
		try {

			
			tx = session.beginTransaction();

			id = (Long) session.save(s);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Error occure while saving subject");
			
			
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return id;
		
		
		
	}

	public long upDate(long id, Subject s) {
		
		long id1 = 0l;
		
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			Subject subject = currentSession.get(Subject.class, id);
			subject.setName(s.getName());
			subject.setDuration(s.getDuration());
			subject.setFees(s.getFees());
			subject.setSubMaxMark(s.getSubMaxMark());
			subject.setSubPassMark(s.getSubPassMark());
			subject.setTotalQuestion(s.getTotalQuestion());
			
			currentSession.update(subject);
			id1 = subject.getSub_id();
			currentTran.commit();
			

		} catch (Exception e) {
			System.out.println(e);

			if (currentTran != null) {
				currentTran.rollback();
			}
		} finally {
			
			if (currentSession != null) {
				currentSession.close();
			}
		}

	
		return id1;
	}

	public boolean delete(long id) {
	
		Subject subject = null;
		int d_id = 0;
		
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			subject = (Subject) currentSession.get(Subject.class, id);
			currentSession.delete(subject);
			currentTran.commit();
		} catch (Exception e) {

			if (currentTran != null) {
				currentTran.rollback();
			}
		} finally {
			if (currentSession != null) {
				currentSession.close();
			}
		}
		
		if(subject.getSub_id() > 0) {
			return true;
		}
		return false;
	}

	public Subject selectSubject(long id) {
		
		Subject subject = null;
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			subject = (Subject) currentSession.get(Subject.class, id);
			currentTran.commit();
		} catch (Exception e) {

			if (currentTran != null) {
				currentTran.rollback();
			}
		} finally {
			if (currentSession != null) {
				currentSession.close();
			}
		}

		return subject;
		
	
	}

	public ArrayList<Subject> selectAllSubject() {
		
		List results = new ArrayList<Subject>();
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

//			String hql = "from bean.Subject";
//			Query query = currentSession.createQuery(hql);
//			subjects = ((org.hibernate.query.Query) query).list();

			
			Criteria cr = currentSession.createCriteria(Subject.class);
			results = cr.list();
			currentTran.commit();
			System.out.println(results.size());

		} catch (Exception e) {
			System.out.println(e);

			if (currentTran != null) {
				currentTran.rollback();
			}
		} finally {
			
			if (currentSession != null) {
				currentSession.close();
			}
		}

		if (results.size() > 0) {
			 return (ArrayList<Subject>) results;
		}
		else {
			System.out.println("Subject list is empty");
		}
	
		return null;
		
	}

	public ArrayList<Subject> searchByName(String name) {

		List<Subject> subjects = null;
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();
			

			Criteria cirteria = currentSession.createCriteria(Subject.class);
			cirteria.add(Restrictions.like("name", "%"+name+"%"));
			
			subjects = cirteria.list();
			
			
//
//			Query queryObject = currentSession.createQuery("from Student where name like '%"+name+"%' order by "+name+"+");
//			students = ((org.hibernate.query.Query) queryObject).list();
//			
//			
			currentTran.commit();

		} catch (Exception e) {

			if (currentTran != null) {
				currentTran.rollback();
			}
		} finally {
			if (currentSession != null) {
				currentSession.close();
			}
		}

		if (subjects.size() > 0) {
			return (ArrayList<Subject>) subjects;
		}
		return null;
	}
	
	
	public Subject searchById(long id) {
		
		
		Subject subject = null;
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();


			subject = (Subject) currentSession.get(Subject.class, id);
			
			
			currentTran.commit();
			

		} catch (Exception e) {
			System.out.println(e);

			if (currentTran != null) {
				currentTran.rollback();
			}
		} finally {
			
			if (currentSession != null) {
				currentSession.close();
			}
		}

		if(subject != null) {
			return subject;
		}

	
		return null;
	}

	
	public static void main(String[] args) {
		
		System.out.println("hello");
		
		SubjectOperation st = new SubjectOperationImp();
		System.out.println("hello");
		ArrayList<Subject> li = st.selectAllSubject();
		System.out.println("hello");
		
		
		System.out.println(li);
		
		
	}

//	public Student ValidUsernamePassword(String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
