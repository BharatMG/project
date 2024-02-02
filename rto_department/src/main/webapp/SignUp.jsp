<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
<%@ include file="styles.jsp"%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var citiesByState = {
		Karnataka : [ "Haveri", "Dharwad", "Bengaluru", "Mysuru" ],
		Odisha : [ "Bhubaneswar", "Puri", "Cuttack" ],
		Maharashtra : [ "Mumbai", "Pune", "Nagpur" ],
		Kerala : [ "kochi", "Kanpur" ]
	}
	function makeSubmenu(value) {
		if (value.length == 0)
			document.getElementById("citySelect").innerHTML = "<option></option>";
		else {
			var citiesOptions = "";
			for (cityId in citiesByState[value]) {
				citiesOptions += "<option>" + citiesByState[value][cityId]
						+ "</option>";
			}
			document.getElementById("citySelect").innerHTML = citiesOptions;
		}
	}
	function displaySelected() {
		var country = document.getElementById("countrySelect").value;
		var city = document.getElementById("citySelect").value;
		alert(country + "\n" + city);
	}
	function resetSelection() {
		document.getElementById("countrySelect").selectedIndex = 0;
		document.getElementById("citySelect").selectedIndex = 0;
	}
	function validate() {
		console.log("name function running")
		const button = document.getElementById('button')
		const name = document.getElementById("fname").value
		console.log(name.length)
		if (name.length > 3 && name.length <= 22) {
			document.getElementById("error").innerHTML = "<span style='color:green'>Name is valid<span>"
			button.removeAttribute("disabled")
		} else {
			button.setAttribute("disabled", "")
			document.getElementById("error").innerHTML = "<span style='color:red'>Name is Invalid<span>"
		}
	}

	function validate1() {
		console.log("name function running")
		const button = document.getElementById('button')
		const name = document.getElementById("lname").value
		/* const lname = document.getElementById("lname").value */
		console.log(name.length)
		if (name.length > 1 && name.length <= 22) {
			document.getElementById("error1").innerHTML = "<span style='color:green'>Name is valid<span>"
			button.removeAttribute("disabled")
		} else {
			button.setAttribute("disabled", "")
			document.getElementById("error1").innerHTML = "<span style='color:red'>Name is Invalid<span>"
		}
	}

	function validate2() {
		console.log("email function running")
		const button = document.getElementById('button')
		const name = document.getElementById("email").value
		console.log(name.length)
		if (name.length > 1 && name.length <= 22) {
			document.getElementById("error2").innerHTML = "<span style='color:green'>Name is valid<span>"
			button.removeAttribute("disabled")
		} else {
			button.setAttribute("disabled", "")
			document.getElementById("error2").innerHTML = "<span style='color:red'>Name is Invalid<span>"
		}
	}
	function validate3() {
		console.log("phoneNumber function running")
		const button = document.getElementById('button')
		const name = document.getElementById("number").value
		if (name.length === 10) {
			document.getElementById("error3").innerHTML = "<span style='color:green'>Number is valid<span>"
			button.removeAttribute("disabled")
		} else {
			button.setAttribute("disabled", "")
			document.getElementById("error3").innerHTML = "<span style='color:red'>Number is Invalid<span>"
		}
	}

	function checkpassword() {
		console.log("password function")
		const password = document.getElementById("password").value
		const button = document.getElementById('button')
		if (password
				.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/)) {
			document.getElementById("error4").innerHTML = "<span style='color:green'>password length valid<span>"
			button.removeAttribute("disabled")
		} else {
			button.setAttribute("disabled", "")
			document.getElementById("error4").innerHTML = "<span style='color:red'>password must contains lowercase,uppercase, invalid<span>"
		}
	}

	function cnfrm() {
		console.log("confirm password function")
		const cnfrmp = document.getElementById("cnfrmpd").value;
		const password = document.getElementById("password").value
		const button = document.getElementById('button')

		if (password == cnfrmp) {
			console.log("password matched")
			document.getElementById("error5").innerHTML = "<span style='color:green'>equal,password valid<span>"
		} else {
			console.log("not equal")
			document.getElementById("error5").innerHTML = "<span style='color:red'>not equal,password invalid<span>"
		}
	}


</script>
</head>

<body onload="resetSelection()">
	<%@include file="Navbar.jsp"%>
	<input type="hidden" id="status">
	<c:forEach items="${validator}" var="e">
		<h6>${e}</h6>
	</c:forEach>
	<h1 class="text-center">${successfully}</h1>
	<div class="container p-4 w-50 border border-dark-subtle shadow-lg my-3 rounded-2">
		<h3 class="bg-primary-subtle p-3 border-primary border-1 border text-center">Registration Form</h3>
		<hr>
		<form action="save" method="post">

			<div class="row">
				<div class="col">

					<span style="color: green" id="error"></span>
					<div class="form-floating mb-3">
						<input type="text" onblur="validate()" id="fname" required="required" class="form-control" name="firstName" id="floatingInput" placeholder="enter firstName"> <label for="floatingInput">First
							Name</label>
					</div>
					<span id="error2"></span>
					<div class="form-floating mb-3">
						<input type="email" onblur="validate2()" id="email" class="form-control" name="emailId" id="floatingInput" placeholder="name@example.com" required="required"> <label for="floatingInput">Email
							address</label> <font color="red"><h6>${error}</h6></font>
					</div>
					<span id="error4"></span>
					<div class="form-floating mb-3">
						<input type="password" id="password" onblur="checkpassword()" class="form-control" name="password" id="floatingInput" placeholder="Enter password" required="required"> <label for="floatingInput">Enter
							password</label>
					</div>

					<div class="form-floating mb-3">
						<select id="countrySelect" class="form-select" size="1" id="floatingInput" name="state" onchange="makeSubmenu(this.value)">
							<option value="" disabled selected>Choose State</option>

							<option value="Karnataka">Karnataka</option>
							<option value="Odisha">Odisha</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="Kerala">Kerala</option>
						</select> <label for="floatingInput">Select State</label>
					</div>


					<div class="form-floating mb-3">
						<input type="date" required="required" class="form-control" name="dateOfBirth" id="floatingInput" placeholder="YYYY-MM-DD" max="2005-05-19"> <label for="floatingInput">Date of Birth</label>
					</div>
				</div>

				<div class="col">
					<span id="error1"></span>
					<div class="form-floating mb-3">
						<input type="text" onblur="validate1()" required="required" id="lname" class="form-control" name="lastName" id="floatingInput" placeholder="enter lastName"> <label for="floatingInput">last
							Name</label>
					</div>

					<span id="error3"></span>
					<div class="form-floating mb-3">
						<input type="tel" onblur="validate3()" id="number" class="form-control" name="mobileNumber" id="floatingInput" placeholder="Enter mobileNumber" required="required"> <label for="floatingInput">Enter
							mobileNumber</label> <font color="red"><h6>${error1}</h6></font>
					</div>

					<span id="error5"></span>
					<div class="form-floating mb-3">
						<input type="password" id="cnfrmpd" onblur="cnfrm()" class="form-control" name="confirmPassword" id="floatingInput" placeholder="Enter confirmPassword" required="required"> <label
							for="floatingInput">Enter confirmPassword</label>
					</div>

					<div class="form-floating mb-3">
						<select id="citySelect" class="form-select" id="floatingInput" name="place" size="1">
							<option value="" disabled selected>Choose City</option>
							<option></option>
						</select> <label for="floatingInput">Select Place</label>
					</div>
					<button style="display: none;" onclick="displaySelected()"></button>

					<!-- <div class="form-floating mb-3">
						<input type="datetime-local" class="form-control" name="registereDateTime" id="floatingInput" placeholder="Enter dateTime" required="required"> <label for="floatingInput">Enter
							dateTime</label>
					</div> -->
				</div>
			</div>
			<div class="mb-3">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" required="required" id="flexCheckDefault" checked> <label class="form-check-label" for="flexCheckDefault"> Confirm Registration </label>
				</div>
			</div>
			<div class="d-flex column-gap-4 mt-3">
				<input id="button" type="submit" class="btn btn-success flex-fill"> <input type="reset" class="btn btn-dark flex-fill">

			</div>

			<!-- <div id="message">
				<h3>Password must contain the following:</h3>
				<p id="letter" class="invalid">
					A <b>lowercase</b> letter
				</p>
				<p id="capital" class="invalid">
					A <b>capital (uppercase)</b> letter
				</p>
				<p id="number" class="invalid">
					A <b>number</b>
				</p>
				<p id="length" class="invalid">
					Minimum <b>8 characters</b>
				</p>
			</div> -->
		</form>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>