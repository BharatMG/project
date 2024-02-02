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

	<%-- <h2>${err}</h2> --%>

	<div class="container p-4 mt-3 w-50 border border-dark-subtle">
		<form action="checkemail" method="post">
			<h1>Find Your Account</h1>
			<h5>Please enter your email address to search for your account.</h5>
			<div class="text-center">
				<h2 class="text-success">${pass}</h2>
				<h4 class="text-danger">${err}</h4>
			</div>
			<div class="form-floating mb-3">
				<input type="email" class="form-control" name="emailId" value="${emailId}"> <label>Email address</label>
			</div>
			<div>
				<input type="submit" name="otp" value="sendOtp">
			</div>


			<div class="form-floating mb-3">
				<input type="text" class="form-control" name="rtoOtp"> <label>Enter otp</label>
			</div>
			<input name="otp" value="next" type="submit">
		</form>

	</div>

	<!-- <div class="form-floating mb-3">
				<input type="text" class="form-control" name="rtoOtp" id="floatingInput" placeholder="Enter otp"> <label for="floatingInput">Enter otp</label>
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="login"> <input type="reset" class="btn btn-dark">
			</div> -->

	<%@include file="footer.jsp"%>
</body>
</html>