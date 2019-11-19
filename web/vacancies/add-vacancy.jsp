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
    <title>Easy Apply :: WAP 2019</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" rel="stylesheet"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<main>
    <h1>Add Vacancy</h1>
    <c:forEach var="error" items="${requestScope.errors}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${error}
        </div>
    </c:forEach>
    <form method="post" action="${baseUrl}/add-vacancy">
        <div class="form-group">
            <label for="jobTitle">Job Title</label>
            <input type="text" class="form-control" id="jobTitle" name="jobTitle" placeholder="Title goes here..."
                   value="${request.getParameter("jobTitle")}">
        </div>
        <div class="form-group">
            <label for="jobDescription">Job Description</label>
            <textarea class="form-control" id="jobDescription" name="jobDescription" placeholder="Day to day tasks...">${request.getParameter("message")}</textarea>
        </div>
        <button type="submit" class="btn btn-secondary">Post Job</button>
    </form>
</main>
<%@include file="../includes/footer.jsp" %>
</body>
</html>
