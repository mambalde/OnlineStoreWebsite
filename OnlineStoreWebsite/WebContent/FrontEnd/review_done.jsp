<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Review Submitted</title>
<link rel="stylesheet" href="CSS/style.css">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>

<script type="text/javascript" src="JS/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		
			<table class="reviewform">
				<tr>
					<td>
						<h2>Your Reviews</h2>
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
						<h3>Thank you for Sharing your thoughts</h3>
					</td>
				</tr>
				
			</table>
		
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>