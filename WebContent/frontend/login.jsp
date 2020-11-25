<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div align = "center">
		<jsp:directive.include file = "header.jsp"/>
	</div>
	
	<div align = "center">
		<h2> Please enter your login details:</h2>
		<form>
			Email: <input type ="text" size="10"> <br/>
			Password : <input type="password" size = "10"/>
			<input type="submit" value="Login" />
		</form>
		
	<div align = "center">
		<jsp:directive.include file = "footer.jsp"/>	
	</div>
	
	
	</div>
	
 
</body>
</html>