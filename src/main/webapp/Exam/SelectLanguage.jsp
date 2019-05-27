<%@page import="java.util.Iterator"%>
<%@page import="bean.Subject"%>
<%@page import="java.util.Set"%>
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

<h1>Select subject : </h1>
<form action="ExamPhase2.jsp">



<select name="subject">

<%
	long stud_id =(Long)session.getAttribute("s_id");

	StudentOperation sop = new StudentOperationImp();
	
	if((sop.selectStudent(stud_id).getSubjects())!=null){
		Student student = sop.selectStudent(stud_id);
		
		Set<Subject> subjects = student.getSubjects();
		
		Iterator itr = subjects.iterator();
		
		while(itr.hasNext()){
			
			Subject sub = (Subject)itr.next();
			
		
		%>

			<option value="<%=sub.getSub_id()%>"><%= sub.getName() %></option>
		<%
		}
	}

%>


</select>

<input type="submit" name="submit" value="select">
</form>


</body>
</html>