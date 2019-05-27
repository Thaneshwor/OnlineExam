<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Subject"%>
<%@page import="java.util.Set"%>
<%@page import="dao.SubjectOperationImp"%>
<%@page import="dao.SubjectOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Question Form</title>
<%@include file="../common/common_link_homepage"%>
</head>
<body>
	<%@ include file="header.html"%>
	<h1>Add Question Form</h1>
	<div class="container">
		<form action="http://localhost:8080/onlineExam/AddQuestion" method="get">

		
			Select Subject:
			<select name="subject_id">
				  <%
				  	SubjectOperation so = new SubjectOperationImp();
				  		
				  	if(so.selectAllSubject() != null){
				  		
				  		List<Subject> li = so.selectAllSubject();
				  		ListIterator itr = li.listIterator();
				  		
				  		while(itr.hasNext()){
				  			Subject sub =(Subject) itr.next();
				  			
				  			
				  			
				  	%>
				  			<option value="<%= sub.getSub_id()%>"><%= sub.getName() %></option>	
				  		
				  	<%
				  		}
				  		
				  	}
				
						  
				  %>
				  				  
				 
			</select>
			<hr>
			
			<div class="form-group">
				<label for="formGroupExampleInput2">Question </label> <input
					type="text" class="form-control"
					placeholder="Enter Question" name="question">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput">Question Mark</label> <input
					type="text" class="form-control"
					placeholder="Enter mark" name="mark">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Option 1</label> <input
					type="text" class="form-control" 
					placeholder="Enter option 1" name="option1">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput">Option 2</label> <input
					type="text" class="form-control" 
					placeholder="Enter option 2" name="option2">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Option 3</label> <input
					type="text" class="form-control" 
					placeholder="Enter option 3" name="option3">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput">Option 4</label> <input
					type="text" class="form-control" 
					placeholder="Enter option 4" name="option4">
			</div>
			<div class="form-group">
				<label for="formGroupExampleInput2">Answer</label> <input
					type="text" class="form-control"
					placeholder="Enter answer" name="answer">
			</div>

			<div class="form-group row">
				<label class="col-lg-3 col-form-label form-control-label"></label>
				<div class="col-lg-9">
					<input type="reset" class="btn btn-secondary" value="Cancel">
					<input type="submit" class="btn btn-primary" value="add">
				</div>
			</div>
		</form>
		
		
		<h1 style="color:red">
			<!--  %= request.getParameter("result")!= null? request.getParameter("result") : "" %-->
		
		</h1>
	</div>
</body>
</html>