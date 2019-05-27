package bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Subject subject_id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Student student;
	
	@OneToOne	
	private Question question;
	
	private String writeOrwrong;
	
	private String selectedAns;
	
	private String date;

	/**
	 * @param subject_id
	 * @param student
	 * @param question
	 * @param writeOrwrong
	 * @param date
	 */
	public Answer(Subject subject_id, Student student, Question question, String writeOrwrong, String date, String selectedAns) {
		super();
		this.subject_id = subject_id;
		this.student = student;
		this.question = question;
		this.writeOrwrong = writeOrwrong;
		this.date = date;
		this.selectedAns = selectedAns;
	}

	/**
	 * 
	 */
	public Answer() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Subject getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Subject subject_id) {
		this.subject_id = subject_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getWriteOrwrong() {
		return writeOrwrong;
	}

	public void setWriteOrwrong(String writeOrwrong) {
		this.writeOrwrong = writeOrwrong;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSelectedAns() {
		return selectedAns;
	}

	public void setSelectedAns(String selectedAns) {
		this.selectedAns = selectedAns;
	}
		
}
