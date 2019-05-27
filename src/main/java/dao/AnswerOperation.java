package dao;

import java.util.List;

import bean.Answer;
import bean.Question;
import bean.Student;

public interface AnswerOperation {

	public long insert(Answer answer);
	
	public long upDate(long id, Answer answer);
	
	public boolean delete(long id);
	
	public Answer selectAnswer(long id);
	
	public List<Answer> selectAllAnswer();
	
	public Answer selectByQuestion(Question question);
	
	public List<Answer> searchByStudent(Student student);
	
	public List<Answer> wrongOrRight(String wrongOrRight);
	
	public List<Answer> wrongOrRight(String wrongOrRight, Student studnet );
	
	
}
