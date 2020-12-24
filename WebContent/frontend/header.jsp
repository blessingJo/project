<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align = "center">
	<div>
		<img src = "images/logo.jpeg" />
	</div>	
		
	<div>
		<input type= "text" name="keyword" size="50" />
		<input type="button" value = "Search" />	
	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="login.jsp"> Log In</a> |
		<a href="signin"> Register</a> |
		<a href="view_cart"> Cart</a>

		
	</div>
	
	
	<div> 
	<!-- JSTL to display all categories -->
		<c:forEach var = "category" items="${listCategory}" varStatus="status">
			<a href = " view_category?id=${category.categoryId}">
				<font size="+2"> </font><b> <c:out value = "${category.name}" /> </b>
			</a>
			<!-- removing the vertical line after the last category-->
			<c:if test= "${not status.last}">
			&nbsp; | &nbsp;
			</c:if>
			 
		
		
		</c:forEach>
	
	
	
	
	
	
	</div>