<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add new User</title>
<style>
.parallax {
  /* The image used */
  background-image: url("https://www.w3schools.com/w3css/img_mountains.jpg");

  /* Set a specific height */
  min-height: 500px; 

  /* Create the parallax scrolling effect */
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
</head>
<body>
<p align="center">Scroll Down this page For Login to the Restaurant.</p>
<div class="parallax"></div>
	<div align="center">
		<h1>Login Guest</h1>
		<br />
		<form:form action="/login-user" method="POST" modelAttribute="loginDto">

			<table border="0" cellpadding="10">
				<tr>
					<td>Guest Email:</td>
					<td><form:input path="guestEmail" /></td>

				

				</tr>
				<tr>
					<td>Guest Password:</td>
					<td><form:input type ="password" path="guestPassword" /></td>
				</tr>
				

				<tr>
					<td colspan="2"><button type="submit">Login</button></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>