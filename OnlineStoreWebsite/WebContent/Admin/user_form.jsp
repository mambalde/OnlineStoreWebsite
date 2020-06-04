<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SMARTBUYS ADMINISTRATION</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Create New User</h2>
	</div>
	<div align="center">
		<form action="create_user" method="post"
		 onsubmit=" return validateFormInput()">
			<table>
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email"
						size="20"></td>
				</tr>
				<tr>
					<td align="right">Full Name:</td>
					<td align="left"><input type="text" id="fullname" name="fullname" size="20"></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password"
						size="20"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="save"> <input type="button" value="cancel"
						onclick="javascript:history.go(-1);"></td>
				</tr>




			</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script src="../JS/main.js" type="text/javascript"></script>
</html>