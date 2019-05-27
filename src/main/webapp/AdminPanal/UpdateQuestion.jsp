<%@page import="bean.Option"%>
<%@page import="dao.QuestionOperationImp"%>
<%@page import="dao.QuestionOperation"%>
<%@page import="bean.Question"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.SubjectOperationImp"%>
<%@page import="dao.SubjectOperation"%>
<%@page import="bean.Subject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="header.html"%>
	<h1>Update Question Form</h1>

	<%
		Long q_id = Long.parseLong(request.getParameter("id"));
		if (q_id > 0) {
			
			
	%>


	<div class="container">
		<form action="http://localhost:8080/onlineExam/UpdateQuestion" method="get">


			Select Subject: <select name="subject_id">
				<%
					SubjectOperation so = new SubjectOperationImp();
						QuestionOperation qo = new QuestionOperationImp();
						Question q = qo.searchById(q_id);
						Option opt = q.getOption();
						long o_id = opt.getOp_id();
						if (so.selectAllSubject() != null) {

							List<Subject> li = so.selectAllSubject();
							ListIterator itr = li.listIterator();
				%>
				<option value="<%=q.getSubject().getSub_id()%>" selected="selected"><%=q.getSubject().getName()%></option>
				<%
					while (itr.hasNext()) {
								Subject sub = (Subject) itr.next();
				%>
				<option value="<%=sub.getSub_id()%>"><%=sub.getName()%></option>

				<%
					}

						}
				%>


			</select>
			<hr>

			<input type="hidden" value="<%=q_id %>" name="q_id"/>
			<input type="hidden" value="<%=  o_id %>" name="o_id"/>
			<div class="form-group">
				<label for="formGroupExampleInput2">Question </label> <input
					type="text" class="form-control" value="<%=q.getQuestion()%>"
					name="question">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput">Question Mark</label> <input
					type="text" class="form-control" value="<%=q.getMark()%>"
					name="mark">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Option 1</label> <input
					type="text" class="form-control" value="<%=opt.getOption1()%>"
					name="option1">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput">Option 2</label> <input
					type="text" class="form-control" value="<%=opt.getOption2()%>"
					name="option2">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Option 3</label> <input
					type="text" class="form-control" value="<%=opt.getOption3()%>"
					name="option3">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput">Option 4</label> <input
					type="text" class="form-control" value="<%=opt.getOption4()%>"
					name="option4">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Answer</label> <input
					type="text" class="form-control" value="<%=q.getAnswer()%>"
					name="answer">
			</div>

			<div class="form-group row">
				<label class="col-lg-3 col-form-label form-control-label"></label>
				<div class="col-lg-9">
					<input type="reset" class="btn btn-secondary" value="Cancel">
					<input type="submit" class="btn btn-primary" value="Update" >
				</div>
			</div>
		</form>

		<%
			}

			else {
		%>

		<h1 style="color: red">
			No Data Found
			<!--  %= request.getParameter("result")!= null? request.getParameter("result") : "" %-->

		</h1>
		<%
			}
		%>

	</div>
</body>
</html>