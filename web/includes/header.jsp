<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="<c:out value="${baseUrl}"></c:out>">Easy Apply ::</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${baseUrl}/applicants/sign-up.jsp" title="Easy Apply For Individuals">Individuals</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="${baseUrl}/company.jsp" role="button" aria-haspopup="true" aria-expanded="false" title="Easy Apply for Companies">Companies</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Log In</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Sign Up</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${baseUrl}/view-vacancies" title="Look for an available Opening">Browse
                        Openings</a>
                </li>
                <c:if test="${sessionScope.user != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${baseUrl}/view-applications" title="Look for an available Opening">
                            Applications</a>
                    </li>
                </c:if>
            </ul>
            <div class="login">
                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <c:set var="user" value="${sessionScope.user}" />
                        <span class="text-white">Greetings, ${user.firstName} ${user.lastName}!</span> &nbsp;
                        <a href="${baseUrl}/applicant-logout">
                            <button class="btn btn-success" title="Sign In as an Individual or Company">Log Out</button>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="${baseUrl}/applicant-login">
                            <button class="btn btn-success" title="Sign In as an Individual or Company">Log In</button>
                        </a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>
</header>
