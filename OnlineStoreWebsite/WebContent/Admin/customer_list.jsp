<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Manage Customers - SMARTBUYS ADMINISTRATION</title>
<link rel="stylesheet" href="../CSS/style.css">
<script type="text/javascript" src="../JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Customer Management</h2>
		<h3>
			<a href="customer_form.jsp">Create New Customer</a>
		</h3>
	</div>

	<c:if test="${message !=null }">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>E-mail</th>
				<th>Full Name</th>
				<th>Country</th>
				<th>City</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${customer.customerId}</td>
					<td>${customer.email}</td>
					<td>${customer.fullname}</td>
					<td>${customer.country}</td>
					<td>${customer.registeredDate}</td>
					
				
					<td><a href="edit_customer?id=${customer.customerId}">Edit</a>&nbsp; <a
						href="javascript:void(0);" class="deletelink" id="${customer.customerId}">Delete</a></td>
				</tr>

			</c:forEach>


		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">

	$(document).ready(function(){
		$(".deletelink").each(function(){
			$(this).on("click", function(){
				customerId = $(this).attr("id");
				if(confirm('Would you like to delete the Customer with the id '+ customerId+'?')){
					window.location = 'delete_customer?id=' + customerId;
				}
			});
		});
	});
</script>

</html>