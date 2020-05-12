<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="java.util.List"%>
	<%@page import="com.mindtree.restoline.entiry.*"%>
	<%@page import="java.util.Iterator"%>
	<%
		List<Restaurant> allRestaurants=(List<Restaurant>)request.getAttribute("allRestaurants");
		//System.out.println("code at this point");
	%>
	
	<div align="center">
		<h1>Select Restaurant</h1>

		<form action="/selectedRestaurant">
			<label for="chooserestaurantId">Choose a restaurant:</label> <select id="chooserestaurantId" name="chooserestaurantId">
				<%
					Iterator<Restaurant> iterator = allRestaurants.iterator();

					while (iterator.hasNext()) {
						Restaurant restaurant = iterator.next();
				%>

				<option value="<%=restaurant.getResturantName()%>"><%=restaurant.getResturantName()%></option>

				<%
					}
				%>
			</select> <br>
			<br>

			<button type="submit">Done</button>


		</form>

		<br>
		<br>
		<br>

	</div>


</body>
</html>