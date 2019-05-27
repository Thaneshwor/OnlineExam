package bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private long que_id;
	
	private String question;
	
	private int mark;
	
	private String answer;

	
	@ManyToOne
	private Subject subject;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private Option option;
	
	
	/**
	 * @param question
	 * @param mark
	 * @param answer
	 * @param subject
	 * @param option
	 */
	public Question(String question, int mark, String answer, Subject subject, Option option) {
		super();
		this.question = question;
		this.mark = mark;
		this.answer = answer;
		this.subject = subject;
		this.option = option;
	}

	

	/**
	 * 
	 */
	public Question() {
		
	}



	public long getQue_id() {
		return que_id;
	}

	public void setQue_id(long que_id) {
		this.que_id = que_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}
	

	
}
