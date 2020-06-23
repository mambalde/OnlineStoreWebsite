<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
	rel="stylesheet">
<title>SMARTBUYS</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
<div class="wrapper">
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">

			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>


			<div class="carousel-inner">
				<div class="item active">
					<img src="images/homeImage1.jpg" alt=""
						style="width: 100%">
				</div>

				<div class="item">
					<img src="images/galery3.jpg" alt=""
					style="width:100%">
				</div>
				
				<div class="item">
					<img src="images/galery2.jpg" alt=""
						style="width:100%">
						
				</div>
			</div>


			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<div class="row" align="center">
		<div class="column">
			<img src="images/homeImage2.jpg" alt="" width="400">
			
		</div>
		<div class="column">
			<img src="images/homeImage4.jpg" alt="" width="400">
		</div>
		<div class="column">
			<img src="images/homeImage3.jpg" alt="" width="400">
		</div>
		<div class="column">
			<img src="images/galery.jpg" alt="" width="400">
		</div>
	</div>

	<div align="center" class="content">
		<h2 class="newarrivals">New Arrivals</h2>
		<div class="main-container">
			<c:forEach items="${newProducts}" var="products">
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
					<div>
						<jsp:directive.include file="product_rating.jsp" />
					</div>
					<div class="size">${products.size}</div>
					<div class="price">
						<b>$${products.price}</b>
					</div>
				</div>

			</c:forEach>
		</div>
		<div align="center" style="clear: both">
			<h3>popular</h3>
		</div>
		<div align="center" style="clear: both">
			<h3>all time best</h3>
		</div>
	</div>
	<br>
	<br>
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