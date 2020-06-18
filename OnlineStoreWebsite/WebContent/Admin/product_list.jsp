<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Manage Products - SMARTBUYS ADMINISTRATION</title>
<link rel="stylesheet" href="../CSS/style.css">
<script type="text/javascript" src="../JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Product Management</h2>
		<h3>
			<a href="new_product">Create New Product</a>
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
				<th>Image</th>
				<th>Name</th>
				<th>Category</th>
				<th>Price</th>
				<th>Size</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="products" items="${productList}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${products.productId}</td>
					<td>
						<img alt="" src="data:image/png;base64,${products.base64Image}" width="84" height="100"/>
					</td>
					<td>${products.productName}</td>
					<td>${products.category.name}</td>
					<td>$${products.price}</td>
					<td>${products.size}</td>
					
				
					<td><a href="edit_product?id=${products.productId}">Edit</a>&nbsp; <a
						href="javascript:void(0);" class="deletelink" id="${products.productId}">Delete</a></td>
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
				productId = $(this).attr("id");
				if(confirm('Would you like to delete the user with the id '+ productId+'?')){
					window.location = 'delete_product?id=' + productId;
				}
			});
		});
	});
</script>

</html>