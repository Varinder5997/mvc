<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html; charset=iso-8859-2" http-equiv="Content-Type">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
.mySlides {display:none;}

.container {
  position: relative;
  text-align: center;
  color: white;
}
.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
<!-- Static content -->
<!-- <title>Mindtree</title> -->

</head>


<!-- 
<link rel="stylesheet" href="/resources/css/style.css"> -->
<body>



<div class="container"">
  <img class="mySlides" src="https://www.w3schools.com/css/paris.jpg" style="width:100%">
  <img class="mySlides" src="https://www.w3schools.com/w3css/img_lights.jpg" style="width:100%">
  <img class="mySlides" src="https://www.w3schools.com/w3css/img_mountains.jpg" style="width:100%">
  <img class="mySlides" src="https://www.w3schools.com/w3css/img_snowtops.jpg" style="width:100%">

</div>


	<div class="centered" align="center">
		<h1>RestoLine</h1>
		<h2>Welcome to RestoLine</h2>
		<br>
		<a href="/register">Register</a>&nbsp;&nbsp;&nbsp;
		<a href="/login">Login</a>
		
	</div>
	
<script>
var myIndex = 0;

var carousel=()=> {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 1000); // Change image every 2 seconds
}
carousel();

</script>
</body>
</html>

