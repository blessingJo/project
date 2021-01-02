<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL taglip to specify the core jstl tags-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Users Administration</title>
<link rel = "stylesheet" href="../css/style.css" >
<script type = "text/javascript" src ="../js/jquery-3.5.1.min.js"> </script>
<script type = "text/javascript" src ="../js/jquery.validate.min.js" > </script>
</head>
<body>

	<jsp:directive.include file = "header.jsp"/>
	<div align="center"/>
	<h2 class="pageheading"> User Management </h2>
	<a href= "user_form.jsp"> Create new User</a>
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
				<th>Full Name </th>
				<th>Email </th>
				<th> Actions</th>
			</tr>
			
			<c:forEach var="user" items="${listUsers}" varStatus= "status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${user.userId}</td>
				<td>${user.fullName}</td>
				<td>${user.email}</td>
				
				<td>
					<a href="edit_user?id=${user.userId}">Edit</a> &nbsp;
					<!--Use of javascript to show the delete user dialog popuo, confirmDelete method/function will be invoked 
						2. passing the value of the current(chosen) user to the dialog  -->
					<a href="javascript:void(0);"  id="${user.userId}" class="deleteLink">Delete</a>
				</td>
		
			</tr>
			</c:forEach>		
		</table>	
	</div>		
	<jsp:directive.include file = "footer.jsp"/>

	<!-- Declare userId in function to be able to show the user ID in the confirmation dialog 
		2.if user/admin confirms the deletion, DeleteUserServlet will be called to perform the delete method
		3.Pass the id of the selected user to the deleteUserServlet
		4. selector to select all elements with the class delete link line 66 with-->	
		
	<script> 
	
		$(document).ready(function() {
			$(".deleteLink").each(function() {
				$(this).on("click", function() {
					
					userId = $(this).attr("id");
					if (confirm('Are you sure you want to delete the user with ID' + userId + '?')) {
						window.location = 'delete_user?id=' + userId;	
					}					
				})
			})			
		});
	</script>

</body>
</html>