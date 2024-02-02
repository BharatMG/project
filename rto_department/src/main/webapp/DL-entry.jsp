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
<form action="DLform" method="get">
<h1 class=text-center>Learner's Licence Details</h1>
<div class="container p-4 mt-3 w-50 border border-dark-subtle">
			<h4>${err}</h4>
<div class="form-floating mb-6">
				 <b>Learner's Licence Number:</b><input type="text" class="form-control" name="applicationNumber"  required="required"> 
					</label></div>
					<div>
				<input type="submit" class="btn btn-success"> <input type="reset" class="btn btn-dark">
			</div>
					</div>
					</form>
<%@include file="footer.jsp"%>
</body>
</html>