<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Products In ${category.name}</title>
<link rel="stylesheet" href="CSS/style.css">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
	rel="stylesheet">

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div class="content">
		<div align="center">
			<h2>${category.name}</h2>
		</div>
		<div class="main-container">
			<c:forEach items="${listOfProducts}" var="products">
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
					<div class="size">${products.size}</div>
					<div class="price">
						<b>$${products.price}</b>
					</div>
					<div class="addToCart">
						<button class="butttonAddTocart">
							<a href="add_to_cart?product_id=${products.productId}">Add To
								Cart</a>
						</button>
					</div>
				</div>

			</c:forEach>
		</div>
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