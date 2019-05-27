package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Option;
import bean.Question;

public class OptionOperationImpl implements OptionOperation {

	SessionFactory sf ;
	Session session;
	Transaction tx;
	
	
	
	/**
	 * 
	 */
	public OptionOperationImpl() {
		
		sf = helpingClasses.SessionFact.getSessionFactory();
		session = sf.openSession();
		
	}

	public long insertOption(Option o) {
		long id = 0l;
		Transaction tx = null ;
		
		
		try {

			
			tx = session.beginTransaction();

			id = (Long) session.save(o);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Error occure while saving subject");
			if(tx != null) {
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

	public long upDate(long id, Option o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Option selectOption(long id) {
		Transaction tx = session.beginTransaction();
		Option q = session.get(Option.class, id);
		
		tx.commit();
		if(q != null) {
			return q;
		}
		
		return null;
	}

	public ArrayList<Option> selectAllOption() {
		List<Option> options = null;
		try {

			

			tx = session.beginTransaction();

			String hql = "from bean.Option";
			Query query = session.createQuery(hql);
			options = ((org.hibernate.query.Query) query).list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (options.size() > 0) {
			return (ArrayList<Option>) options;
		}
		return null;
	}

	public ArrayList<Option> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
