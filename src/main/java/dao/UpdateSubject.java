package dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectOperation;
import dao.SubjectOperationImp;

/**
 * Servlet implementation class UpdateSubject
 */
public class UpdateSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		
		String name = request.getParameter("name");
		
		int subMaxMark = Integer.parseInt(request.getParameter("maxMark"));
		int totalQuestion = Integer.parseInt(request.getParameter("totalQuesion"));
		int duration = Integer.parseInt(request.getParameter("subjectDuration"));
		int fees = Integer.parseInt(request.getParameter("subjectFees"));
		int subPassMark = Integer.parseInt(request.getParameter("passMark"));
		
		Subject s = new Subject(name, subMaxMark, totalQuestion, duration, fees, subPassMark);
		
		
		
		
		SubjectOperation sop = new SubjectOperationImp();
		long u_id = sop.upDate(id, s);
		System.out.println(u_id);
		
		response.sendRedirect("http://localhost:8080/onlineExam/AdminPanal/ShowAllSubjects.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
