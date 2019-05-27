package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Option;
import bean.Question;
import bean.Subject;
import dao.OptionOperation;
import dao.OptionOperationImpl;
import dao.QuestionOperation;
import dao.QuestionOperationImp;
import dao.SubjectOperation;
import dao.SubjectOperationImp;

/**
 * Servlet implementation class UpdateQuestion
 */
public class UpdateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		Long sub_id = Long.parseLong(request.getParameter("subject_id"));
		
		long q_id = Long.parseLong(request.getParameter("q_id"));
		long o_id = Long.parseLong(request.getParameter("o_id"));
		
		
		String question = request.getParameter("question");
		int mark = Integer.parseInt(request.getParameter("mark"));
		
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		
		String answer = request.getParameter("answer");
		
		
		OptionOperation opOp = new OptionOperationImpl();
		Option option = new Option(option1, option2, option3, option4);
		
		opOp.upDate(o_id, option);
		
		
		
		
		QuestionOperation qo = new QuestionOperationImp();
		SubjectOperation so = new SubjectOperationImp();
		Subject subject = so.selectSubject(sub_id);
		
		Question questions = new Question(question, mark, answer, subject, option);
		
		
		qo.upDate(q_id,  questions);
		
		
			
			
		response.sendRedirect("http://localhost:8080/onlineExam/AdminPanal/ShowAllQuestion.jsp");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
