<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Customer Login</title>
<link rel="stylesheet" href="CSS/style.css">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="JS/jquery.validate.min.js"></script>
</head>
<body>
<jsp:directive.include file="header.jsp" />
	<div align="center">
		
		<h2>Customer Login</h2>
		<c:if test="${message !=null }">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
		</c:if>
		<form action="login" id="loginform" method="post">
			<table>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" id="email" size="20"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password"
						size="20"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Login</button>
					</td>

				</tr>

			</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginform").validate({
			rules : {
				email : {
					required : true,
					email : true
				},

				password : "required",
			},

			messages : {

				email : {
					required : "Email field cannot be empty",
					email : "enter a valid email address"
				},

				password : "Password field cannot be empty"
			}
		});

	});
</script>

</html>