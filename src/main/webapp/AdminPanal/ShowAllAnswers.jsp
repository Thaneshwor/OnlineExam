<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="bean.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.AnswerOperationImpl"%>
<%@page import="dao.AnswerOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="../common/common_link_homepage" %>
</head>
<body>

<!-- ---------------------------------------------------------------- -->

<h1 class="container">User Entered Answer List</h1>

<div class="container">
 <table class="table table-dark ">
    <thead>
      <tr>
      		
			
      		<th>Answer Id</th>
      	 	<th>Question</th>
      	 	<th>Question Marks</th>
      	 	<th>Selected Answer</th>
      	 	<th>Is Wrong Or Right</th>
      	 	<th>Student </th> 
      	 	<th>Subject </th>
      	 
      	 	<th>Date</th>
			
			<th>Answer</th>	
        
      </tr>
    </thead>
    <tbody>
      
       <%
	
			AnswerOperation ao = new AnswerOperationImpl();
      		//OptionOperation oo = new OptionOperationImpl();
			List<Answer> li = ao.selectAllAnswer();
					
					
			if(li.size()> 0){
		
			ListIterator<Answer> lit = li.listIterator();
			
			while(lit.hasNext()){
		
		
			Answer ans = (Answer)lit.next();
			
			
		
		%>
		<tr>
			<td><%= ans.getId() %></td>
			<td><%= ans.getQuestion().getQuestion() %></td>
			<td><%= ans.getQuestion().getMark() %></td>
			<td><%= ans.getSelectedAns()%></td>
			<td><%= ans.getWriteOrwrong() %></td>
			<td><%= ans.getStudent().getName() %></td>
			<td><%= ans.getSubject_id().getName() %></td>
			<td><%= ans.getDate() %></td>
			
			
			
			<td><a class="btn btn-primary" href="UpdateAnswer.jsp?id=<%= ans.getId() %>" role="button">Update</a></td>
			<td><a class="btn btn-danger" href="DeleteAnswer.jsp?id=<%= ans.getId() %>" role="button">Delete</a></td>

		</tr>
		<%
			}
			
			}
			else{
				out.println("<h2>No Record Found</h2>");
			}
		
		%>
     
     
    </tbody>
  </table>
</div>

</body>
</html>