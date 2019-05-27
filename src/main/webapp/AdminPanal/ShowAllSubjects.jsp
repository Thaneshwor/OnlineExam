<%@page import="bean.Subject"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SubjectOperationImp"%>
<%@page import="dao.SubjectOperation"%>
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
        <input type="text" class="form-control" placeholder="Search By id" name="search">
      </div>
      <button type="submit" class="btn btn-default" name="submit_search">Submit</button>
    </form>
  </div>
</nav> 
<hr>
<!-- ---------------------------------------------------------------- -->
<%
	if(request.getParameter("submit_search")!= null){
		String name = request.getParameter("search");
	
%>
<h1 class="container">Searched Subject List</h1>

<div class="container">
 <table class="table table-dark ">
    <thead>
      <tr>
      		<th>Name</th>
      	 	<th>Subject Full Mark</th>
      	 	<th>TotalQuestion</th>
      	 	<th>Duration(in days)</th> 
      	 	<th>Fees</th>
      	 	<th>Pass Mark</th>
			
        
      </tr>
    </thead>
    <tbody>
      
       <%
	
			SubjectOperation st = new SubjectOperationImp();
			ArrayList li = st.searchByName(name);
		
			ListIterator lit = li.listIterator();
			
			while(lit.hasNext()){
		
		
			Subject s = (Subject)lit.next();
		
		%>
		<tr>
		
			<td><%= s.getName() %></td>
			<td><%= s.getSubMaxMark() %></td>
			<td><%= s.getTotalQuestion() %></td>
			<td><%= s.getDuration() %></td>
			<td><%= s.getFees() %></td>
			<td><%= s.getSubPassMark() %></td>
			
			
			<td><a class="btn btn-primary" href="UpdateSubject.jsp?id=<%= s.getSub_id()%>" role="button">Update</a></td>
			<td><a class="btn btn-danger" href="DeleteSubject.jsp?id=<%= s.getSub_id()%>" role="button">Delete</a></td>

		</tr>
		<%
			}
	}

		
		%>
		
		
		
<!-- ------------------------------------------------------------------------------------- -->
<hr>

<div class="container">

 <table class="table table-dark ">
    <thead>
      <tr>
      		<th>Name</th>
      	 	<th>Subject Full Mark</th>
      	 	<th>TotalQuestion</th>
      	 	<th>Duration(in days)</th> 
      	 	<th>Fees</th>
      	 	<th>Pass Mark</th>
			
        
      </tr>
    </thead>
    <tbody>
      
       <%
	
			SubjectOperation st = new SubjectOperationImp();
       		ArrayList<Subject> li = st.selectAllSubject();
		
			ListIterator lit = li.listIterator();
			
			while(lit.hasNext()){
		
		
			Subject s = (Subject)lit.next();
		
		%>
		<tr>
		
			<td><%= s.getName() %></td>
			<td><%= s.getSubMaxMark() %></td>
			<td><%= s.getTotalQuestion() %></td>
			<td><%= s.getDuration() %></td>
			<td><%= s.getFees() %></td>
			<td><%= s.getSubPassMark() %></td>
			
			
			<td><a class="btn btn-primary" href="UpdateSubject.jsp?id=<%= s.getSub_id()%>" role="button">Update</a></td>
			<td><a class="btn btn-danger" href="DeleteSubject.jsp?id=<%= s.getSub_id()%>" role="button">Delete</a></td>

		</tr>
		<%
			}
	
		
		%>

<!-- ---------------------------------------------------------------- -->



</body>
</html>