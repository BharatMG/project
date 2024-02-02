<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="styles.jsp"%>
<script type="text/javascript">
	function checkpassword() {
		console.log("password function")
		const password = document.getElementById("password").value
		const button = document.getElementById('button')
		if (password
				.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/)) {
			document.getElementById("error1").innerHTML = "<span style='color:green'>password length valid<span>"
			button.removeAttribute("disabled")
		} else {
			button.setAttribute("disabled", "")
			document.getElementById("error1").innerHTML = "<span style='color:red'>password must contains lowercase,uppercase, invalid<span>"
		}
	}

	function cnfrm() {
		console.log("confirm password function")
		const cnfrmp = document.getElementById("cnfrmpd").value;
		const password = document.getElementById("password").value
		const button = document.getElementById('button')

		if (password == cnfrmp) {
			console.log("password matched")
			document.getElementById("error2").innerHTML = "<span style='color:green'>equal,password valid<span>"
		} else {
			console.log("not equal")
			document.getElementById("error2").innerHTML = "<span style='color:red'>not equal,password invalid<span>"
		}
	}
</script>
</head>
<body>
	<%@include file="Navbar.jsp"%>
	<form action="updatePassword" method="post">
		<h2 class="text-center">Reset the password</h2>
		<input type="hidden" name="emailId" value="${emailId}">
		<div class="container p-4 mt-3 w-50 border border-dark-subtle">
			<h3>${pass}</h3>
			<h5>Enter New Password:</h5>
			<span id="error1"></span>
			<div class="form-floating mb-3">
				<input type="password" class="form-control" name="password" id="password" onblur="checkpassword()" required="required"> <label>Enter password</label>
			</div>
			<h5>Enter confirm Password:</h5>
			<span id="error2"></span>
			<div class="form-floating mb-3">
				<input type="password" class="form-control" name="confirmPassword" id="cnfrmpd" onblur="cnfrm()" required="required"> <label>Enter confirmPassword</label>
			</div>
			<div class="text-center">
				<button id="button" name="otp" type="submit" value="submit" class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-primary">Refresh</button>
				<button type="button" class="btn btn-primary">Cancel</button>
			</div>
		</div>
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>