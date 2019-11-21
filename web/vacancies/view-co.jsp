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
    <h1>Listed Vacancies</h1>
    <c:if test="${size == 0}">
        <p>Looks like your company has no listed openings at the moment :-(</p>
        <p>Click <a href="${baseUrl}/add-vacancy">here</a> to post an opening</p>
    </c:if>
    <c:forEach var="vacancy" items="${vacancies}">
        <div class="card border-primary mb-3">
            <c:set var="company" value="${vacancy.company}"/>
            <div class="card-header">${company.name}</div>
            <div class="card-body text-secondary">
                <small class="text-muted">${company.location} :: ${company.industry} :: ${company.website} :: Posted on ${vacancy.datePosted}</small>
                <h3 class="card-title">${vacancy.title}</h3>
                <p class="card-text">${vacancy.description}</p>
                <a href="${baseUrl}/view-applications?vid=${vacancy.vacancyId}" class="btn btn-light">See Applications</a>
            </div>
        </div>
    </c:forEach>
</main>
<%@include file="../includes/footer.jsp" %>
</body>
</html>
