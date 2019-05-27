
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.Subject;
import dao.SubjectOperation;
import dao.SubjectOperationImp;

/**
 * Servlet implementation class AddSubject
 */
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		
		 String name = request.getParameter("name");
		
		 int subMaxMark= Integer.parseInt(request.getParameter("maxMark")); 
		
		 int totalQuestion = Integer.parseInt(request.getParameter("totalQuesion"));
		
		 int duration = Integer.parseInt(request.getParameter("subjectDuration"));
		
		 int fees = Integer.parseInt(request.getParameter("subjectFees"));
		 
		 int subPassMark = Integer.parseInt(request.getParameter("passMark"));
		 Subject subject = new Subject(name, subMaxMark, totalQuestion, duration, fees, subPassMark);
		 
		 
		 SubjectOperation sub_op = new SubjectOperationImp();
		 long id = sub_op.insertSubject(subject);
		 
		 if(id > 0) {
			 PrintWriter out = response.getWriter();
			 out.println("Subject added Sucessfully");
		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
