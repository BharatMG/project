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
	<h1>${invalid}</h1>
	<h1>${app}</h1>
	<form action="dlcard" method="get">
		<div>
			Enter DLapplicationNumber<input type="text" name="DLapplicationNumber" required="required">
		</div>
		<div class="card">
			<div class="card-body">
<%-- 				<img alt="" src="download?fileName=${image}" width="50" height="50" style="border-radius:50%">
 --%>			</div>
			
			</div>
			<input type="submit">
		
	</form>

	<%@include file="footer.jsp"%>
</body>
</html>