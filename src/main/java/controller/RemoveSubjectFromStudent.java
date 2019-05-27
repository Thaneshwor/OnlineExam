package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
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

/**
 * Servlet implementation class RemoveSubjectFromStudent
 */
public class RemoveSubjectFromStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RemoveSubjectFromStudent() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
		
		SubjectOperation sub_op = new SubjectOperationImp();
		StudentOperation stud_op = new StudentOperationImp();
		
		long s_id = Long.parseLong(request.getParameter("id"));
		
		Student student = null;
		Subject subject = null;
		
		
		if(request.getParameter("removeSubject")!=null) {
			
			Enumeration<String> parameter =  request.getParameterNames();
			
			while(parameter.hasMoreElements()) {
				
				
				String pname = parameter.nextElement();
				
				if(!(pname.equals("removeSubject"))) {
					if(!(pname.equals("id"))) {
						
						
						long sub_id = Long.parseLong(request.getParameter(pname));
						student = (Student)stud_op.selectStudent(s_id);
						subject = (Subject)sub_op.selectSubject(sub_id);
						

						
						
						student.getSubjects().remove(subject);
						
						                               
						
					}
					
				}
			}
	
			
			
			Set<Subject> li =  student.getSubjects();
			
			for(Subject ssss : li) {
				out.println(ssss.getName());
			}
			
			out.println("----------after--------------");
			
			
			long return_id = stud_op.upDate(s_id, student);
			
			
			student = (Student)stud_op.selectStudent(s_id);
		
			li =  student.getSubjects();
			
			for(Subject ssss : li) {
				out.println(ssss.getName());
			}
			
			
		
			
			if(return_id > 0) {
				
				//response.sendRedirect("http://localhost:8080/onlineExam/AdminPanal/UpdateStudent.jsp?id="+s_id);
				
			}
			
		}
		
		
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
