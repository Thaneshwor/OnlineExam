package dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Query;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.jdbc.ha.ReplicationMySQLConnection;

import bean.Student;
import bean.Subject;

public class StudentOperationImp implements StudentOperation {

	private Session currentSession;
	private Transaction currentTran;

	public long insertStudent(Student s) {

		Long id = 0l;
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			id = (Long) currentSession.save(s);

			currentTran.commit();
		} catch (Exception e) {
			System.out.println("Error occure here");
			//
			// if (currentTran != null) {
			// currentTran.rollback();
			// }
		} finally {
			if (currentSession != null) {
				currentSession.close();
			}
		}

		return id;

	}

	public long upDate(long id, Student s) {

		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			Student student = (Student) currentSession.get(Student.class, id);
			student.setName(s.getName());
			student.setContact(s.getContact());
			student.setCourse(s.getCourse());
			student.setEmail(s.getEmail());
			student.setFees(s.getFees());
			student.setUsername(s.getUsername());
			// student.setSubjects(s.getSubjects());
			student.setSubjects(s.getSubjects());

			currentSession.clear();
			currentSession.update(student);

			id = student.getS_id();
			currentTran.commit();

		} catch (Exception e) {

			if (currentTran != null) {
				System.out.println("rollback");
				currentTran.rollback();
			}
		} finally {
			if (currentSession != null) {
				System.out.println("finally");
				currentSession.close();
			}
		}

		return id;

	}

	public boolean delete(long id) {
		boolean result;
		long del_id = 0;
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			Student student = (Student) currentSession.get(Student.class, id);

			org.hibernate.query.Query deleteEntite = currentSession.createQuery("delete Student where id=:s_id")
					.setParameter("s_id", id);
			del_id = deleteEntite.executeUpdate();
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
		if (del_id > 0) {
			return true;
		}
		return false;
	}

	public Student selectStudent(long id) {

		Student student = null;
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			student = (Student) currentSession.get(Student.class, id);
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

		return student;
	}

	public ArrayList<Student> selectAllStudents() {

		List<Student> students = null;
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			String hql = "from bean.Student";
			Query query = currentSession.createQuery(hql);
			students = ((org.hibernate.query.Query) query).list();

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

		if (students!=null) {
			return (ArrayList<Student>) students;
		}
		return null;
	}

	public ArrayList<Student> searchByName(String name) {

		List<Student> students = null;
		try {

			SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
			currentSession = sf.openSession();

			currentTran = currentSession.beginTransaction();

			Criteria cirteria = currentSession.createCriteria(Student.class);
			cirteria.add(Restrictions.like("name", "%" + name + "%"));

			students = cirteria.list();

			//
			// Query queryObject = currentSession.createQuery("from Student where name like
			// '%"+name+"%' order by "+name+"+");
			// students = ((org.hibernate.query.Query) queryObject).list();
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

		if (students.size() > 0) {
			return (ArrayList<Student>) students;
		}
		return null;
	}

	public Student ValidUsernamePassword(String username, String password) {
	
	List<Student> records = null;
	Student s = null;
	try {

		SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();
		currentSession = sf.openSession();

		currentTran = currentSession.beginTransaction();
		
	
	
	
	Criteria cirteria = currentSession.createCriteria(Student.class);
	cirteria.add(Restrictions.like("username", username));
	
	records = cirteria.list();
	
	s = records.get(0);
  

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
	if(s.getPassword().equals(password)) {
		return s;
	}

	return null;
}



public static void main(String[] args) {
		
		System.out.println("hello");
		
		StudentOperation st = new StudentOperationImp();
		System.out.println("hello");
	//	boolean b = st.isValidUsernamePassword("Khagesh", "2r22222");
		
		
		//System.out.println("Khages is valid user: "+ b);
		
		
	}

}
