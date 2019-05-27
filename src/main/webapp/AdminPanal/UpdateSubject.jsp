<%@page import="bean.Subject"%>
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

	if(request.getParameter("id")!= null){
		long id = Long.parseLong(request.getParameter("id"));
	
		
		SubjectOperation so = new SubjectOperationImp();
		Subject s = (Subject)so.selectSubject(id);

		if(s != null){
			
		
		
%>


<div class="container py-3">
		<div class="row">
			<div class="mx-auto col-sm-6">
				<!-- form user info -->
				<div class="card">
					<div class="card-header">
						<h4 class="mb-0">Update Subject Form</h4>
					</div>
					<div class="card-body">
						<form class="form" role="form" autocomplete="off" action="http://localhost:8080/onlineExam/UpdateSubject" method="get">
							
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label"></label>
								<div class="col-lg-9">
									<input class="form-control" type="hidden"
										value="<%= s.getSub_id() %>" name="id">
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">
									Subject Name</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" value="<%= s.getName() %>" name="name">
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject Max mark</label>
								<div class="col-lg-9">
									<input class="form-control" type="text"
										value="<%= s.getSubMaxMark() %>" name="maxMark">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject Pass mark</label>
								<div class="col-lg-9">
									<input class="form-control" type="text"
										value="<%= s.getSubPassMark() %>" name="passMark">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject Fees</label>
								<div class="col-lg-9">
									<input class="form-control" type="text"value="<%= s.getFees() %>" name="subjectFees">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject total question</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" value="<%= s.getTotalQuestion() %>" name="totalQuesion">
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject Duration</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" value="<%= s.getDuration() %>" name="subjectDuration">
								</div>
							</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label"></label>
								<div class="col-lg-9">
									<input type="reset" class="btn btn-secondary" value="Cancel">
									<input type="submit" class="btn btn-primary"
										value="Update">
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- /form user info -->
			</div>
		</div>
		<%
		}
		
	}
		
		%>

</body>
</html>