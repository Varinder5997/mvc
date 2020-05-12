<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script> 
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideDown("slow");
  });
});
</script>
<style> 
#panel, #flip {
  padding: 5px;
  text-align: center;
  background-color: #e5eecc;
  border: solid 1px #c3c3c3;
}

#panel {
	align-content: center;
	align-items: center;
	align-self:center;
  padding: 50px;
  display: none;
}
#tables{

align-self: center;
align-content: center;
align-items: center;


}
td {
	align-content: center;
	align-items: center;
	align-self: center;
}
</style>
</head>
<body>
<%@page import="com.mindtree.restoline.entiry.*"%>

	<%@page import="java.util.Iterator"%>
	<%
		Guest guest= (Guest)request.getAttribute("guest");
		//System.out.println("code at this point");
	%>
<div align="center">
<h1>Welcome to RestoLine</h1>
<h3>User Name = <%=guest.getGuestName()%></h3>
<br>
<br>

 
<div id="flip">Click to slide down all Reservations</div>
<div id="panel" align="center">
	<div align="center">
			<table border="0" cellpadding="10" class="tables">
			<tr>
					<td>Id</td>
					<td>Hotel Name :</td>
					<td>No Of Seats:</td>
					<td>Status</td>
					
					
					
					
				</tr>
				<%
					Iterator<Reservation> iterator = guest.getReservations().iterator();

					while (iterator.hasNext()) {
						Reservation reservation = iterator.next();
				%>
				
				
				<tr>
					<td><%=reservation.getReservationId() %></td>
					<td><%=reservation.getRestaurant().getResturantName() %></td>
					<td><%=reservation.getNoOfseats() %></td>
					<%if(reservation.isStatus()==true) {%>
					<td><a href="/cancleReservation/<%=reservation.getReservationId()%>">Cancle Booking</a></td>
					<%}
					else{
					%>
					<td>AlreadyCanceled</td>
					<%
					}%>
				</tr>
				
				<%
				
					}
				%>

				

			</table>
			</div>
			</div>
			<br>
			<br>
			&nbsp;&nbsp;&nbsp;<a href="/aa">Go Back</a>
</div>
</body>
</html>