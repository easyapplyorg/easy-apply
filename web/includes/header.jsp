<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <c:set var="request" value="${pageContext.request}" />
    <c:set var="baseUrl" value="${request.scheme}://${request.serverName}:${request.serverPort}${request.contextPath}" />
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="<c:out value="${baseUrl}"></c:out>">Easy Apply ::</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#" title="Easy Apply For Individuals">Individuals</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./company.jsp" title="Easy Apply for Companies">Companies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${baseUrl}/view-vacancies" title="Look for an available Opening">Browse Openings</a>
                </li>
            </ul>
            <c:choose>
                <c:when test="${company!=null}">
                    <div class="login">
                        <form action="${baseUrl}/company-logout" method="get">
                            <button id="btn-login" type="submit" class="btn btn-success" title="Company logout">LogOut</button>
                        </form>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="login">
                        <button id="btn-login1" type="button" class="btn btn-success" title="Sign In as an Individual or Company">Log In</button>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
</header>
