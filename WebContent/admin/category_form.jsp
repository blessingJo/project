<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>

<!-- not working -->
<title>
	<c:if test = "${Category != null}">
		Edit Category
	</c:if>
			
	<c:if test="${category == null}">
		Create New Category
		</c:if>
</title>
</head>

<body>

	<jsp:directive.include file = "header.jsp"/>
	<div align="center">
		<h2> 
			<!-- if there is a user object in the request tben display edit user form  -->
			<c:if test="${category != null}">
				Edit Category
			</c:if>
			<c:if test="${category == null}">
				Create New Category </h2>
			</c:if>
	</div>
<!-- Create User 'save' function cannot be used for the edit user page
	therefore i've used another JSTL if statement -->	
	<div align="center">
		<c:if test="${category != null}">
			<form action="update_category" method="post" onsubmit="return validateFormInput()">	
			<input type="hidden" name="id" value = "${category.categoryId}">
		</c:if>
		
		<c:if test="${category == null}">
			<form action="create_category" method="post" onsubmit="return validateFormInput()">	
		</c:if>
		
		<table>
		<tr> 
			<td align="right">Name: </td>
			<td align="left"> <input type="text" id="name" name="name" size="20" value="${category.name}"/> </td>
		</tr>
		<tr>
		<tr><td>&nbsp;</td></tr>
			<td colspan="2" align="center">
				<input type="submit" value="Save">
				<input type="button" value="Cancel" onclick="javascript:history.go(-1);">
				</td>
		</table>
		</form>	
		</form>
	</table>
</div>	

	<jsp:directive.include file = "footer.jsp"/>
</body>
<script type="text/javascript">

	function validateFormInput(){
		var fieldName = document.getElementById("name");

			if(fieldName.value.length ==0) {
				alert("Invalid Category Name Input");
				fieldName.focus();
				return false;
			}
			
			return true;
	}
		
</script>
	
</html>