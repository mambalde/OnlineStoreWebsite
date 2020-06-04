<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Manage Users - SMARTBUYS ADMINISTRATION</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>User Management</h2>
		<h3>
			<a href="user_form.jsp">Create New User</a>
		</h3>
	</div>
	<div align="center">
		<table border="1" cellpadding ="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="users" items="${listUsers }" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${users.userId }</td>
					<td>${users.email }</td>
					<td>${users.fullname }</td>
					<td>
						<a href="">Edit</a>
						<a href="">Delete</a>
					</td>
				</tr>

			</c:forEach>


		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>