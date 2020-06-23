<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="CSS/style.css">
<title>Results for ${keyword}</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		
			<h2>Results for "${keyword}"</h2>
	</div>
	<div class="main-container">
		<c:if test="${fn:length(searchResult)==0}">
			<h2>No match found for "${keyword}"</h2>
		</c:if>
		<c:if test="${fn:length(searchResult)>0}">
			<c:forEach items="${searchResult}" var="products">
				<div class="card">
					<div>
						<a href="view_product?id=${products.productId}"> <img alt=""
							src="data:image/png;base64,${products.base64Image}" width="128"
							height="164" />
						</a>

					</div>
					<div>
						<a href="view_product?id=${products.productId}"> <b>${products.productName}</b>
						</a>
					</div>
					    <jsp:directive.include file="product_rating.jsp" />
					<div class="size">
						<h3>Size: ${products.size}</h3>
					</div>
					<div class="price">
						<h3>Price: $${products.price}</h3>
						<h3><a href="add_to_cart?product_id=${products.productId}">Add To Cart</a></h3>
					</div>
				</div>

			</c:forEach>
	</div>
	</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>