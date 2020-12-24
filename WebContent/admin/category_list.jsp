<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL taglip to specify the core jstl tags-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Categories Accessories Administration</title>
</head>
<body>

	<jsp:directive.include file = "header.jsp"/>
	<div align="center"/>
	<h2> Category Management </h2>
	<a href= "category_form.jsp"> Create new Category</a>
	<br> </br>
	</div>
	
	<c:if test="${message !=null}">
	<div align="center">  
		<h3><i>${message}</i> </h3>
	</div>
	</c:if>
	
	<div align = "center">
		<table border = "1" cellpadding="4">
			<tr>
				<th>index </th>
				<th> ID</th>
				<th>Category Name </th>
				<th> Actions</th>
			</tr>
			
			<c:forEach var="categ" items="${listCategories}" varStatus= "status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${categ.categoryId}</td>
				<td>${categ.name}</td>
				
				<td>
					<a href="edit_category?id=${categ.categoryId}">Edit</a> &nbsp;
					<!--Use of javascript to show the delete user dialog popuo, confirmDelete method/function will be invoked 
						2. passing the value of the current(chosen) user to the dialog  -->
					<a href="javascript:confirmDelete(${categ.categoryId})">Delete</a>
				</td>
		
			</tr>
			</c:forEach>		
		</table>	
	</div>		
	<jsp:directive.include file = "footer.jsp"/>

	<!-- Declare userId in function to be able to show the user ID in the confirmation dialog 
		2.if user/admin confirms the deletion, DeleteUserServlet will be called to perform the delete method
		3.Pass the id of the selected user to the deleteUserServlet-->	
	 <script>
		function confirmDelete(categoryId) {
			if (confirm('Are you sure you want to delete the category with ID ' + categoryId + '?')) {
			window.location = 'delete_category?id=' + categoryId;	
			}
		}
	</script>

</body>
</html>