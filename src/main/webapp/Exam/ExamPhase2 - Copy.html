<%@page import="bean.Student"%>
<%@page import="dao.StudentOperation"%>
<%@page import="dao.StudentOperationImp"%>
<%@page import="bean.Option"%>
<%@page import="bean.Question"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.SubjectOperationImp"%>
<%@page import="bean.Subject"%>
<%@page import="dao.QuestionOperationImp"%>
<%@page import="dao.QuestionOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head >
<body style="bg-color:blue">

<div class="container">

	<%
	HttpSession session1 = request.getSession();
		int ques_no = 0;
	
		if(request.getParameter("submit") != null){
			
			System.out.println("woks 1============================");
			
			long sub_id = Long.parseLong(request.getParameter("subject"));
			System.out.println("woks 2============================");
			long stud_id = Long.parseLong(session1.getAttribute("s_id").toString());
			System.out.println("woks 3============================");
			QuestionOperation qo = new QuestionOperationImp();
			System.out.println("woks 4============================");
			StudentOperation studOp = new StudentOperationImp();
			System.out.println("woks 5============================");
			Subject subject = new SubjectOperationImp().searchById(sub_id);
			System.out.println("woks 6============================");
			Student student = studOp.selectStudent(stud_id);
	%>
			<h1>Subject Id:<%= sub_id %>)Subject Name:<%= subject.getName() %> </h1>
	<%
			
			if(qo.selectNotIn(subject, student) != null){
				
				List<Question> questions = qo.selectNotIn(subject, student);
				
				ListIterator<Question> itr = questions.listIterator();
	%>
	
			<%
				while(itr.hasNext()){
					ques_no++;
					
					Question question = (Question)itr.next();
					
					Option option = question.getOption();
					
					%>
					<form action="http://localhost:8080/onlineExam/CheckandStore" method="post">
					
						
						<%=ques_no %>: <%= question.getQuestion() %><span class="badge "> ---marks: <%= question.getMark()%></span>
							<ul class="list-group">
								<li class="list-group-item"><input type="radio" value="<%= option.getOption1()%>" name="SelectedAnswer"><%= option.getOption1()%></li>
								<li class="list-group-item"><input type="radio" value="<%= option.getOption2()%>" name="SelectedAnswer"><%= option.getOption2()%></li>
								<li class="list-group-item"><input type="radio" value="<%= option.getOption3()%>" name="SelectedAnswer"><%= option.getOption3()%></li>
								<li class="list-group-item"><input type="radio" value="<%= option.getOption4()%>" name="SelectedAnswer"><%= option.getOption4()%></li>
							
							</ul>
							
							<ul class="pager">
								<input type="hidden" value="<%= question.getQue_id()%>" name="q_id">
								<input type="hidden" value="<%= subject.getSub_id() %>" name="sub_id">
								
								<input type="submit" value="Ok"></buttton>	
								
							
							</ul>
						
					</form>
					
					<%
				}
				
			
				}
		}
	
	
	
	%>
</div>
</body>
</html>