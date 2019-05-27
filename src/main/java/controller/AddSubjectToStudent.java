package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.Subject;
import dao.StudentOperation;
import dao.StudentOperationImp;
import dao.SubjectOperation;
import dao.SubjectOperationImp;



public class AddSubjectToStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
    public AddSubjectToStudent() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		SubjectOperation sub_op = new SubjectOperationImp();
		StudentOperation stud_op = new StudentOperationImp();
		
		long s_id = Long.parseLong(request.getParameter("id"));
		
		Student student = null;
		Subject subject = null;
		
		
		if(request.getParameter("addSubject")!=null) {
			
			Enumeration<String> parameter =  request.getParameterNames();
			
			
			while(parameter.hasMoreElements()) {
				
				
				String pname = parameter.nextElement();
				
				if(!(pname.equals("addSubject"))) {
					if(!(pname.equals("id"))) {
						
						
						long sub_id = Long.parseLong(request.getParameter(pname));
						
						subject = (Subject)sub_op.selectSubject(sub_id);
						
						student = (Student)stud_op.selectStudent(s_id);
					
						student.getSubjects().add(subject);
					}
					
				}
			}
			
		
			long return_id = stud_op.upDate(s_id, student);
			
			
			if(return_id > 0) {
				
				
				response.sendRedirect("http://localhost:8080/onlineExam/AdminPanal/UpdateStudent.jsp?id="+s_id);
			}
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
