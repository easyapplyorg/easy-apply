<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../includes/head-content.jsp" %>
</head>

<body>
<%@ include file="../includes/header.jsp" %>
<main>
    <h3>Sign Up</h3>

    <form method="post" action="${baseUrl}/applicant-signup">
        <div class="form-group">
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name*"
                   value=${values.firstName}>
            <div style="color:red"><small> ${myErrors.firstName} </small></div>
            <br>

            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name*"
                   value=${values.lastName}>
            <div style="color:red"><small> ${myErrors.lastName} </small></div>
            <br>

            <input type="text" class="form-control" id="address" name="address" placeholder="Address"
                   value=${values.address}>
            <div style="color:red"><small> ${myErrors.address} </small></div>
            <br>

            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                   pattern="\d{3}[\-\s]*\d{3}[\-\s]*\d{4}" placeholder="Phone Number"
                   value=${values.phoneNumber}>
            <div style="color:red"><small> ${myErrors.phoneNumber} </small></div>
            <br>

            <input type="email" class="form-control" id="email" name="email" placeholder="Email*"
                   value=${values.email}>
            <div style="color:red"><small> ${myErrors.email} </small></div>
            <br>

            <input type="password" class="form-control" id="password" name="password" placeholder="Password*"
                   value=${values.password}>
            <div style="color:red"><small> ${myErrors.password} </small></div>
            <br>

            <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm"
                   placeholder="Confirm Password*" value=${values.password}>
            <div style="color:red"><small> ${myErrors.passwordConfirm} </small></div>
            <br>

            <input class="btn btn-primary" type="submit" value="Submit"/>

        </div>
    </form>
</main>

<%@include file="../includes/footer.jsp" %>
</body>
</html>
