<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/19/19
  Time: 2:43 PM
  To change this template use File :: Settings :: File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../includes/head-content.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<main>
    <h1>Submitted Applications</h1>
    <c:if test="${size == 0}">
        <p>Looks like no one has applied for this opening yet! :-(</p>
    </c:if>
    <c:forEach var="app" items="${applications}">
        <div class="card border-primary mb-3">
            <c:set var="user" value="${app.user}"/>
            <c:set var="vacancy" value="${app.vacancy}"/>
            <div class="card-header">${vacancy.title}</div>
            <div class="card-body text-secondary">
                <small class="text-muted">Posted on ${vacancy.datePosted}</small>
                <h3 class="card-title">Applicant Summary</h3>
                <p class="card-text">Name: ${user.firstName} ${user.lastName}</p>
                <p class="card-text">Address: ${user.address}</p>
                <p class="card-text">Cell Phone: ${user.phoneNumber}</p>
                <p class="card-text">Email: ${user.email}</p>
                <p class="card-text">Date of application: ${app.applicationDate}</p>
                <a href="#" class="btn btn-light">View Resume</a>
            </div>
        </div>
    </c:forEach>
</main>
<%@include file="../includes/footer.jsp" %>
</body>
</html>
