package dao;

import java.util.ArrayList;

import bean.Student;

public interface StudentOperation {

	public long insertStudent(Student s);
	
	public long upDate(long id, Student s);
	

	
	public boolean delete(long id);
	
	public Student selectStudent(long id);
	
	public ArrayList<Student> selectAllStudents();
	
	public ArrayList<Student> searchByName(String name);
	
	public Student ValidUsernamePassword(String uname, String psw);
}
