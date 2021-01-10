<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align = "center">

	

	<div>
	<!--  use of jstl to display currently logged user's email -->
		Welcome,  <c:out value="${sessionScope.useremail}" /> | <a href= "logout">Logout </a>
		<br/> <br/>
	</div>
	<div id="headermenu">
	
		<div>
		<a href="list_users">
		<img src="../images/users.jpeg" />  <br/> Users </a> 
		</div>
	
		<div>
		<a href="list_category">
		<img src="../images/categoriesIcon.jpeg" /> <br/> Categories</a> 
		</div>
		
		<div>
		<a href="list_products">
		<img src = "../images/productsIcon.jpeg" /> <br/> Products</a> 
		</div>
		
		<div>
		<a href="Customers">
		<img src = "../images/customerIcon.jpeg" /> <br>  Customers </a> 
		</div>	
		
		<div> 
		<a href="orders">
		<img src = "../images/orderIcon.jpeg" /> <br/> Orders </a> 
		</div>
	
		<div>
		<a href="reviews">
		<img src = "../images/ratingsIconultimate.jpeg" /> <br/> Reviews </a> 
		</div>
	 
	
	</div>
</div>
</div>
