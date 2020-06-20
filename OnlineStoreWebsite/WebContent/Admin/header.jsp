<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<a href="${pageContext.request.contextPath}/Admin/"> <img
		alt="SMARTBUYSLOGO" src="../images/adminlogo.png">
	</a> <br> <br>
	<div>
		Welcome
		<c:out value="${sessionScope.useremail}" />
		| <a href="logout">Logout</a> <br> <br>
	</div>
	<div id="header-menu">
		<div class="header-item">
			<a href="list_users"> <img alt="adminUserLogo"
				src="../images/adminUser.png" /><br>Users
			</a>
		</div>
		<div>
			<a href="list_category"> <img alt="categoryIcon"
				src="../images/category.png"><br>Categories
			</a>
		</div>
		<div>
			<a href="list_product"> <img alt="" src="../images/items.png"><br>Items
			</a>
		</div>
		<div>
			<a href="list_customer"> <img alt="" src="../images/customer.png"><br>Customers
			</a>
		</div>
		<div>
			<a href="review"> <img alt="" src="../images/rating.png"><br>Reviews
			</a>
		</div>
		<div>
			<a href="order"> <img alt="" src="../images/orders.png"><br>Orders
			</a>
		</div>
	</div>
</div>