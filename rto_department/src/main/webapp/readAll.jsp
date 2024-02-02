<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="styles.jsp"%>
</head>
<body>

<%@include file="Navbar.jsp"%>
	<h1>${success}</h1>
	<h1>${unsuccess}</h1>
	<form action="readAll" method="get">
		<!-- <input type="submit"> -->
	</form>

	<h1 class="text-center">ReadAll</h1>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>dateOfBirth</th>
				<th>emailId</th>
				<th>mobileNumber</th>
				 <th>password</th>
				<!--<th>confirmPassword</th> -->
				<th>registereDateTime</th>
			</tr>
			<c:forEach items="${dto}" var="dto">
			<tr>
				<td>${dto.firstName}</td>
				<td>${dto.lastName}</td>
				<td>${dto.dateOfBirth}</td>
				<td>${dto.emailId}</td>
				<td>${dto.mobileNumber}</td>
				 <td>${dto.password}</td>
				<%--<td>${dto.confirmPassword}</td> --%>
				<td>${dto.registereDateTime}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>