<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Shopping cart</title>
<link rel="stylesheet" href="CSS/style.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="JS/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">

		<h2>Items in Cart</h2>
		<c:if test="${message !=null }">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
		</c:if>
		<c:set var="cart" value="${sessionScope['cart']}" />

		<c:if test="${cart.totalItemsIncart==0}">
			<h2>Cart is Empty</h2>

		</c:if>
		<c:if test="${cart.totalItemsIncart > 0}">
			<form action="update_cart" id="cartForm" method="post">
				<div>
					<table border="1px">
						<tr>
							<th>No</th>
							<th colspan="2">Product</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Subtotal</th>
							<th></th>
						</tr>
						<c:forEach items="${cart.items}" var="item" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td valign="middle"><img alt=""
									src="data:image/png;base64,${item.key.base64Image}" width="128"
									height="164" /></td>
								<td>${item.key.productName}</td>

								<td>
								<input type="hidden" name="productId" value = "${item.key.productId}">
								<input type="text" name="quantity${status.index+1}"
									value="${item.value}" size="5" /></td>
								<fmt:setLocale value="en_US" />
								<td><fmt:formatNumber value="${item.key.price}"
										type="currency" /></td>

								<td><fmt:formatNumber value="${item.value* item.key.price}"
										type="currency" /></td>
								<td><a
									href="remove_from_cart?product_id=
									${item.key.productId}">Remove</a></td>
							</tr>

						</c:forEach>

						<tr>

							<td></td>
							<td></td>
							<td></td>
							<td><b>${cart.totalQuantity} Item(s)</b></td>
							<td>Total:</td>
							<td colspan="2"><fmt:formatNumber
									value="${cart.totalAmount}" type="currency" /></td>

						</tr>

					</table>
				</div>
				<div>
					<table class="form">
					<tr><td>&nbsp;</td></tr>
						<tr>
							<td></td>
							<td><button type="submit">Update</button></td>
							<td><input type="button" id="clearCart" value="Clear cart" class="clear-cart"></td>
							<td><a href="${pageContext.request.contextPath}/">Continue
									Shopping</a></td>
							<td><a href="">Checkout</a></td>

						</tr>

					</table>
				</div>
			</form>



		</c:if>


	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">

	$(document).ready(function() {
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
		$("#clearCart").click(function() {
			window.location = 'clear_cart';
		});
		$("#cartForm").validate({
			rules: {
				<c:forEach items="${cart.items}" var="item" varStatus="status">
					quantity${status.index+1}: {
						required :true, number: true, min:1}
						
			
				</c:forEach>
			},
			messages: {
					<c:forEach items="${cart.items}" var="item" varStatus="status">
						 quantity${status.index+1}: {
							 required :"please enter the amount",
							 number: "must be a number",
							 min: "must be greater than 0"
						 },
					</c:forEach>
			}
		});
	});
</script>

</html>