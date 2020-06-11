<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CREATE NEW CATEGORY</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>
			<c:if test="${category }!=null}">
			Edit User:
		</c:if>
			<c:if test="${category==null}">
		Create New Category
		</c:if>
		</h2>
	</div>
	<div align="center">
		<c:if test="${category!=null}">
			<form action="update_category" method="post"
				onsubmit=" return validateFormInput()">
				<input type="hidden" name="categoryId"
					value="${category.categoryId}">
		</c:if>
		<c:if test="${category==null}">
			<form action="create_category" method="post"
				onsubmit=" return validateFormInput()">
		</c:if>
		<table>

			<tr>
				<td align="right">Name:</td>
				<td align="left"><input type="text" id="name" name="name"
					size="20" value="${category.name}"></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="save"> <input type="button" value="cancel"
					onclick="javascript:history.go(-1);"></td>
			</tr>




		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">

function validateFormInput() {
	
	var CategoryNameField = document.getElementById("name");
	if (CategoryNameField.value.length == 0) {
		alert("name cannot be empty");
		CategoryNameField.focus();
		return false;
	}
	
	return true;

}
</script>
</html>