<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="CSS/style.css">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
	rel="stylesheet">
<title>Results for ${keyword}</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">

		<h2>Results for "${keyword}"</h2>
	</div>
	<div class="content, main-container">
		<c:if test="${fn:length(searchResult)==0}">
			<h2>No match found for "${keyword}"</h2>
		</c:if>
		<c:if test="${fn:length(searchResult)>0}">
			<c:forEach items="${searchResult}" var="products">
				<div class="card">
					<div>
						<a href="view_product?id=${products.productId}"> <img alt=""
							src="data:image/png;base64,${products.base64Image}" width="200"
							height="300" />
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
						<b>Price: $${products.price}</b>
						<h3>
							<a href="add_to_cart?product_id=${products.productId}">Add To
								Cart</a>
						</h3>
					</div>
				</div>

			</c:forEach>
	</div>
	</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
$(document).ready(function() {

	window.onscroll = function() {
		myFunction()
	};

	var header = document.getElementById("myHeader");
	var sticky = header.offsetTop;

	function myFunction() {
		if (window.pageYOffset > sticky) {
			header.classList.add("sticky");
		} else {
			header.classList.remove("sticky");
		}
	}
});
</script>
</html>