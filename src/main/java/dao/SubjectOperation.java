package dao;

import java.util.ArrayList;

import bean.Student;
import bean.Subject;

public interface SubjectOperation {

	public Subject searchById(long id);
	
	public long insertSubject(Subject s);
	
	public long upDate(long id, Subject s);
	
	public boolean delete(long id);
	
	public Subject selectSubject(long id);
	
	public ArrayList<Subject> selectAllSubject();
	
	public ArrayList<Subject> searchByName(String name);
	
	//public Student ValidUsernamePassword(String username, String password);
}
