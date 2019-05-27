<%@page import="dao.SubjectOperationImp"%>
<%@page import="dao.SubjectOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	long id =Long.parseLong( request.getParameter("id"));
	SubjectOperation so = new SubjectOperationImp();

	boolean b = so.delete(id);

	if(b == true){
		response.sendRedirect("http://localhost:8080/onlineExam/AdminPanal/ShowAllSubjects.jsp");	
	}
	else{
	
		out.println("Error in deleting Subject");
		
		
	}
	%>
</body>
</html>