package controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Answer;
import bean.Question;
import bean.Student;
import bean.Subject;
import dao.AnswerOperation;
import dao.AnswerOperationImpl;
import dao.QuestionOperation;
import dao.QuestionOperationImp;
import dao.StudentOperation;
import dao.StudentOperationImp;
import dao.SubjectOperation;
import dao.SubjectOperationImp;

/**
 * Servlet implementation class CheckandStore
 */
public class CheckandStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
    public CheckandStore() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		long stud_id = Long.parseLong(session.getAttribute("s_id").toString());
		
		//========================================
		
		long q_id = Long.parseLong(request.getParameter("q_id"));
		

		long sub_id = Long.parseLong(request.getParameter("sub_id"));
		
		
		
		String selectedAnswer = request.getParameter("SelectedAnswer");
		
		
		
		StudentOperation studOp = new StudentOperationImp();
		SubjectOperation subOp = new SubjectOperationImp();
		QuestionOperation qOp = new QuestionOperationImp();
		AnswerOperation aOp = new AnswerOperationImpl();
		
		Student stud = studOp.selectStudent(stud_id);
		Subject sub = subOp.searchById(sub_id);
		Question qsn = qOp.selectQuestion(q_id);
		
		String date = new Date().toString();
		
		String writeOrwrong = "wrong";
		
		
		if(selectedAnswer.equals(qsn.getAnswer())) {
			writeOrwrong = "Right";
		}
		
		Answer ans = new Answer(sub, stud, qsn, writeOrwrong, date, selectedAnswer);
		
		
		long a_id = aOp.insert(ans);
		
		if(a_id > 0) {
			
			out.println("Answer inserted into table");
		}
		else {
			out.println("Sorry Answer is not inserted into table");
		}
		response.sendRedirect("http://localhost:8080/onlineExam/Exam/ExamPhase2.jsp?subject=3&submit=select");
		
		
		
		//========================================
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

}
