<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../CSS/style.css">
<script type="text/javascript" src="../JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>
			<c:if test="${category!=null}">
			Edit Category:
		</c:if>
			<c:if test="${category==null}">
		Create New Category
		</c:if>
		</h2>
	</div>
	<div align="center">
		<c:if test="${category!=null}">
			<form action="update_category" method="post" id="categoryform">
				<input type="hidden" name="categoryId"
					value="${category.categoryId}">
		</c:if>
		<c:if test="${category==null}">
			<form action="create_category" method="post" id="categoryform">
		</c:if>
		<table class="form">

			<tr>
				<td align="right">Name:</td>
				<td align="left"><input type="text" id="name" name="name"
					size="20" value="${category.name}"></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit"
						value="save">Save</button>
					<button type="button" value="cancel" id="cancelbutton">Cancel</button></td>
			</tr>




		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#categoryform").validate({
			rules:{
				name:"required",
			},
			messages:{
				name:"category's name cannot be empty"
			}
		});
		
		$("#cancelbutton").click(function(){
			history.go(-1);
		});
	});
</script>
</html>