/**
 * 
 */
function validateName() {
	console.log("name function running");
	const button = document.getElementById('button');
	const name = document.getElementById("fname").value;
	console.log(name.length);

	if (name.length > 3 && name.length <= 22) {
		document.getElementById("error").innerHTML = "<span style='color:green'>Name is valid<span>";
		button.removeAttribute("disabled");
	} else {
		button.setAttribute("disabled", "");
		document.getElementById("error").innerHTML = "<span style='color:red'>Name is Invalid<span>";
	}
}

function validatelastName() {
	console.log("name function running");
	const button = document.getElementById('button');
	const name = document.getElementById("lastname").value;
	console.log(name.length);

	if (name.length > 3 && name.length <= 22) {
		document.getElementById("error1").innerHTML = "<span style='color:green'>Name is valid<span>";
		button.removeAttribute("disabled");
	} else {
		button.setAttribute("disabled", "");
		document.getElementById("error1").innerHTML = "<span style='color:red'>Name is Invalid<span>";
	}
}

function validateDistrict() {
	console.log("name function running");
	var state = document.getElementById("state").value;
	console.log(state);
	if (state == "Karnataka") {
		document.getElementById("distKa").style.display = "block";
		document.getElementById("distOd").style.display = "none";
		document.getElementById("distMh").style.display = "none";
		document.getElementById("distKl").style.display = "none";
	}  else if (state == 'Odisha') {
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
	}
}

function validateaadhar() {
	console.log("name function running");
	const button = document.getElementById('button');
	const name = document.getElementById("aadhar").value;
	console.log(name.length);

	if (name.length >= 12) {
		document.getElementById("error2").innerHTML = "<span style='color:green'>Name is valid<span>";
		button.removeAttribute("disabled");
	} else {
		button.setAttribute("disabled", "");
		document.getElementById("error2").innerHTML = "<span style='color:red'>Name is Invalid<span>";
	}
}
