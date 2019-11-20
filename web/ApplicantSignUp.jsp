<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Appicant SignUP</title>
</head>


<body>
    <%@ include file="./includes/header.jsp"%>
    
    <div  class="container">
                
				<h3>Applicant SignUp page</h3>
				
				
				<form method="post" action="ApplicantFormValidatorServlet" >
				            <div class="form-group">
				               <label for="firstName">* First Name</label>
			              <input type="text" class="form-control" id="firstName"   name="firstName"
			              value=${values.firstName}>
				          <div style="color:red">  <small> ${myErrors.firstName} </small></div><br>
				          
				          
				      
				           <label for="lastName">*Last Name</label>
			              <input type="text" class="form-control" id="lastName"  name="lastName"
			              value=${values.lastName}>
				          <div style="color:red">  <small> ${myErrors.lastName} </small></div><br>
				         
				       <label for="address">*Address</label>
			              <input type="text" class="form-control" id="address"   name="address"
			              value=${values.address}>
				          <div style="color:red">  <small> ${myErrors.address} </small></div><br>
				       
				 <label for="phoneNumber">*Phone_Number</label>
			              <input type="text" class="form-control" id="phoneNumber"   name="phoneNumber" pattern="000-\d{3}-\d{4}" placeholder="000-XXX-XXXX"   title=" pattern 000-XXX-XXXX"
			              value=${values.phoneNumber}>
				          <div style="color:red">  <small> ${myErrors.phoneNumber} </small></div><br>
				          
				           <label for="email">*Email</label>
			              <input type="email" class="form-control" id="email"  name="email"
			              value=${values.email}>
				          <div style="color:red">  <small> ${myErrors.email} </small></div>
				 

				<input class="btn btn-primary" type="submit" value="Submit"/>
				 
				 </div> 
			</form>
				
    
    <%@include file="./includes/footer.jsp"%>
</body>
</html>