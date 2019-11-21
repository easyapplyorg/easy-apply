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
    <%@ include file="../includes/head-content.jsp" %>
</head>
<body>
<%@ include file="/includes/header.jsp" %>
<main>
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Log Into Your Account Here</h4>
            <c:forEach var="error" items="${errors}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                        ${error}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:forEach>
            <form method="post" action="${baseUrl}/applicant-login">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Email Address*" type="email" name="email" value="${email}">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Password*" type="password" name="password">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Sign In </button>
                </div> <!-- form-group// -->
                <p class="text-center">Don't have an account? <a href="${baseUrl}/applicants/sign-up.jsp">Sign Up</a> here</p>
            </form>
        </article>
</main>
<%@include file="../includes/footer.jsp" %>
</body>
</html>
