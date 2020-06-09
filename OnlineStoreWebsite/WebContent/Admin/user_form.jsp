<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SMARTBUYS ADMINISTRATION</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>
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
			<form action="update_user" method="post"
				onsubmit=" return validateFormInput()">
				<input type="hidden" name="userId" value="${users.userId}"> 
		</c:if>
		<c:if test="${users==null}">
			<form action="create_user" method="post"
				onsubmit=" return validateFormInput()">
		</c:if>
		<table>
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