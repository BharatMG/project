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


	<div class="container p-4 mt-3 w-50 border border-dark-subtle">
		<h1>Login-Form</h1>
		<h6 class="text-successs">${pass}</h6>
		<form action="login" method="post">
			<div class="form-floating mb-3">
				<input type="email" class="form-control" name="emailId" id="floatingInput" placeholder="name@example.com"> <label for="floatingInput">Email address</label>
			</div>
			<div class="form-floating mb-3">
				<input type="password" class="form-control" name="password" id="floatingInput" placeholder="Enter password"> <label for="floatingInput">Enter password</label>
			</div>
			<div>
				<a href="forgetRtoLogin.jsp">Forget Password</a>
			</div>
			<div>
				<input type="submit" class="btn btn-success"> <input type="reset" class="btn btn-dark">
			</div>

		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>