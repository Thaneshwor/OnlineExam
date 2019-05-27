package bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Student {


		@Id
		@GeneratedValue
		@Column(name="S_ID")
		private Long s_id;

		@Column(name="NAME")
		private String name;
	
	@Column(name="CONTACT")
	private String contact;
	
	@Column(name="COURSE")
	private String course;
	
	@Column(name="ADMISSION_DATE")
	private String admission_date;
	
	@Column(name="FEES")
	private int fees;
	
	@Column(name="EMAIL")
	private String email;
	
	

	@Column(unique=true, nullable=false, name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	

	
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="STUDENT_SUBJECT", joinColumns= { @JoinColumn(name="S_ID")}, inverseJoinColumns= {@JoinColumn(name="SUB_ID")})
	Set<Subject> subjects = new HashSet<Subject>();
	
	
	

	
	public Student(String name, String contact, String course, String admission_date, int fees, String email,
			String username, String password) {
		
		
		this.name = name;
		this.contact = contact;
		this.course = course;
		this.admission_date = admission_date;
		this.fees = fees;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getS_id() {
		return s_id;
	}

	public void setS_id(Long s_id) {
		this.s_id = s_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAdmission_date() {
		return admission_date;
	}

	public void setAdmission_date(String admission_date) {
		this.admission_date = admission_date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}  
	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}


	public Set<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	

}
