<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add subject record</title>
<%@include file="../common/common_link_homepage" %>
</head>
<body>

	<div class="container py-3">
		<div class="row">
			<div class="mx-auto col-sm-6">
				<!-- form user info -->
				<div class="card">
					<div class="card-header">
						<h4 class="mb-0">Add Subject Form</h4>
					</div>
					<div class="card-body">
						<form class="form" role="form" autocomplete="off" action="http://localhost:8080/onlineExam/AddSubject" method="get">
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">
									Subject Name</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" placeholder="Subject  name" name="name">
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject Max mark</label>
								<div class="col-lg-9">
									<input class="form-control" type="text"
										placeholder="Subject Max mark" name="maxMark">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject Pass mark</label>
								<div class="col-lg-9">
									<input class="form-control" type="text"
										placeholder="Subject Pass mark" name="passMark">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject Fees</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" placeholder="Subject Fees" name="subjectFees">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject total question</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" placeholder="Total number of question" name="totalQuesion">
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">Subject Duration</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" value="" placeholder="Duration in days" name="subjectDuration">
								</div>
							</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label"></label>
								<div class="col-lg-9">
									<input type="reset" class="btn btn-secondary" value="Cancel">
									<input type="submit" class="btn btn-primary"
										value="Add">
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- /form user info -->
			</div>
		</div>
</body>
</html>