package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentOperation;
import dao.StudentOperationImp;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("There is something wrong");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		 String name = request.getParameter("name");
		
		 String contact = request.getParameter("content");
		
		 String course = request.getParameter("course");
		
		 String admission_date = request.getParameter("admissiondate");
		
		 int fees = Integer.parseInt(request.getParameter("fees"));
		
		 String email = request.getParameter("email");

		 String username = request.getParameter("username");
		
		 String password = request.getParameter("password");
		 
		 Student student = new Student(name, contact, course, admission_date, fees, email, username, password);
		 
		 StudentOperation so = new StudentOperationImp();
		 long id = so.insertStudent(student);
		 
		 if(id > 0) {
			 response.sendRedirect("http://localhost:8080/onlineExam/AdminPanal/ShowAllStudents.jsp");
		 }
		 else {
			 out.println("There is something wrong");
		 }
	}

}
