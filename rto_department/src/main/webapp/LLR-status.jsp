<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="styles.jsp"%>
</head>
<body>
	<%@include file="Navbar.jsp"%>
	<form action="appStaus" method="get">
		<h1>${msg}</h1>
		<div class="container p-4 mt-3 w-50 border border-dark-subtle">
			<h1>User-Login-Form</h1>
			<h6 class="text-danger">${msg}</h6>
			<div class="form-floating mb-3">
				<input type="text" class="form-control" name="apporcontact"  id="floatingInput" placeholder="enter contactNumber/applicationNumber" required="required"> <label for="floatingInput">Enter
					contactNumber/applicationNumber</label>
			</div>
			<div class="form-floating mb-3">
				<input type="date" class="form-control" name="dob" id="floatingInput" placeholder="enter dob" required="required"><label for="floatingInput"><b>Date Of Birth:</b></label>
			</div>
			<div>
			<a href="forgetUserLogin.jsp">Forget Password</a>
		</div>
			<div>
				<input type="submit" class="btn btn-success"> <input type="reset" class="btn btn-dark">
			</div>
			<!-- <div class="form-floating mb-3">
		<input type="password" class="form-control" name="password" id="floatingInput" placeholder="Enter password"> <label for="floatingInput">Enter password</label>
	</div> -->
		</div>
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>