<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/19/19
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="./includes/head-content.jsp" %>
</head>
<body>
<%@ include file="includes/header.jsp" %>
<main>
    <div class="jumbotron">
        <h1 class="display-3">Easy Apply</h1>
        <h3>Your future begins here. No kidding.</h3>
        <p class="lead">A friend recommended us? Your mum's sick of you taking up her couch space? Or heck, your dog
            needs to eat...</p>
        <hr class="my-4">
        <p>Look no further. We've been bridging the gap between companies and talent for the past 20 years.</p>
        <p class="lead">
            <a class="btn btn-outline-primary btn-lg" href="${baseUrl}/view-vacancies" role="button"
               title="Let's find you a gig">Browse Openings</a>
        </p>
    </div>
</main>
<%@include file="includes/footer.jsp" %>
</body>
</html>
