<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write a review</title>
<link rel="stylesheet" href="CSS/style.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>

<script type="text/javascript" src="JS/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<form id="review_form">
			<table class="reviewform">
				<tr>
					<td>
						<h3>You already wrote a review for this product</h3>
					</td>
					<td>&nbsp;</td>
					<td>
						<h2>${loggedCustomer.fullname}</h2>
					</td>

				</tr>
				<tr>
					<td colspan="3"><hr /></td>
				</tr>
				<tr>

					<td>${product.productName}<br>
						<img alt="" src="data:image/png;base64,${product.base64Image}" /></td>
					<td>
						<div id="rateYo"></div>
						 <br><input type="text" name="headline"
						size="60" readonly="readonly" value="${review.headline}"> <br />
						<br /> <textarea rows="10" cols="70" name="comment"
							readonly="readonly">${review.comment}</textarea>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#rateYo").rateYo({
			starWidth : "40px",
			fullStar : true,
			rating: ${review.rating},
			readOnly: true
			});
	});
</script>

</html>