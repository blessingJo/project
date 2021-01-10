<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Product</title>
<link rel = "stylesheet" href="../css/style.css" >

<script type = "text/javascript" src ="../js/jquery-3.5.1.min.js"> </script>
<script type = "text/javascript" src ="../js/jquery.validate.min.js" > </script>
</head>
<body>

	<jsp:directive.include file = "header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> 
			<!-- if there is a product object in the request tben display edit product form  -->
			<c:if test="${product != null}">
				Edit Product
			</c:if>
			
			<c:if test="${product == null}">
				Create New Product 
			</c:if>
			</h2>
	</div>
<!-- Create Product 'save' function cannot be used for the edit product page
	therefore i've used another JSTL if statement -->	
	<div align="center">
		<c:if test="${product != null}">
			<form action="update_product" method="post" id="productForm">	
			<input type="hidden" name="productId" value = "${product.productId }">
		</c:if>
		
		<c:if test="${product == null}">
			<form action="create_product" method="post" id="productForm" >	
		</c:if>
		
		<table class="form">
		<tr> 
		
		<td>Category: </td>
		<td> 
			<select name = "category">
			<c:forEach items = "${listCategory}" var="category">
				<option value = "${category.categoryId}">
					${category.name}
				</option>				
			</c:forEach>
			</select>
			</td>
			</tr>
			
			<tr>
			
			<td align="right">Title: </td>
			<td align="left"> <input type="text" id="title" name="title" size="20" value="${product.title}"/> </td>
		</tr>
			<tr>
			<td align="right">Price: </td>
			<td align="left"> <input type="text" id="price" name="price" size="20" value="${product.price}"/> </td>
			</tr>
			
			<tr>
			
			<td align="right">Image: </td>
			<td align="left"> <input type="file" id="productImage" name="productImage" size="20"/> </td>
			
			
			</tr>
			
			<tr>
			
			<td align="right">Description: </td>
			<td align="left"> 
				<textarea rows = "5" cols = "50" name ="description" id="description"> </textarea>
			</tr>
			
		<tr>
		<tr><td>&nbsp;</td></tr>
			<td colspan="2" align="center">
				<button type="submit"> Save </button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="buttonCancel">Cancel</button>
				</td>
		</table>
		</form>	
		</form>
	</table>
</div>	

	<jsp:directive.include file = "footer.jsp"/>
</body>

	<!-- JQuery code -->
<script type="text/javascript">
	
 
	$(document).ready(function() {
		$("#productForm").validate({
			rules: {
				email: {
					required: true,
					email:true					
				},
				
				fullname: "required",
				password: "required",		
			},
			
			messages: {
				email: {
					required: "Please enter an email",
					email: "Please enter a valid email address"
					
				},
				
				fullname: "Please enter the full name",
				password: "Please enter the password"
			}
			
		});
		
		$("#buttonCancel").click(function() {
			history.go(-1);
			
		});
		
	});
	
		
</script>
	
</html>