<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">



<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Thank you</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
 <%@ include file="./includes/header.jsp"%>
        <div  class="container">
        
                   
			
			<p class="text-md-right"> Time:${today}</p>
			
			<p> First Name :${savedFormData.firstName}</p>
			<p> Last Name :${savedFormData.lastName}</p>
			<p> Address:${savedFormData.address}</p> 
			<p> Phone Number: ${savedFormData.phoneNumber}</p>
			<p> Email: ${savedFormData.email}</p>
			<h4> Thank You for your application , your details have been submitted successfully</h4>
			
   
		</div>
			</body>
			</html>