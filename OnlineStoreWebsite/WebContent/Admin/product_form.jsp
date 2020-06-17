<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CREATE NEW PRODUCT</title>
<link rel="stylesheet" href="../CSS/style.css">
<script type="text/javascript" src="../JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${products!=null}">
			Edit Product:
		</c:if>
			<c:if test="${products==null}">
		Create New Product:
		</c:if>
		</h2>
	</div>
	<div align="center">
		<c:if test="${products!=null}">
			<form action="update_product" method="post" id="productform">
				<input type="hidden" name="userId" value="${users.userId}">
		</c:if>
		<c:if test="${products==null}">
			<form action="create_user" method="post" id="userform">
		</c:if>
		<table class="form">
			<tr>
				<td>Category:</td>
				<td>
					<select name="category">
						<c:forEach items = "${listCategory}" var="category">
							<option value="${category.categoryId}">
							   	${category.name}
							</option>
							
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">Name:</td>
				<td align="left"><input type="text" id="name" name="name"
					size="20" value="${products.productName}"></td>
			</tr>
			<tr>
				<td align="right">Size:</td>
				<td align="left"><input type="text" id="size" name="size"
					size="20" value="${products.size}"></td>
			</tr>
			<tr>
				<td align="right">Product Image:</td>
				<td align="left"><input type="file" id="productImage"
					name="productImage" size="20">
					<img alt="" src="" id="thumbnail"/>
					
				</td>
					
			</tr>
			<tr>
				<td align="right">Description:</td>
				<td align="left">
					<textarea rows="5" cols="50" name="descripton" id=" description"></textarea>
				</td>
				
			</tr>
			<tr>
				<td align="right">Price:</td>
				<td align="left"><input type="text" id="price"
					name="price" size="20" value="${products.price}"></td>
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
	
	$('#productImage').change(function(){
		showImageThumbnail(this);
	});
	
	$("#userform").validate({
		rules:{
			email:{
				required: true,
				email: true
			},
			
			fullname:"required",
			<c:if test="${users == null}">
			    password: "required"
			</c:if>
		},
		
		messages:{
			
			email:{
				required:"Email field cannot be empty",
				email:"enter a valid email address"
			},
			
			fullname:"Name field cannot be empty",
			
			<c:if test="${users == null}">
		          password: "Please enter password"
			</c:if>	
		}
	});
	
	
		$("#cancelbutton").click(function(){
			history.go(-1);
		});
		
});
	
	function showImageThumbnail(fileInput){
		var file = fileInput.files[0];
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);
		};
		
		reader.readAsDataURL(file);
	}
</script>


</html>