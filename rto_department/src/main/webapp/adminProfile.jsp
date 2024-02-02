<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
<%@ include file="styles.jsp"%>
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary navbar-light fw-bold d-flex justify-content-between align-items-center" data-bs-theme="dark">
		<div class="container-fluid">
			<div class="d-flex">
				<a class="navbar-brand" href="index.jsp"><img src="https://paytmblogcdn.paytm.com/wp-content/uploads/2023/10/Blogs_Paytm_Karnataka-Road-Tax-Calculate-Road-Tax-in-Karnataka-Tax-Table-1-800x500.jpg"
					width="60" class="me-3"></a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="index.jsp">Home</a></li>
				</ul>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="readAll">ReadAll</a></li>
				</ul>
				<!-- <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="readAll">ReadAll</a></li>
			</ul> -->
			</div>

			<div class="d-flex">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" role="button" name="firstName"><b>Hi,${em}</b></a></li>
					</ul>

					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" role="button" href="SignUp.jsp"><b>Sign Up</b></a></li>
					</ul>

					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" role="button" href="index.jsp"><b>Logout</b></a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<div>
		<form action="searchByState" method="get">
			<div>
				<br> <input type="search" name="state" placeholder="search"> <input type="submit">
			</div>
			<br>
			<div>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<button type="submit">
						<li class="nav-item" style="list-style-type: none;"><a class="nav-link active" aria-current="page" href="readAll">ReadAll</a></li>
					</button>
				</ul>
			</div>
			<div>
				<h1 class="text-center">RTO details</h1>
				<table class="table table-bordered pd-5">
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
							<!-- <th>confirmPassword</th> -->
							<th>registereDateTime</th>
						</tr>
						<c:forEach items="${dto}" var="dto">
							<tr>
								<td>${dto.firstName}</td>
								<td>${dto.lastName}</td>
								<td>${dto.dateOfBirth}</td>
								<td>${dto.emailId}</td>
								<td>${dto.mobileNumber}</td>
								<td>${dto.state}</td>
								<td>${dto.place}</td>
								<td>${dto.password}</td>
								<%-- <td>${dto.confirmPassword}</td> --%>
								<td>${dto.registereDateTime}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>