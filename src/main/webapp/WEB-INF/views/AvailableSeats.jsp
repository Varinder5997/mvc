<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@page import="com.mindtree.restoline.entiry.*"%>
	<%@page import="com.mindtree.restoline.dto.*" %>
	<%@page import="java.util.Iterator"%>
	<%
		SeatDto seat= (SeatDto)request.getAttribute("s");
		//System.out.println("code at this point");
	%>

<h1>Welcome to RestoLine</h1>
<h4>Sorry in this Restaurant only = <%=seat.getSeats() %> seats are available</h4>


		
			<br>
			
	&nbsp;&nbsp;&nbsp;<a href="/aa">Go Back</a>


</body>
</html>