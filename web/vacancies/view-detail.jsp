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
    <c:set var="company" value="${vacancy.company}"/>
    <h1>${vacancy.title}</h1>
    <div id="successMessage"></div>
    <div class="card border-primary mb-3 detail">
        <div class="card-header">${company.name}</div>
        <div class="card-body text-secondary">
            <small class="text-muted">${company.location} :: ${company.industry} :: ${company.website} :: Posted
                on ${vacancy.datePosted}</small>
            <h3 class="card-title">Job Description</h3>
            <p class="card-text">${vacancy.description}</p>
            <a id="submitApplication" href="${baseUrl}/apply?vid=${vacancy.vacancyId}" class="btn btn-light">Apply</a>
        </div>
    </div>
</main>
<%@include file="../includes/footer.jsp" %>
</body>
</html>