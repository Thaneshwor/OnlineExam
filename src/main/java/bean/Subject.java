package bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	@Id
	@GeneratedValue
	@Column(name="SUB_ID")
	private long sub_id;
	
	@Column(unique=true, nullable=false, name="SUB_NAME")
	private String name;
	
	@Column(name="SUB_MAX_MARK")
	private int subMaxMark;
	
	@Column(name="SUB_PASS_MARK")
	private int subPassMark;
	
	@Column(name="TOTAL_QUESTION")
	private int totalQuestion;
	
	@Column(name="DURATION")
	private int duration;
	
	@Column(name="FEES")
	private int fees;
	
	
	@OneToMany(mappedBy="subject")
	private Set<Question> questions = new HashSet<Question>();
	

	/**
	 * 
	 */
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param name
	 * @param subMaxMark
	 * @param totalQuestion
	 * @param duration
	 * @param fees
	 */
	
	
	
	public Subject(String name, int subMaxMark, int totalQuestion, int duration, int fees, int subPassMark) {
		super();
		this.name = name;
		this.subMaxMark = subMaxMark;
		this.totalQuestion = totalQuestion;
		this.duration = duration;
		this.fees = fees;
		this.subPassMark = subPassMark;
	}

	
	public long getSub_id() {
		return sub_id;
	}

	public void setSub_id(long sub_id) {
		this.sub_id = sub_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSubMaxMark() {
		return subMaxMark;
	}

	public void setSubMaxMark(int subMaxMark) {
		this.subMaxMark = subMaxMark;
	}

	public int getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}


	public int getSubPassMark() {
		return subPassMark;
	}


	public void setSubPassMark(int subPassMark) {
		this.subPassMark = subPassMark;
	}


	public Set<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
	
	
}
