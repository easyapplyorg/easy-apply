<%--
  Created by IntelliJ IDEA.
  User: LuckyGilbert
  Date: 19-Nov-19
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="./includes/head-content.jsp" %>
</head>
<body>
<%@ include file="/includes/header.jsp" %>
<main>
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Create Company Account</h4>
            <p class="text-center">Get started with your free account</p>
            <c:if test="${errors!=null}">
                <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">Missing Fields!</h4>
                <c:forEach var="error" items="${requestScope.errors}">
                    <p>${error}</p>
                </c:forEach>
                </div>
            </c:if>
            <form method="post" action="${baseUrl}/company-servlet">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Company name" type="text" name="name" value="${requestScope.company.name}">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Email addresss" type="email" name="email" value="${requestScope.company.email}">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Website" type="text" name="website" value="${requestScope.company.website}">
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Location" type="text" name="location" value="${requestScope.company.location}">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Industry" type="text" name="industry" value="${requestScope.company.industry}">
                </div> <!-- form-group// -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Create Account </button>
                </div> <!-- form-group// -->
                <p class="text-center">Have an account? <a href="">Log In</a> </p>
            </form>

        </article>

</main>
<%@include file="./includes/footer.jsp" %>
</body>
</html>
