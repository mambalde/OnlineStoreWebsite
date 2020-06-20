<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../CSS/style.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="..//CSS/richtext.min.css">
<script type="text/javascript" src="../JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../JS/jquery.validate.min.js"></script>
<script type="text/javascript" src="../JS/jquery.richtext.min.js"></script>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Edit Review</h2>
	</div>
	<div align="center">
		<form action="update_review" method="post" id="reviewform">
		<input type="hidden" name="reviewId" value="${review.reviewId}">
			<table class="form">

				<tr>
					<td align="right"><b>Product's Name:</b></td>
					<td align="left">${review.product.productName}</td>
				</tr>
				<tr>
					<td align="right"><b>Rating:</b></td>
					<td align="left">${review.rating}</td>
				</tr>
				<tr>
					<td align="right"><b>Customer:</b></td>
					<td align="left">${review.customer.fullname}</td>
				</tr>
				<tr>
					<td align="right"><b>Headline:</b></td>
					<td align="left"><input type="text" size="60" name="headline"
						value="${review.headline}" /></td>
				<tr>
					<td align="right"><b>Comment:</b></td>
					<td align="left"><textarea rows="5" cols="40" name="comment" id="comment">${review.comment}</textarea>
					</td>
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
		
		$('#ddcomment').richText();
		$("#reviewform").validate({
			rules : {
				headline : "required",
				comment: "required",
			},
			messages : {
				headline : "required",
				comment: "required"
			}
		});

		$("#cancelbutton").click(function() {
			history.go(-1);
		});
	});
</script>
</html>