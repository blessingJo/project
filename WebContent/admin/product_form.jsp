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
			<form action="update_product" method="post" id="productForm" enctype="multipart/form-data">	
			<input type="hidden" name="productId" value = "${product.productId}">
		</c:if>
		
		<c:if test="${product == null}">
			<form action="create_product" method="post" id="productForm" enctype="multipart/form-data">	
		</c:if>
		
		<table class="form">
		<tr> 	
		<td>Category: </td>
		<td> 
			<select name ="category">
			<c:forEach items="${listCategory}" var="category">
			<c:if test = "${category.categoryId eq product.category.categoryId}">
					<option value="${category.categoryId}" selected />
			
			</c:if>
			<c:if test = "${category.categoryId ne product.category.categoryId}">
					<option value="${category.categoryId}" />
			</c:if>
					${category.name}				
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
			<td align="left"> <input type="file" id="productImage" name="productImage" size="20"> 
			<img id="thumbnail" alt= "Image Review" style="width:30%; margin-top: 15px"
					src= "data:image/jpg;base64, ${product.base64Image}" />
					</td>
			
		</tr>
			
			<tr>
			
			<td align="right">Description: </td>
			<td align="left"> 
				<textarea rows = "5" cols = "50" name ="description" id="description">${product.description}</textarea>
			</td>
			</tr>
			
		<tr>
		<tr><td>&nbsp;</td></tr>
			<td colspan="2" align="center">
				<button type="submit"> Save </button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="buttonCancel">Cancel</button>
				</td>
		</table>	
	</form>
</div>	

	<jsp:directive.include file = "footer.jsp"/>
</body>

	<!-- JQuery code -->
<script type="text/javascript">
	
 
	$(document).ready(function() {
		$('#productImage').change(function() {
			showingImageThumbnail(this);
			
		});
		$("#productForm").validate({
			rules: {
				title: "required",
				
				<c:if test = "${product == null}">
				productImage: "required",
				</c:if>, 
				
				price: "required",	
				description: "required", 
				category: "required",
			},
			
			messages: {
					title: "Please enter the product title",
					productImage: "Please upload a product Image",
					price: "Please enter the price of the product",
					description: "Please enter a description of the product",
					category: "Please select a category"
					 //category: "Please select a category for the product"
				}		
			}); 
		 
		$("#buttonCancel").click(function() {
			history.go(-1);
			
		});
		
	});
	
	
	function showingImageThumbnail(fileInput) {
		var file = fileInput.files[0];
		
		var filereader = new FileReader();
		
		reader.onload = function(e) { 
			$('#thumbnail').attr('src', e.target.result);
			
		};
		
		reader.readAsDataURL(file);
					
		}
		
</script>
	
</html>