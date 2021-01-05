<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Internal Server Error</title>
</head>
<body>


	<div align = "center">
	<div>
		<img src= "${pageContext.request.contextPath}/images/logo.jpeg"/>
	</div>
	<div>
	<h2> The server has encountered an error, please try again later</h2>
	</div>
	<div>
		<a href="javascript:history.go(-1);"> Go Back</a>
	</div>
	</div>
</body>
</html>