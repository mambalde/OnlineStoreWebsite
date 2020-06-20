<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CREATE NEW PRODUCT</title>
<link rel="stylesheet" href="../CSS/style.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="..//CSS/richtext.min.css">

<script type="text/javascript" src="../JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>
<script type="text/javascript" src="../JS/jquery.richtext.min.js"></script>
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
			<form action="update_product" method="post" id="productform"
				enctype="multipart/form-data">
				<input type="hidden" name="productId" value="${products.productId}">
		</c:if>
		<c:if test="${products==null}">
			<form action="create_product" method="post" id="productform"
				enctype="multipart/form-data">
		</c:if>
		<table class="form">
			<tr>
				<td>Category:</td>
				<td><select name="category">
						<c:forEach items="${listCategory}" var="category">
							<c:if
								test="${category.categoryId eq products.category.categoryId}">
								<option value="${category.categoryId}" selected>
							</c:if>
							<c:if
								test="${category.categoryId ne products.category.categoryId}">
								<option value="${category.categoryId}">
							</c:if>
								${category.name}
							</option>

						</c:forEach>
				</select></td>
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
					name="productImage" size="20"><br> <img alt=""
					src="
					data:image/png;base64,${products.base64Image}"
					id="thumbnail" / style="width: 20%; margin-top: 10px"></td>

			</tr>
			<tr>
				<td align="right">Description:</td>
				<td align="left"><textarea rows="5" cols="50"
						name="description" id="description">${products.description}</textarea></td>

			</tr>
			<tr>
				<td align="right">Price:</td>
				<td align="left"><input type="text" id="price" name="price"
					size="20" value="${products.price}"></td>
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
	$(document).ready(function() {

		$('#productImage').change(function() {
			showImageThumbnail(this);
		});
		
		$('#description').richText();


		$("#productform").validate({
			rules : {
				category : "required",
				name : "required",
				size : "required",
				price : "required",
				
				<c:if test="${products==null}">
				productImage : "required",
				</c:if>
				description : "required",

			},

			messages : {
				category : "Select a category",
				name : "The name is required",
				size : "the size is required",
				price : "the price is required",
				productImage : "the product's image is required",
				description : "the product's description is required"
			}
		});

		$("#cancelbutton").click(function() {
			history.go(-1);
		});

	});

	function showImageThumbnail(fileInput) {
		var file = fileInput.files[0];
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);
		};

		reader.readAsDataURL(file);
	}
</script>


</html>