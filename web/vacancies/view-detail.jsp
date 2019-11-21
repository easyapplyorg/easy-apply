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
    <c:if test="${success != null}">
        <div id="successMessage" class="alert alert-success alert-dismissible" role="alert">You have successfully
            applied for this opening. Click <a
                    href="${baseUrl}/view-vacancies">here</a> to browse more openings!
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <div id="successMessage"></div>
    <div class="card border-primary mb-3 detail">
        <div class="card-header">${company.name}</div>
        <div class="card-body text-secondary">
            <small class="text-muted">${company.location} :: ${company.industry} :: ${company.website} :: Posted
                on ${vacancy.datePosted}</small>
            <h3 class="card-title">Job Description</h3>
            <p class="card-text">${vacancy.description}</p>
            <a id="submitApplication" href="${baseUrl}/apply?vacancy_id=${vacancy.vacancyId}">
                <form method="post" action="${baseUrl}/apply">
                    <input type="hidden" name="vacancy_id" value="${vacancy.vacancyId}">
                    <button type="submit" class="btn btn-outline-primary">Apply for Opening</button>
                </form>
            </a>
        </div>
    </div>
</main>
<%@include file="../includes/footer.jsp" %>
</body>
</html>
