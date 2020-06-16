<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>SMARTBUYS ADMINISTRATION</title>
	<link rel="stylesheet" href="../CSS/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Admin Dashboard:</h2>
	</div>
	<div align="center">
		<hr width=60%>
		<h2 class="pageheading">Quick Actions:</h2>
		<b> <a href="new_item">New Item</a>&nbsp; <a href="new_customer">New
				Customer</a>&nbsp; <a href="new_category">New Category</a>&nbsp; <a
			href="new_user">New User</a>&nbsp;
		</b>
	</div>
	<div align="center">
		<hr width=60%>
		<h2 class="pageheading">Recent Sales:</h2>
	</div>
	<div align="center">
		<hr width=60%>
		<h2 class="pageheading">Recent Reviews:</h2>
	</div>
	<div align="center">
		<hr width=60%>
		<h2 class="pageheading">Recent Stats:</h2>
		<hr width=60%>

	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>