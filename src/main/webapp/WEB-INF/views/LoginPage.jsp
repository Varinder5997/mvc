<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>


.navbar {
  overflow: hidden;
  background-color: #333;
  font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
  float: right;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: right;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

 .dropdown-content {
  display: none;
  position: absolute;
  width: 80%;
  left: 20%;
}

.dropdown-content .header {
  background: red;
  padding: 16px;
  color: white;
} 

.dropdown:hover .dropdown-content {
  display: block;
}

/* Create three equal columns that floats next to each other */
.column {
  float: right;
  width: 10.33%;
  padding: 10px;

  height: 0px;
}


.column a {
  float: none;
  color: black;
  background-color:white;
  padding: 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.column a:hover {
  background-color: #ddd;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

body{
 	background-image: url('https://ak.picdn.net/shutterstock/videos/11130941/thumb/1.jpg');
 	background-repeat: no-repeat;
 	background-size: 120%,120%;
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
	
	

<div class="navbar">

  <div class="dropdown">
    <button class="dropbtn">Dropdown Menu 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
   
      <div class="row">
        <div class="column">
          <a href="/">LogOut</a>
          <a href="#">Thanks</a>

        </div>


      </div>
    </div>
  </div> 
</div>

<div class="abc" align="center">


<h4>User Id = <%=guest.getGuestId() %></h4>
<h4>User Name = <%=guest.getGuestName() %></h4>
<h4>User Address = <%=guest.getGuestAddress() %></h4>

		
			<br>
			<a href="/bookSeat">Book Seat in Restaurant</a>
			&nbsp;&nbsp;&nbsp
			<a href="/reservations">Show all Reservations</a>
			<br>
			<br>



</div>

</body>
</html>