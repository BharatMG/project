<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="card">
<div class="bg-warning p-3">
		 <div class="card-body">
		 <div class="bg-info p-3">
	 

 			<div>
				<div>Name: <b>${userDL.firstName}</b></div>
				 <div>DL-Number: <b>${userDL.DLapplicationNumber}</b></div>
				 <div>Gender: <b>${userDL.gender}</b></div>
				 <div>DOB: <b>${userDL.dob}</b></div>
				 <div>State: <b>${userDL.state}</b></div>
				 	 <img alt="" src="download?fileName=${image}" width="100" height="100" style="border:50%">
				 </div>
			</div></div></div></div></div>
<%@include file="footer.jsp"%>
</body>
</html>