<%@page import="java.util.List"%>
<%@page import="dao.SubjectOperationImp"%>
<%@page import="dao.SubjectOperation"%>
<%@page import="bean.Subject"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.Student"%>
<%@page import="dao.StudentOperationImp"%>
<%@page import="dao.StudentOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.html"%>

      
      	<%
	if(request.getParameter("id")!= null){
		long id = Long.parseLong(request.getParameter("id"));
	
		StudentOperation so = new StudentOperationImp();
		Student s = (Student)so.selectStudent(id);
		if(s != null){

%>

	<div class="container py-3">
		<div class="row">
			<div class="mx-auto col-sm-6">
				<!-- form user info -->
				<div class="card">
					<div class="card-header">
						<h4 class="mb-0">Update Student</h4>
					</div>
					<div class="card-body">
						<form class="form"
							action="http://localhost:8080/onlineExam/UpdateStudent"
							method="post">
							<input class="form-control" type="hidden"
										value="<%= s.getS_id() %>" name="id">
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">
									Name</label>
								<div class="col-lg-9">
									<input class="form-control" type="text"
										value="<%= s.getName() %>" name="name">
								</div>
							</div>

							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Email</label>
								<div class="col-lg-9">
									<input class="form-control" name="email"
										value="<%= s.getEmail() %>">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Contact</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="contact"
										value="<%= s.getContact() %>">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Course</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="course"
										value="<%= s.getCourse() %>">
								</div>
							</div>

							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Admission
									Date</label>
								<div class="col-lg-9">
									<input class="form-control" type="date" 
										name="admissiondate" value="<%= s.getAdmission_date() %>">
								</div>
							</div>

							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Fees</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="fees"
										value="<%= s.getFees() %>">
								</div>
							</div>

							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Username</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="username"
										value="<%= s.getUsername()%>">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Password</label>
								<div class="col-lg-9">
									<input class="form-control" type="password" name="password">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Confirm</label>
								<div class="col-lg-9">
									<input class="form-control" type="password">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label"></label>
								<div class="col-lg-9">
									<input type="reset" class="btn btn-secondary" value="Cancel">
									<input type="submit" class="btn btn-primary" value="Update">
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- /form user info -->
			</div>
		</div>
	</div>

	<%
			}
		else{
			out.println("update unsucess");
		}
	}
	else{
		out.println("Select any record");
	}


%>
<div class="row">
      <div class="col-sm-6" >
      		<div class="form-group" >
      		<h3 class="align-center">Taken By Student</h3>
      		
      			<ul>
      				<form action="http://localhost:8080/onlineExam/RemoveSubjectFromStudent" method="get">
      					<%
      					long id = Long.parseLong(request.getParameter("id"));
      					
      						StudentOperation so2 = new StudentOperationImp();
      						Student  stud = so2.selectStudent(id);
      						
      						Set<Subject> s = stud.getSubjects();
      						
      						Iterator itr = s.iterator();
      						
      								
      						while(itr.hasNext()){
      						
      							Subject subject = (Subject)itr.next();
      							%>
      							
      							<li class="list-group-item">
      								<input type="checkbox" class="form-check-input"  name="<%= subject.getName() %>" value="<%= subject.getSub_id()%>">&nbsp;&nbsp;<%= subject.getName() %>
      							</li>
      							
      							
      							<%
      						}
      					%>
      					<input type="hidden" name="id" value="<%= id%>">
      					<button type="submit" name="removeSubject" class="btn btn-block block-sucess btn-sucess" value="remove">Remove Subject</button>
      				
      				</form>
      			
      			
      			</ul>
      		
      		</div>
      </div>
      
      
      
      <div class="col-sm-6">
      	
    	<div class="form-group" >
      		<h3 class="align-center">All Subject List</h3>
      		
      			<ul>
      				<form action="http://localhost:8080/onlineExam/AddSubjectToStudent" method="get">
      					<%
      					
      					
      						SubjectOperation so3 = new SubjectOperationImp();
      						List<Subject>  sub_list = so3.selectAllSubject();
      								
      						
      					
      						
      						Iterator itr1 = sub_list.iterator();
      						
      								
      						while(itr1.hasNext()){
      							
      							Subject subject = (Subject)itr1.next();
      							%>
      							
      							<li class="list-group-item">
      								<input type="checkbox" class="form-check-input"  name="<%= subject.getName() %>" value="<%= subject.getSub_id()%>">&nbsp;&nbsp;<%= subject.getName() %>
      							</li>
      							
      							
      							<%
      						}
      					%>
      					<input type="hidden" name="id" value="<%= id%>">
      					<button type="submit" name="addSubject" class="btn btn-block block-sucess" value="Add">Add Subject </button>
      				
      				</form>
      			
      			
      			</ul>
      		
      		</div>
      </div>
      
      
      
   		</div>
	
</body>
</html>