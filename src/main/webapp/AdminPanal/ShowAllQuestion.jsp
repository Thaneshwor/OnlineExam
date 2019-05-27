<%@page import="dao.OptionOperationImpl"%>
<%@page import="dao.OptionOperation"%>
<%@page import="bean.Option"%>
<%@page import="bean.Question"%>
<%@page import="bean.Student"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.QuestionOperationImp"%>
<%@page import="dao.QuestionOperation"%>
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

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Online-Exam</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Exams</a></li>
      <li><a href="#">Contacts</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="#">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search By Name" name="search">
      </div>
      <button type="submit" class="btn btn-default" name="submit_search">Submit</button>
    </form>
  </div>
</nav> 

<!-- ---------------------------------------------------------------- -->
<%
	if(request.getParameter("submit_search")!= null){
		String name = request.getParameter("search");
	
%>
<h1 class="container">Searched Question List</h1>

<div class="container">
 <table class="table table-dark ">
    <thead>
      <tr>
      		<th>Subjcet</th>
      	 	<th>Question</th>
      	 	<th>Marks</th>
      	 	<th>Option 1</th> 
      	 	<th>Option 2</th>
      	 	<th>Option 3</th>
			<th>Option 4</th>
			<th>Answer</th>	
        
      </tr>
    </thead>
    <tbody>
      
       <%
	
			QuestionOperation qo = new QuestionOperationImp();
			ArrayList li = qo.searchByName(name);
			
			if(li.size() > 0){
		
			ListIterator lit = li.listIterator();
			
			while(lit.hasNext()){
		
		
			Question q = (Question)lit.next();
		
		%>
		<tr>
			<td><%= q.getSubject().getName() %></td>
			<td><%= q.getQuestion() %></td>
			<td><%= q.getMark() %></td>
			<td><%= q.getOption().getOption1() %></td>
			<td><%= q.getOption().getOption2() %></td>
			<td><%= q.getOption().getOption3() %></td>
			<td><%= q.getOption().getOption4() %></td>
			<td><%= q.getAnswer() %></td>
			
			
			<td><a class="btn btn-primary" href="UpdateQuestion.jsp?id=<%= q.getQue_id()%>" role="button">Update</a></td>
			<td><a class="btn btn-danger" href="DeleteQuestion.jsp?id=<%=  q.getQue_id()%>" role="button">Delete</a></td>

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

<%
	}
			

%>

<!-- ---------------------------------------------------------------- -->

<h1 class="container">Question List</h1>

<div class="container">
 <table class="table table-dark ">
    <thead>
      <tr>
      		<th>Subject</th>
      	 	<th>Question</th>
      	 	<th>Marks</th>
      	 	<th>Option 1</th> 
      	 	<th>Option 2</th>
      	 	<th>Option 3</th>
			<th>Option 4</th>
			<th>Answer</th>	
        
      </tr>
    </thead>
    <tbody>
      
       <%
	
			QuestionOperation qo = new QuestionOperationImp();
      		OptionOperation oo = new OptionOperationImpl();
			ArrayList li = qo.selectAllQuestion();
			
			if(li.size()> 0){
		
			ListIterator lit = li.listIterator();
			
			while(lit.hasNext()){
		
		
			Question q = (Question)lit.next();
			Option o = q.getOption();
			
		
		%>
		<tr>
			<td><%= q.getSubject().getName() %></td>
			<td><%= q.getQuestion() %></td>
			<td><%= q.getMark() %></td>
			<td><%= o.getOption1() %></td>
			<td><%= o.getOption2() %></td>
			<td><%= o.getOption3() %></td>
			<td><%= o.getOption4() %></td>
			<td><%= q.getAnswer() %></td>
			
			
			<td><a class="btn btn-primary" href="UpdateQuestion.jsp?id=<%= q.getQue_id()%>" role="button">Update</a></td>
			<td><a class="btn btn-danger" href="DeleteQuestion.jsp?id=<%=  q.getQue_id()%>" role="button">Delete</a></td>

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