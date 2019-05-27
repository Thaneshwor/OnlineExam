<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.Subject"%>
<%@page import="bean.Student"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.StudentOperationImp"%>
<%@page import="dao.StudentOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Student list</title>
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
<h1 class="container">Searched Studnet List</h1>

<div class="container">
 <table class="table table-dark ">
    <thead>
      <tr>
      		<th>name</th>
      	 	<th>contact</th>
      	 	<th>course</th>
      	 	<th>admission_date</th> 
      	 	<th>fees</th>
      	 	<th>email</th>
			<th>username</th>
			<th>password</th>	
        
      </tr>
    </thead>
    <tbody>
      
       <%
	
			StudentOperation st = new StudentOperationImp();
			ArrayList li = st.searchByName(name);
			
			if(li != null){
		
			ListIterator lit = li.listIterator();
			
			while(lit.hasNext()){
		
		
			Student s = (Student)lit.next();
		
		%>
		<tr>
			
			<td><%= s.getName() %></td>
			<td><%= s.getEmail() %></td>
			<td><%= s.getAdmission_date() %></td>
			<td><%= s.getContact() %></td>
			<td><%= s.getCourse() %></td>
			<td><%= s.getFees() %></td>
			<td><%= s.getUsername() %></td>
			<td><%= s.getPassword() %></td>
			
			<td><a class="btn btn-primary" href="UpdateStudent.jsp?id=<%= s.getS_id()%>" role="button">Update</a></td>
			<td><a class="btn btn-danger" href="DeleteStudent.jsp?id=<%= s.getS_id()%>" role="button">Delete</a></td>

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

<h1 class="container">Studnet List</h1>

<div class="container">
 <table class="table table-dark ">
    <thead>
      <tr>
      		<th>name</th>
      	 	<th>contact</th>
      	 	<th>course</th>
      		<th>subject list</th>
      	 	<th>admission_date</th> 
      	 	<th>fees</th>
      	 	<th>email</th>
			<th>username</th>
			<th>password</th>	
        
      </tr>
    </thead>
    <tbody>
      
       <%
	
			StudentOperation st = new StudentOperationImp();
			ArrayList li = st.selectAllStudents();
		
			ListIterator lit = li.listIterator();
			
			while(lit.hasNext()){
		
		
			Student s = (Student)lit.next();
		
		%>
		<tr>
			
			<td><%= s.getName() %></td>
			<td><%= s.getContact() %></td>
			<td><%= s.getCourse() %></td>
			<td>
			
				<% 
					Set sub_list = s.getSubjects();
					Iterator itr = sub_list.iterator();
					
					while(itr.hasNext()){
						Subject sub = (Subject)itr.next();
						out.println(sub.getName());
					}
				
					
				%>
			
			</td>
			
			<td><%= s.getAdmission_date() %></td>
			<td><%= s.getFees() %></td>
			<td><%= s.getEmail() %></td>
			<td><%= s.getUsername() %></td>
			<td><%= s.getPassword() %></td>
			
			<td><a class="btn btn-primary" href="UpdateStudent.jsp?id=<%= s.getS_id()%>" role="button">Update</a></td>
			<td><a class="btn btn-danger" href="DeleteStudent.jsp?id=<%= s.getS_id()%>" role="button">Delete</a></td>

		</tr>
		<%
			}
	
		
		%>
     
     
    </tbody>
  </table>
</div>

	

</body>
</html>