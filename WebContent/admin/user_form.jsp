<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New User</title>
<link rel = "stylesheet" href="../css/style.css" >

<script type = "text/javascript" src ="../js/jquery-3.5.1.min.js"> </script>
<script type = "text/javascript" src ="../js/jquery.validate.min.js" > </script>
</head>
<body>

	<jsp:directive.include file = "header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> 
			<!-- if there is a user object in the request tben display edit user form  -->
			<c:if test="${user != null}">
				Edit User
			</c:if>
			
			<c:if test="${user == null}">
				Create New User 
			</c:if>
			</h2>
	</div>
<!-- Create User 'save' function cannot be used for the edit user page
	therefore i've used another JSTL if statement -->	
	<div align="center">
		<c:if test="${user != null}">
			<form action="update_user" method="post" id="userForm">	
			<input type="hidden" name="userId" value = "${user.userId }">
		</c:if>
		
		<c:if test="${user == null}">
			<form action="create_user" method="post" id="userForm" >	
		</c:if>
		
		<table class="form">
		<tr> 
			<td align="right">Email: </td>
			<td align="left"> <input type="text" id="email" name="email" size="20" value="${user.email}"/> </td>
		</tr>
		<tr>
			<td align="right">Full Name: </td>
			<td align="left"> <input type="text" id="fullname" name="fullname" size="20" value="${user.fullName}" /> </td>
		</tr>
		<tr>
			<td align="right">Password: </td>
			<td align="left"> <input type="password" id="password" name="password" size="20" value="${user.password}" /> </td>
		</tr>
		<tr>
		<tr><td>&nbsp;</td></tr>
			<td colspan="2" align="center">
				<button type="submit"> Save </button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button onclick="javascript:history.go(-1);">Cancel</button>
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
		$("#userForm").validate({
			rules: {
				email: "required",
				fullname: "required",
				password: "required",		
			},
			
			messages: {
				email: "Please enter an email",
				fullname: "Please enter the full name",
				password: "Please enter the password",
			}
			
		});
		
	});
	
	
	function validateFormInput(){
		var fieldEmail = document.getElementById("email");
		var fieldFullname = document.getElementById("fullname");
		var fieldPassword = document.getElementById("password");

			if(fieldEmail.value.length ==0) {
				alert("Invalid Email Input");
				fieldEmail.focus();
				return false;
			}
			
			if(fieldFullname.value.length ==0) {
				alert("Full Name must not be left blank");
				fieldFullname.focus();
				return false;
			}
			
			if(fieldPassword.value.length ==0) {
				alert("A Password Input is required");
				fieldPassword.focus();
				return false;
			}
			
			return true;
	}
		
</script>
	
</html>