<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document)
			.ready(
					
						function(){
						
							$('#noOfRoomcheck').hide();
							var bookingfrom_err = true;
							
							
							
							
							$('#id').keyup(function(){
								bookingfrom_check();
							});
							
				
							
							function bookingfrom_check(){
								var booking_from = $('#id').val();
								var distancetest=/^[1-6]{0,1}$/
								if(!distancetest.test(booking_from)){
									$('#noOfRoomcheck').show();
									$('#noOfRoomcheck').html(
											"You can not book more then Six rooms of this hotel");
									$('#noOfRoomcheck').focus();
									$('#noOfRoomcheck').css('color','red');
									bookingfrom_err =false;
									return false;
								}
								else{
									$('#noOfRoomcheck').hide();
								}
							}
							
							
							
							$('#submitbtn')
							.click(
									function(){
										bookingfrom_err = true;
										
										
										bookingfrom_check();
										if(bookingfrom_err == true
												){
										
											return true;
										}else{
											return false;
										}	
																			
									});
						});

</script>
</head>
<body>

	<div align="center">
		<h1>Enter the no of seats you want to enter</h1>
		<br />
		<form:form action="/no-of-seats" method="POST" modelAttribute="seatDto">

			<table border="0" cellpadding="10">
				<tr>
					<td>Seats:</td>
					<td><form:input path="seats" id="id" /></td>
					<td><h7 id="noOfRoomcheck"></h7></td>
	
				</tr>
				<tr>
					<td colspan="2"><button type="submit" id ="submitbtn">Save</button></td>
				</tr>			

			</table>
		</form:form>
	</div>

</body>
</html>