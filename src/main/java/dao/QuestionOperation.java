package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import bean.Option;
import bean.Question;
import bean.Student;
import bean.Subject;


public interface QuestionOperation {

	public long insertQuestion(Question q);
	
	public long upDate(long q_id, Question s);

	public boolean delete(long id);
	
	public Question selectQuestion(long id);
	
	public ArrayList<Question> selectAllQuestion();
	
	public ArrayList<Question> searchByName(String name);
	
	public Question searchById(long id);
	
	public List<Question> selectBySubjcet(Subject sub);
	
	public List<Question> selectNotIn(Subject subject, Student student);
}
