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
    <h1>Available Openings</h1>
    <c:if test="${size == 0}">
        <c:if test="${terms != null}">
            <p>Sadly, no openings were found for ${terms} :-(</p>
        </c:if>
        <c:if test="${terms == null}">
            <p>Sadly, there are no listed openings at the moment :-(</p>
        </c:if>
    </c:if>
    <c:if test="${size > 0}">
        <form method="post" action="${baseUrl}/view-vacancies">
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Search by Job Title, Company, Industry or Location"
                       aria-describedby="btnSearch" id="btSearch" name="btSearch">
                <div class="input-group-append">
                    <button class="btn btn-outline-primary" type="submit">Search for
                        Opening
                    </button>
                </div>
            </div>
        </form>
        <p>Feel free to refine what you're seeing using the form above</p>
        <c:forEach var="vacancy" items="${vacancies}">
            <c:set var="company" value="${vacancy.company}"/>
            <div class="card border-primary mb-3">
                <div class="card-header">${vacancy.title} - ${company.name}</div>
                <div class="card-body text-secondary">
                    <h6 class="card-subtitle mb-2 text-muted">${company.location} :: ${company.industry}
                        :: ${company.website} :: Posted on ${vacancy.datePosted}</h6>
                    <h3 class="card-title">${vacancy.title} - ${company.name}</h3>
                    <p class="card-text">${vacancy.description}</p>
                    <a href="${baseUrl}/view-detail?vacancy_id=${vacancy.vacancyId}" class="btn btn-outline-primary">See
                        Details</a>
                </div>
            </div>
            <%--<div class="card border-primary mb-3">
                <div class="card-body">
                    <h4 class="card-title">${vacancy.title} - ${company.name}</h4>
                    <h6 class="card-subtitle mb-2 text-muted">${company.location}
                        :: ${company.industry} :: ${company.website} :: Posted on ${vacancy.datePosted}</h6>
                    <p class="card-text">${vacancy.description}</p>
                    <a href="${baseUrl}/view-detail?id=${vacancy.vacancyId}" class="btn btn-outline-primary">See Details</a>
                </div>
            </div>--%>
        </c:forEach>
    </c:if>
</main>
<%@include file="../includes/footer.jsp" %>
</body>
</html>
