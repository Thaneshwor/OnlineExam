package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import com.mysql.cj.jdbc.ha.ReplicationMySQLConnection;

import bean.Question;
import dao.OptionOperation;
import dao.OptionOperationImpl;
import dao.QuestionOperation;
import dao.QuestionOperationImp;
import helpingClasses.SessionFact;

/**
 * Servlet implementation class Test
 */

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory sf = helpingClasses.SessionFact.getSessionFactory();

		PrintWriter out = response.getWriter();
		QuestionOperation qo = new QuestionOperationImp();

		ArrayList li = qo.selectAllQuestion();

		if (li != null) {

			ListIterator lit = li.listIterator();

			while (lit.hasNext()) {

				Question q = (Question) lit.next();
				out.println(q.getQuestion());

			}

		}

		
		out.println("Hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
