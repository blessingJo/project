<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL taglip to specify the core jstl tags-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Products Administration</title>
<link rel = "stylesheet" href="../css/style.css" >
<script type = "text/javascript" src ="../js/jquery-3.5.1.min.js"> </script>
<script type = "text/javascript" src ="../js/jquery.validate.min.js" > </script>
</head>
<body>

	<jsp:directive.include file = "header.jsp"/>
	<div align="center"/>
	<h2 class="pageheading"> Product Management </h2>
	<a href= "product_FormNew"> Create new Product</a>
	<br> </br>
	</div>
	
	<c:if test="${message !=null}">
	<div align="center">  
		<h3 class="message">${message}</h3>
	</div>
	</c:if>
	
	<div align = "center">
		<table border = "1" cellpadding="4">
			<tr>
				<th>index </th>
				<th> ID</th>
				<th>image </th>
				<th>Title </th>
				<th> Category</th>
				<th> Price</th>
				<th> Actions</th>
			</tr>
			
			<c:forEach var="product" items="${listProducts}" varStatus= "status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${product.productId}</td>
				
				<td>
					<img src = "data:image/jpg;base64, ${product.base64Image}"  width= "64" height = "94"/>
				</td>
				
				<td>${product.title}</td>
				<td>${product.category.name}</td>
				<td>${product.price}</td>
				
				
				
				<td>
					<a href="edit_product?id=${product.productId}">Edit</a> &nbsp;
					<!--Use of javascript to show the delete product dialog popuo, confirmDelete method/function will be invoked 
						2. passing the value of the current(chosen) product to the dialog  -->
					<a href="javascript:void(0);"  id="${product.productId}" class="deleteLink">Delete</a>
				</td>
		
			</tr>
			</c:forEach>		
		</table>	
	</div>		
	<jsp:directive.include file = "footer.jsp"/>

	<!-- Declare productId in function to be able to show the product ID in the confirmation dialog 
		2.if product/admin confirms the deletion, DeleteUserServlet will be called to perform the delete method
		3.Pass the id of the selected product to the deleteUserServlet
		4. selector to select all elements with the class delete link line 66 with-->	
		
	<script> 
	
		$(document).ready(function() {
			$(".deleteLink").each(function() {
				$(this).on("click", function() {
					
					productId = $(this).attr("id");
					if (confirm('Are you sure you want to delete the product with ID' + productId + '?')) {
						window.location = 'delete_product?id=' + productId;	
					}					
				})
			})			
		});
	</script>

</body>
</html>