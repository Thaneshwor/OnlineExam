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
 * Servlet implementation class AddQuestion
 */
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddQuestion() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Long sub_id = Long.parseLong(request.getParameter("subject_id"));
		
		String question = request.getParameter("question");
		int mark = Integer.parseInt(request.getParameter("mark"));
		
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		
		String answer = request.getParameter("answer");
		
		
		OptionOperation opOp = new OptionOperationImpl();
		Option option = new Option(option1, option2, option3, option4);
		
	
		
		long o_id = opOp.insertOption(option);
		
		if(o_id > 0) {
			out.println("Option added");
		}
		
		
		
		QuestionOperation qo = new QuestionOperationImp();
		SubjectOperation so = new SubjectOperationImp();
		Subject subject = so.selectSubject(sub_id);
		
		Question questions = new Question(question, mark, answer, subject, option);
		
		
		long q_id = qo.insertQuestion(questions);
		
		if(q_id > 0) {
			
			
			
			out.println("Question added");
		}
		else {
			
			out.println("Question not added");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
