<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SMARTBUYS ADMINISTRATION</title>
<link rel="stylesheet" href="../CSS/style.css">
<script type="text/javascript" src="../JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${users!=null}">
			Edit User:
		</c:if>
			<c:if test="${users==null}">
		Create New User:
		</c:if>
		</h2>
	</div>
	<div align="center">
		<c:if test="${users!=null}">
			<form action="update_user" method="post" id="userform">
				<input type="hidden" name="userId" value="${users.userId}">
		</c:if>
		<c:if test="${users==null}">
			<form action="create_user" method="post" id="userform">
		</c:if>
		<table class="form">
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="20" value="${users.email}"></td>
			</tr>
			<tr>
				<td align="right">Full Name:</td>
				<td align="left"><input type="text" id="fullname"
					name="fullname" size="20" value="${users.fullname}"></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" id="password"
					name="password" size="20" value="${users.password}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit"
						value="save">Save</button>
					<button type="button" value="cancel"
						onclick="javascript:history.go(-1);">Cancel</button></td>
			</tr>




		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">


$(document).ready(function(){
	$("#userform").validate({
		rules:{
			email: "required",
			fullname:"required",
			password:"required",
		},
		
		messages:{
			email:"Email field cannot be empty",
			fullname:"Name field cannot be empty",
			password:"Password field cannot be empty"
		}
	});
});
	
</script>


</html>