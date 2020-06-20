<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Manage Reviews - SMARTBUYS ADMINISTRATION</title>
<link rel="stylesheet" href="../CSS/style.css">
<script type="text/javascript" src="../JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Review  Management</h2>
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
				<th>Product</th>
				<th>Rating</th>
				<th>headline</th>
				<th>Customer</th>
				<th>Comment</th>
				<th>Reviewed On</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="review" items="${listOfReviews}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${review.reviewId }</td>
					<td>${review.product.productName}</td>
					<td>${review.rating}</td>
					<td>${review.headline}</td>
					<td>${review.customer.fullname}</td>
					<td>${review.comment}</td>
					<td>${review.reviwedTime}</td>
					<td><a href="edit_review?id=${review.reviewId}">Edit</a>&nbsp;
						<a href="javascript:void(0);" class="deletelink" id="${review.reviewId}">Delete</a></td>
				</tr>

			</c:forEach>


		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$(".deletelink").each(function(){
			$(this).on("click",  function(){
				reviewId = $(this).attr("id");
				if (confirm("Are you Sure you want to delete the review with id "
						+ reviewId + "?")) {
					window.location = 'delete_review?id=' + reviewId;
				}
			});
		});
	});
</script>
</html>