package bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;

@Entity
public class Option {

	@Id
	@GeneratedValue
	private long op_id;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;

	
	@OneToOne( mappedBy="option")
	private Question question;
	
	
	
	/**
	 * 
	 */
	public Option() {
		
	}

	/**
	 * @param op_id
	 * @param option1
	 * @param option2
	 * @param option3
	 * @param option4
	 */
	public Option( String option1, String option2, String option3, String option4) {
		
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}

	public long getOp_id() {
		return op_id;
	}

	public void setOp_id(long op_id) {
		this.op_id = op_id;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question_no) {
		this.question = question_no;
	}
	
	
	
}
