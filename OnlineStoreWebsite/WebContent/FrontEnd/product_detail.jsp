<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>${product.productName}</title>
<link rel="stylesheet" href="../CSS/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2>${product.productName}</h2>
		<table width="80%" border="0">
			<tr>
				<td colspan ="3" align="left">
					<h2>${product.productName}</h2>
				</td>
			</tr>
			<tr>
				<td rowspan = "2"><img alt=""
					src="data:image/png;base64,${product.base64Image}" width="128"
					height="164" />
				</td>
				<td valign="top" align="left">
					Rating ****
				</td>
				<td  valign="top" align="left">
					<h3>Size: ${product.size}</h3>
				
				</td>
				<td valign="top" rowspan="2" width="20%">
					<h3>Price: $${product.price}</h3>
					<br><br>
					<button type="submit">Add to Cart</button>
				</td>
			</tr>
			<tr>
				<td>
					 <td>
							<h3>Description:</h3> 
							${product.description}
				     </td>
				
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td> 
					Reviews
				</td>
				<td colspan="2" align="center">
					<button>Write a Review</button>
				</td>
			</tr>


		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>