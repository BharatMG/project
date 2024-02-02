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
	
	<a href=pdf?=${pdfConvert}>Download</a>
<form action="dlSave" method="post" ><!-- enctype="multipart/form-data" > -->
	<div class="card">
		<div class="card-body">
			<div class="text-center">
				<h1>${message}</h1>
			 <%-- <h1>${app}</h1> --%>
				<h1>${save}</h1>
				<h1>${u}</h1>
				<h1>${app1}</h1>
				
			</div>
		</div>
	</div>
	<div class="container p-4 w-100 border border-dark-subtle shadow-lg my-3 rounded-2">
		<h3 class="bg-primary-subtle p-3 border-primary border-1 border text-center">New Driving LICENSE REGISTRATION(DL)</h3>

		<div class="text-center">
			<font color="red" size=3> ** Fields marked with * are mandatory</font><br> <font color="red" size=3>**To calculate Age,Place the cursor in age field</font>

			<h3 class="bg-primary-subtle p-6 border-primary border-1 border text-center">DEMOGRAPHIC DETAILS</h3>
			<div class="container text-center">
				<div class="row">
					<div class="col">
						<div class="form-floating mb-3">

							<input type="text" onblur="validateName()" id="fname" class="form-control" id="floatingInput" name="firstName" placeholder="First name" value=${app.firstName } aria-label="First name"
								onkeydown="return /[a-zA-Z]/i.test(event.key)" readonly="readonly" required="required"> <label for="floatingInput">Enter FirstName</label>
						</div>
					</div>
					<div class="col">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" name="middleName" value=${app.middleName } readonly="readonly" placeholder="Middle name" aria-label="Middle name" onkeydown="return /[a-zA-Z]/i.test(event.key)"
								required="required"> <label for="floatingInput">Enter middleName</label>
						</div>
					</div>
					<div class="col">
						<div class="form-floating mb-3">
							<input type="text" onblur="validatelastName()" id="lastname" class="form-control" name="lastName" value=${app.lastName } placeholder="Last name" aria-label="Last name" readonly="readonly"
								onkeydown="return /[a-zA-Z]/i.test(event.key)" required="required"> <label for="floatingInput">Enter lastName</label>
						</div>
					</div>
				</div>
			</div>

			<div class="container text-center">
				<div class="row">
					<div class="col">
						<label>Gender :</label>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" value=${app.gender } name="gender" id="inlineRadio1" value="Male"> <label class="form-check-label" for="inlineRadio1"><b>Male</b></label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender" value=${app.gender } id="inlineRadio2" value="Female"> <label class="form-check-label" for="inlineRadio2"><b>Female</b></label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender" id="inlineRadio3" value="Others"> <label class="form-check-label" for="inlineRadio3"><b>Others</b></label>
						</div>
					</div>
					<div class="col">
						<div class="form-floating mb-3">
							<input type="date" class="form-control" name="dob" value=${app.dob } id="floatingInput" placeholder="enter dob" readonly="readonly" required="required"><label for="floatingInput"><b>Date
									Of Birth:</b></label>
						</div>
					</div>
					<div class="col">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" name="placeOfBirth" value=${app.placeOfBirth } id="floatingInput" readonly="readonly" onkeydown="return /[a-zA-Z]/i.test(event.key)"
								placeholder="enter placeOfBirth" required="required"> <label for="floatingInput">Enter placeOfBirth</label>
						</div>
					</div>
				</div>
			</div>

<div class="container text-center">
						<div class="row">
							<div class="col">
								<div class="form-floating mb-3">
									<input type="tel" class="form-control" name="presentAddress" value=${app.presentAddress } id="floatingInput" readonly="readonly" placeholder="enter presentAddress"
										onKeyPress="if(this.value.length==10) return false;" required="required"> <label for="floatingInput">Enter presentAddress</label>
								</div>
							</div>
							<div class="col">
								<div class="col">
									<div class="form-floating mb-3">
										<input type="tel" class="form-control" name="presentPincode" value=${app.presentPincode } id="floatingInput" readonly="readonly" placeholder="enter present Pincode"
											onKeyPress="if(this.value.length==10) return false;" required="required"> <label for="floatingInput">Enter present Pincode</label>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="tel" class="form-control" name="permanentAddress" value=${app.permanentAddress } id="floatingInput" readonly="readonly" placeholder="enter permanent Address"
										onKeyPress="if(this.value.length==10) return false;" required="required"> <label for="floatingInput">Enter permanent Address</label>
								</div>
							</div>
						</div>
					</div>

			<div class="container text-center">
				<div class="row">
					<div class="col">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" name="bloodGroup" value=${app.bloodGroup } id="floatingInput" placeholder="enter bloodGroup" readonly="readonly" required="required"> <label
								for="floatingInput">Enter bloodGroup</label>
						</div>
					</div>
					<div class="col">
						<div class="form-floating mb-3">
							<input type="tel" class="form-control" name="contactNumber" value=${app.contactNumber } id="floatingInput" placeholder="enter state" readonly="readonly"
								onKeyPress="if(this.value.length==10) return false;" required="required"> <label for="floatingInput">Enter contactNumber</label>
						</div>
					</div>
					<div class="col">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" name="state" value=${app.state} id="floatingInput" placeholder="enter state" readonly="readonly" onKeyPress="if(this.value.length==10) return false;" required="required"> <label
								for="floatingInput">Enter passportNo</label>
						</div>
					</div>
				</div>


				<div class="container text-center">
					<div class="row">
						<div class="col">
							<div class="form-floating mb-3">
								<input type="tel" class="form-control" name="withnessFirstName" id="floatingInput" placeholder="enter Withness First Name*" onKeyPress="if(this.value.length==10) return false;" required="required">
								<label for="floatingInput">Enter withnessFirstName</label>
							</div>
						</div>
						<div class="col">
							<div class="form-floating mb-3">
								<input type="tel" class="form-control" name="withnessMiddleName" id="floatingInput" placeholder="enter Withness Middle Name*" onKeyPress="if(this.value.length==10) return false;" required="required">
								<label for="floatingInput">Enter withness Middle Name</label>
							</div>
						</div>
						<div class="col">
							<div class="form-floating mb-3">
								<input type="tel" class="form-control" name="withnesslastName" id="floatingInput" placeholder="enter Withness Last Name*" onKeyPress="if(this.value.length==10) return false;" required="required">
								<label for="floatingInput">Enter withness Last Name</label>
							</div>
						</div>
					</div>


					<div class="container text-center">
						<div class="row">
							<div class="col">
								<div class="form-floating mb-3">
									<input type="tel" class="form-control" name="withnessRelationship" id="floatingInput" placeholder="enter withness Relationship" onKeyPress="if(this.value.length==10) return false;" required="required">
									<label for="floatingInput">Enter withnessRelationship</label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="tel" class="form-control" name="trainerName" id="floatingInput" placeholder="enter TrainerName" onKeyPress="if(this.value.length==10) return false;" required="required"> <label
										for="floatingInput">Enter TrainerName</label>
								</div>
							</div>
							<div class="col">
								<div class="form-floating mb-3">
									<input type="tel" class="form-control" name="trainerLicenseNo" id="floatingInput" placeholder="enter Trainer License No" onKeyPress="if(this.value.length==10) return false;" required="required">
									<label for="floatingInput">Enter Trainer License No</label>
								</div>
							</div>
						</div>
					</div>

<div class="col">
						<div class="form-floating mb-3">
							<input type="tel" class="form-control" name="passportNumber" id="floatingInput" placeholder="enter passportNo" onKeyPress="if(this.value.length==10) return false;" required="required"> <label
								for="floatingInput">Enter passportNo</label>
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
			</div>
</form>
			<%@include file="footer.jsp"%>
</body>
</html>