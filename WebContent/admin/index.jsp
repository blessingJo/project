<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Opule Accessories Administration</title>
</head>
<body>

	<jsp:directive.include file = "header.jsp"/>
	<div align="center"/>
	<h2> Admin Dashboard </h2>
	
	
	<div align="center">
		<hr width="70%" />
		<h3> Actions</h3>
		<a href="create_user"> New User </a> &nbsp;
		<a href="create_product"> New Product </a> &nbsp;
		<a href="create_category"> New Category </a> &nbsp;
		<a href="create_user"> New User</a> 
	
	</div>
	
	<div align = "center">
		<h4> Recent Orders:</h4>
		<hr width="70%">
	</div>
	
	<div align = "center">
		<h5> Recent Reviews:</h5>
		<hr width="70%">
	</div>
	
	<div align = "center">
		<h6> Statistics</h6>
		<hr width="70%">
	</div>
	
	
	
	<jsp:directive.include file = "footer.jsp"/>

</body>
</html>