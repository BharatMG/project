<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
<%@ include file="styles.jsp"%>
</head>
<body>
<%@include file="Navbar.jsp"%>
	<h1 class="text-center">Registration form</h1>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>dateOfBirth</th>
				<th>emailId</th>
				<th>mobileNumber</th>
				<th>State</th>
				<th>Place</th>
				<th>password</th>
				<th>confirmPassword</th>
				<th>registereDateTime</th>
				
			</tr>
			<tr>
				<td>${dto.firstName}</td>
				<td>${dto.lastName}</td>
				<td>${dto.dateOfBirth}</td>
				<td>${dto.emailId}</td>
				<td>${dto.mobileNumber}</td>
				<td>${dto.state}</td>
				<td>${dto.place}</td>
				<td>${dto.password}</td>
				<td>${dto.confirmPassword}</td>
				<td>${dto.registereDateTime}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>