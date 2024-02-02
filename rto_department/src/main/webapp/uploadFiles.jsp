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
<p>${message}</p>
	<form action="upload" method="post" enctype="multipart/form-data">
<div class="card">
						<div class="card-body">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" name="dlApplicationNumber" value=${appNo}  id="floatingInput" placeholder="enter dlNumber" onKeyPress="if(this.value.length==10) return false;" required="required"> <label
								for="floatingInput">Enter dlApplicationNumber</label>
						</div>
						<!-- <input type="number" name="id" placeholder="enter id"> -->
		<input type="file" name="file" /> <br>
		<input type="submit" value="Upload File">
</div></div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>