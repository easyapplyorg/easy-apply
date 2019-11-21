<%--
  Created by IntelliJ IDEA.
  User: LuckyGilbert
  Date: 20-Nov-19
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="./includes/head-content.jsp" %>
</head>
<body>
    <%@ include file="./includes/header.jsp" %>
<main>
    <article class="card-body mx-auto" style="max-width: 400px;">
        <h4 class="card-title mt-3 text-center">Login In</h4>
        <p class="text-center">Get started with your free account</p>
        <c:if test="${error!=null}">
            <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">Attention!</h4>
                    <p>Username, Email or Password is wrong!!</p>
            </div>
        </c:if>
        <form method="post" action="${baseUrl}/company-login">
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
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                </div>
                <input class="form-control" placeholder="Enter Password" type="password" name="password" >
            </div> <!-- form-group// -->

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"> Login </button>
            </div> <!-- form-group// -->
            <p class="text-center">Have no account? <a href="company.jsp">Sign up</a> </p>
        </form>

    </article>
</main>
    <%@include file="./includes/footer.jsp" %>
</body>
</html>
