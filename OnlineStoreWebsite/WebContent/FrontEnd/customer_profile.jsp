<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Customer Profile</title>
<link rel="stylesheet" href="CSS/style.css">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="JS/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<br>

		<h3>Welcome, ${loggedCustomer.fullname}</h3>

		<br>
	

	<table class="product">
		<tr>
			<td>E-mail Address:</td>
			<td>${loggedCustomer.email}</td>
		</tr>
		<tr>
			<td>Full Name:</td>
			<td>${loggedCustomer.fullname}</td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td>${loggedCustomer.phone}</td>
		</tr>
		<tr>
			<td>Country:</td>
			<td>${loggedCustomer.country}</td>
		</tr>
		<tr>
			<td>City:</td>
			<td>${loggedCustomer.city}</td>
		</tr>
		<tr>
			<td>Zip Code:</td>
			<td>${loggedCustomer.zipcode}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="edit_profile">Edit My Profile</a></td>
		</tr>
		

	</table>
	</div>

	<jsp:directive.include file="footer.jsp" />

</body>
</html>