<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO</title>
<%@ include file="styles.jsp"%>

</head>
<body>
	<div class="text-center">
		<img src="https://transport.karnataka.gov.in/frontend/opt1/images/center_logo/kar_main_logo.png" width="80" height="50" alt="pic" title="pic" class="img-responsive cl img-fluid"> <font color="red"
			size=6><b>Transport Department</b></font>
		<div>
			<h6>Government of karnataka</h6>
		</div>
	</div>


	<%@include file="Navbar.jsp"%>
	<form action="rto" method="get">
	<div class="card">
	
				<div class="card-body md-3">
					<div class="text-left mb-3">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li><button class="btn btn-primary"><input class="nav-link"  id="button" type="submit" name="admin" value="LLR-Registeration"></button></li>
				</ul>
						</div>
		</div>	</div>
		<div class="card">
		<div class="card-body md-3">
					<div class="text-right mb-6">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li><button class="btn btn-primary"><input class="nav-link"  id="button" type="submit" name="admin" value="DL-Registeration"></button></li>
				</ul>
						</div>
		</div>	
		
			</div>
			
</form>
	
	
		<img alt="" src="https://paytmblogcdn.paytm.com/wp-content/uploads/2023/10/Blogs_Paytm_Karnataka-Road-Tax-Calculate-Road-Tax-in-Karnataka-Tax-Table-1-800x500.webp" width="100%" height="385">

		<%@include file="footer.jsp"%>

	</div>
</body>
</html>