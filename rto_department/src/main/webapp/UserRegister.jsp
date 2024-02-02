<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="styles.jsp"%>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- <script type="text/javascript" src="js/index.js"></script> -->
<script type="text/javascript">
	function validateName() {
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

	function validatelastName() {
		console.log("name function running")
		const button = document.getElementById('button')
		const name = document.getElementById("lastname").value
		console.log(name.length)

		if (name.length > 1 && name.length <= 22) {
			document.getElementById("error1").innerHTML = "<span style='color:green'>Name is valid<span>"
			button.removeAttribute("disabled")
		} else {
			button.setAttribute("disabled", "")
			document.getElementById("error1").innerHTML = "<span style='color:red'>Name is Invalid<span>"
		}
	}

	function validateDistrict() {
		console.log("name function running")
		const state = document.getElementById("state").value;
		console.log(state);
		if (state == 'Karnataka') {
			document.getElementById("distKa").style.display = "block";
			document.getElementById("distOd").style.display = "none";
			document.getElementById("distMh").style.display = "none";
			document.getElementById("distKl").style.display = "none";
		} else if (state == 'Odisha') {
			document.getElementById("distOd").style.display = "block";
			document.getElementById("distKa").style.display = "none";
			document.getElementById("distMh").style.display = "none";
			document.getElementById("distKl").style.display = "none";
		} else if (state == 'Maharashtra') {
			document.getElementById("distMh").style.display = "block";
			document.getElementById("distKa").style.display = "none";
			document.getElementById("distOd").style.display = "none";
			document.getElementById("distKl").style.display = "none";
		} else if (state == 'Kerala') {
			document.getElementById("distKl").style.display = "block";
			document.getElementById("distKa").style.display = "none";
			document.getElementById("distOd").style.display = "none";
			document.getElementById("distMh").style.display = "none";
		} else if (state == 'Goa') {
			document.getElementById("distKl").style.display = "block";
			document.getElementById("distKa").style.display = "none";
			document.getElementById("distOd").style.display = "none";
			document.getElementById("distMh").style.display = "none";
	}
	function validateaadhar() {
		console.log("name function running")
		const button = document.getElementById('button')
		const name = document.getElementById("aadhar").value
		console.log(name.length)

		if (name.length >= 12) {
			document.getElementById("error2").innerHTML = "<span style='color:green'>Name is valid<span>"
			button.removeAttribute("disabled")
		} else {
			button.setAttribute("disabled", "")
			document.getElementById("error2").innerHTML = "<span style='color:red'>Name is Invalid<span>"
		}
	}
</script>
</head>
<body>
	<%@include file="Navbar.jsp"%>
	<form action="user" method="post">
	<div class="card">
				<div class="card-body">
					<div class="text-center">
		<h1>${message}</h1>
		<h1>${applicationNumber}</h1></div></div></div>
		<div class="container p-4 w-100 border border-dark-subtle shadow-lg my-3 rounded-2">
			<h3 class="bg-primary-subtle p-3 border-primary border-1 border text-center">Application for Learner's Licence(LL)</h3>

			<b> Select State and RTO office from where LL is being applied</b>

			<div class="row">
				<div class="col">
					<div class="form-floating mb-3">
						<select id="state" class="form-select" size="1" id="floatingInput" name="state" onchange="validateDistrict()">
							<option value="" disabled selected>Choose State</option>


							<c:forEach items="${state}" var="dto">
								<option value="${dto}">${dto}</option>
							</c:forEach>
						</select> <label for="floatingInput">Select State</label>
					</div>
				</div>
				<div class="col">
					<div class="form-floating mb-3">
						<select id="distKa" class="form-select" id="floatingInput" name="rtoOffice" size="1" style="display: block">
							<option value="" disabled selected>Choose City</option>
							<c:forEach items="${karnataka}" var="ka">
								<option value="${ka}">${ka}</option>
							</c:forEach>
						</select> <select id="distOd" class="form-select" id="floatingInput" name="rtoOffice" size="1" style="display: none">
							<option value="" disabled selected>Choose City</option>
							<c:forEach items="${odisha}" var="od">
								<option value="${od}">${od}</option>
							</c:forEach>
						</select> <select id="distMh" class="form-select" id="floatingInput" name="rtoOffice" size="1" style="display: none">
							<option value="" disabled selected>Choose City</option>
							<c:forEach items="${maharashtra}" var="mh">
								<option value="${mh}">${mh}</option>
							</c:forEach>
						</select> <select id="distKl" class="form-select" id="floatingInput" name="rtoOffice" size="1" style="display: none">
							<option value="" disabled selected>Choose City</option>
							<c:forEach items="${kerala}" var="kl">
								<option value="${kl}">${kl}</option>
							</c:forEach>
						</select> <label for="floatingInput">RTO Office</label>
					</div>
				</div>
				<div class="col">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" name="country" id="floatingInput" placeholder="enter country" onkeydown="return /[a-zA-Z]/i.test(event.key)" required="required"> <label for="floatingInput">Enter
							country</label>
					</div>
				</div>
			</div>

			<hr>

			<div class="card">
				<div class="card-body">
					<div>
						<label class="form-lable"><b>Name of the Application:</b></label>
						<div class="row">
							<div class="col">
								<span id="error"></span>
								<div class="form-floating mb-3">

									<input type="text" onblur="validateName()" id="fname" class="form-control" id="floatingInput" name="firstName" placeholder="First name" aria-label="First name"
										onkeydown="return /[a-zA-Z]/i.test(event.key)" required="required"> <label for="floatingInput">Enter FirstName</label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="middleName" placeholder="First name" aria-label="First name" onkeydown="return /[a-zA-Z]/i.test(event.key)" required="required"> <label
										for="floatingInput">Enter middleName</label>
								</div>
							</div>
							<div class="col">
								<span id="error1"></span>
								<div class="form-floating mb-3">
									<input type="text" onblur="validatelastName()" id="lastname" class="form-control" name="lastName" placeholder="Last name" aria-label="Last name" onkeydown="return /[a-zA-Z]/i.test(event.key)"
										required="required"> <label for="floatingInput">Enter lastName</label>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<span id="error2"></span>
								<div class="form-floating mb-3">
									<input type="number" class="form-control" onblur="validateaadhar()" id="aadhar" name="aadharNumber" id="floatingInput" placeholder="enter state" onKeyPress="if(this.value.length==12) return false;"
										required="required"> <label for="floatingInput">Enter aadharNumber</label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="email" class="form-control" name="email" id="floatingInput" placeholder="enter state" required="required"> <label for="floatingInput">Enter email</label>
								</div>
								<font color="red"><h6>${error}</h6></font>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="tel" class="form-control" name="contactNumber" id="floatingInput" placeholder="enter state" onKeyPress="if(this.value.length==10) return false;" required="required"> <label
										for="floatingInput">Enter contactNumber</label>
								</div>
								<font color="red"><h6>${error1}</h6></font>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<label>Gender :</label>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="Male"> <label class="form-check-label" for="inlineRadio1"><b>Male</b></label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="Female"> <label class="form-check-label" for="inlineRadio2"><b>Female</b></label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender" id="inlineRadio3" value="Others"> <label class="form-check-label" for="inlineRadio3"><b>Others</b></label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">

									<input type="date" class="form-control" name="dob" id="floatingInput" placeholder="enter dob" required="required"><label for="floatingInput"><b>Date Of Birth:</b></label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="number" class="form-control" name="age" id="floatingInput" placeholder="enter age" required="required"> <label for="floatingInput">Enter age</label>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="placeOfBirth" id="floatingInput" onkeydown="return /[a-zA-Z]/i.test(event.key)" placeholder="enter placeOfBirth" required="required"> <label
										for="floatingInput">Enter placeOfBirth</label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="bloodGroup" id="floatingInput" placeholder="enter bloodGroup" required="required"> <label for="floatingInput">Enter bloodGroup</label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="qualification" onkeydown="return /[a-zA-Z]/i.test(event.key)" id="floatingInput" placeholder="enter qualification" required="required"> <label
										for="floatingInput">Enter qualification</label>
								</div>
							</div>
						</div>






						<div class="row">
							<div class="col">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="presentAddress" id="floatingInput" placeholder="enter presentAddress" required="required"> <label for="floatingInput">Enter presentAddress</label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="permanentAddress" id="floatingInput" placeholder="enter permanentAddress" required="required"> <label for="floatingInput">Enter
										permanentAddress</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<div class="form-floating mb-3">
									<input type="number" class="form-control" name="presentPincode" id="floatingInput" placeholder="enter presentPincode" required="required"> <label for="floatingInput">Enter
										presentPincode</label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="number" class="form-control" name="permanentPincode" id="floatingInput" placeholder="enter permanentPincode" required="required"> <label for="floatingInput">Enter
										permanentPincode</label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="form-floating mb-3">
			<input type="" class="form-control" name="registereDateTime" id="floatingInput" placeholder="enter state" required="required"> <label for="floatingInput">Enter permanentPincode</label>
		</div> -->

			<div class="card">
				<div class="card-body">
					<b>Declaration</b><br> <font color="red">Fill-Up Form1 details before submitting the application</font>
					<button type="button" class="btn btn-warning">Self Declaration(Form1)</button>
					<br> 1.I am willing to donate my organs,in case of accidental death?
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="organDonation" id="inlineRadio1" value="Yes" required="required"> <label class="form-check-label" for="inlineRadio1"><b>Yes</b></label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="organDonation" id="inlineRadio2" value="No"> <label class="form-check-label" for="inlineRadio2"><b>No</b></label>
					</div>
					<br> 2.I here by declare that to the best of my knowledge and belief the particulars given above are true.<input type="checkbox" required="required"><br>
				</div>
			</div>
			<div class="card">
				<div class="card-body">
					<div class="text-center">
						<button id="button" type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn btn-primary">Refresh</button>
						<button type="button" class="btn btn-primary">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<%@include file="footer.jsp"%>
</body>
</html>