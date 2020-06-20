<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>REGISTER AS A CUSTOMER</title>
<link rel="stylesheet" href="CSS/style.css">
<script type="text/javascript" src="JS/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="JS/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">REGISTER AS A CUSTOMER</h2>
	</div>
	<div align="center">
		<form action="register_customer" method="post" id="customerform">
			<table class="form">
				<tr>
					<td align="right">E-mail:</td>
					<td align="left"><input type="text" id="email" name="email"
						size="45"></td>
				</tr>
				<tr>
					<td align="right">Full Name:</td>
					<td align="left"><input type="text" id="name" name="name"
						size="45"></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password"
						name="password" size="45"></td>
				</tr>
				<tr>
					<td align="right">Confirm Password:</td>
					<td align="left"><input type="password" id="confirmpassword"
						name="confirmpassword" size="45"></td>
				</tr>
				<tr>
					<td align="right">Address:</td>
					<td align="left"><input type="text" id="address"
						name="address" size="45" ></td>

				</tr>
				<tr>
					<td align="right">Phone Number:</td>
					<td align="left"><input type="text" id="phone" name="phone"
						size="45" ></td>
				</tr>
				<tr>
					<td align="right">Country:</td>
					<td align="left"><input type="text" id="country"
						name="country" size="45" ></td>
				</tr>
				<tr>
					<td align="right">City:</td>
					<td align="left"><input type="text" id="city" name="city"
						size="45"></td>
				</tr>
				<tr>
					<td align="right">Zip Code:</td>
					<td align="left"><input type="text" id="zipcode"
						name="zipcode" size="45" ></td>
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

		$("#customerform").validate({
			rules : {
				email : {
					required : true,
					email : true
				},

				name : "required",
				address : "required",
				country : "required",
				city : "required",
				password : "required",

				confirmpassword : {
					required : true,
					equalTo : "#password"

				},
				zipcode : "required",
				phone : "required"

			},

			messages : {
				email : {
					required : "Your email is required to register",
					email : "please enter a valid email"
				},

				name : "The name cannot be empty",
				address : "The address cannot be empty",
				country : "required",
				city : "The city cannot be empty",
				password : "The password cannot be empty",
				confirmpassword : {
					required : "please confirm your password",
					equalTo : "The password does not Match"

				},

				zipcode : "required",
				phone : "Please enter your phone number"
			}
		});

		$("#cancelbutton").click(function() {
			history.go(-1);
		});

	});
</script>


</html>