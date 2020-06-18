<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Products In ${category.name}</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2>${category.name}</h2>
	</div>
	<div align="center" style ="width:80%; margin: 0 auto">
		<c:forEach items="${listOfProducts}" var="products">
			<div style=" display: inline-block; marging:  20px; padding: 20px ">
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

	<jsp:directive.include file="footer.jsp" />
</body>
</html>