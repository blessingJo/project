<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Opule Accessories Administration</title>

	<link  rel ="stylesheet" href= "../css/style.css" >
</head>
<body>
 
	<jsp:directive.include file = "header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> Admin Dashboard </h2>
	</div>
	
	
	<div align="center">
		<hr width="70%" />
		<h3 class="pageheading"> Actions</h3>
		<a href="create_user"> New User </a> &nbsp;
		<a href="create_product"> New Product </a> &nbsp;
		<a href="create_category"> New Category </a> &nbsp;
		<a href="create_user"> New User</a> 
	
	</div>
	
	<div align = "center">
		<h4 class="pageheading"> Recent Orders:</h4>
		<hr width="70%">
	</div>
	
	<div align = "center">
		<h5 class="pageheading"> Recent Reviews:</h5>
		<hr width="70%">
	</div>
	
	<div align = "center">
		<h6 class="pageheading"> Statistics</h6>
		<hr width="70%">
	</div>
	
	
	
	<jsp:directive.include file = "footer.jsp"/>

</body>
</html>