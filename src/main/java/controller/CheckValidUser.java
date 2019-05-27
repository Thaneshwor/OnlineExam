package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentOperation;
import dao.StudentOperationImp;

/**
 * Servlet implementation class CheckValidUser
 */
public class CheckValidUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckValidUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		StudentOperation so = new StudentOperationImp();
		Student s = so.ValidUsernamePassword(username, password);
		
		 if(s!= null){
			 
			 ServletContext sc = getServletContext();
			 sc.setAttribute("username", username);
			 sc.setAttribute("s_id", s.getS_id());
			 request.setAttribute("loginstatus", "Login Successful.");
			 
			 getServletContext().getRequestDispatcher("http://localhost:8080/onlineExam/Profile.jsp").forward(request, response);
		 }else{
			 
			   request.setAttribute("loginstatus", "Username/Password do not match.");
			   getServletContext().getRequestDispatcher("/LogIn.jsp").forward(request, response);
		 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.println("Usernaem : "+ username);
//		out.println("Password :"+ password);
		doGet(request, response);
	}

}
