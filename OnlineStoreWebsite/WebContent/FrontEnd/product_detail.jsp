<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>${product.productName}</title>
<link rel="stylesheet" href="CSS/style.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div class="product-main-container, content">
		<table class="form">
			<tr>
				<td colspan="3" align="left">
					<h2>${product.productName}</h2>
				</td>
			</tr>
			<tr>
				<td rowspan="2"><img alt=""
					src="data:image/png;base64,${product.base64Image}" /></td>
				<td valign="top" align="left"><c:forTokens
						items="${product.ratingStars}" delims="," var="star">
						<c:if test="${star eq 'on'}">
							<img alt="star" src="images/rating_on.png">
						</c:if>
						<c:if test="${star eq 'off'}">
							<img alt="star" src="images/rating_off.png">
						</c:if>
						<c:if test="${star eq 'half'}">
							<img alt="star" src="images/rating_half.png">
						</c:if>

					</c:forTokens>&nbsp; <a href="#reviews">${fn:length(product.reviews)}&nbsp;Reviews</a></td>
				<td valign="top" align="left">
					<h3>Size: ${product.size}</h3>

				</td>
				<td valign="top" rowspan="2" width="20%">
					<h3 class="price">Price: $${product.price}</h3> <br> <br>
					<button id="butttonAddTocart">Add to Cart</button>
				</td>
			</tr>
			<tr>
				<td>
				<td>
					<h3>Description:</h3> ${product.description}
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><h2>
						<a id="reviews">Reviews</a>
					</h2></td>
				<td colspan="2" align="center">
					<button id="buttonWriteReview">Write a Review</button>
				</td>
			</tr>
			<tr>
				<td colspan="3">

					<table class="form">
						<c:forEach items="${product.reviews}" var="reviews">
							<tr>
								<td><c:forTokens items="${reviews.stars}" delims=","
										var="star">
										<c:if test="${star eq 'on'}">
											<img alt="star" src="images/rating_on.png">
										</c:if>
										<c:if test="${star eq 'off'}">
											<img alt="star" src="images/rating_off.png">
										</c:if>

									</c:forTokens> - <b>${reviews.headline}</b></td>

							</tr>
							<tr>
								<td>Reviewed By:&nbsp;
									${reviews.customer.fullname}&nbsp;on&nbsp;
									${reviews.reviwedTime}</td>

							</tr>
							<tr>
								<td><i>${reviews.comment}</i></td>

							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>

						</c:forEach>

					</table>

				</td>

			</tr>


		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
	
		$("#buttonWriteReview").click(function() {
			window.location = 'write_review?product_id=' + ${product.productId};
			;
		});
		$("#butttonAddTocart").click(function() {
			window.location = 'add_to_cart?product_id=' + ${product.productId};
			;
		});
		
		window.onscroll = function() {myFunction()};

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