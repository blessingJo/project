<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Admin Login </title>
<link rel = "stylesheet" href="../css/style.css" >
<script type = "text/javascript" src ="../js/jquery-3.5.1.min.js"> </script>
<script type = "text/javascript" src ="../js/jquery.validate.min.js" > </script>
</head>
<body>

<div align="center">
<h1> Opule Accessories Administration</h1>
<!--  only display a message if there's a message attribute request and the value is not null -->
<h2> Admin login Portal</h2>
		
		<c:if test="${message !=null}">
			<div align="center">  
				<h4 class="message">${message}</h4>
	</div>
	</c:if>



<form  id="formLogin" action="login" method="post">
	<table>
		<tr>
			<td> Email: </td>
			<td> <input type="text" name="email" id="email" size="22"> </td>
		</tr>
		<tr>
			<td> Password: </td>
			<td> <input type="text" name="password" id="password" size="22"> </td>
		</tr>	
		<tr>
			<td colspan="2" align="center">
				<button type="submit">Login</button>	
			</td>
		</tr>
	</table>


</form>

</div>


</body>

		<script type="text/javascript">
	
 
	$(document).ready(function() {
		$("#formLogin").validate({
			rules: {
				email: {
					required: true,
					email:true					
				},
				
		
				password: "required",		
			},
			
			messages: {
				email: {
					required: "Please enter an email ",
					email: "Please enter a valid admin email addres s"
					
				},
				
				password: "Please enter the password"
			}
			
		});
		
	
	});
	
		
</script>
</html>