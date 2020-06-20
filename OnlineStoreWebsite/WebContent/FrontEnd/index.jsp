<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="CSS/style.css">
<title>SMARTBUYS</title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
	<h2>New Arrivals</h2>
		<div class="main-container"">
		<c:forEach items="${newProducts}" var="products">
			<div class="card">
				<div>
					<a  href="view_product?id=${products.productId}">
					 <img alt=""
						src="data:image/png;base64,${products.base64Image}" width="128"
						height="164" />
					</a>

				</div>
				<div>
				<a href="view_product?id=${products.productId}">
					<b>${products.productName}</b>
					</a>
				</div>
				<div>Rating ****</div>
				<div>${products.size}</div>
				<div>
					<b>$${products.price}</b>
				</div>
			</div>

		</c:forEach>
	</div>
	<div align="center" style = "clear:both">
		<h3>popular</h3>
	</div>
	<div align="center" style = "clear:both">
		<h3>all time best</h3>
	</div>
	</div>
	<br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>