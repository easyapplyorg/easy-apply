<c:set var="path" value="${request.requestURI}"/>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="<c:out value="${baseUrl}"></c:out>">Easy Apply ::</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <c:choose>
                <c:when test="${path.contains('applicant')}">
                <li class="nav-item dropdown active">
                    </c:when>
                    <c:otherwise>
                <li class="nav-item dropdown">
                    </c:otherwise>
                    </c:choose>
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="${baseUrl}/applicants/sign-up.jsp"
                       role="button" aria-haspopup="true" aria-expanded="false" title="Easy Apply For Individuals">Individuals</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${baseUrl}/applicant-login">Log In</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${baseUrl}/applicants/sign-up.jsp">Sign Up</a>
                    </div>
                </li>
                <c:choose>
                <c:when test="${path.contains('company')}">
                <li class="nav-item dropdown active">
                    </c:when>
                    <c:otherwise>
                <li class="nav-item dropdown">
                    </c:otherwise>
                    </c:choose>
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="${baseUrl}/company.jsp"
                       role="button" aria-haspopup="true" aria-expanded="false" title="Easy Apply for Companies">Companies</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${baseUrl}/company-login">Log In</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${baseUrl}/company.jsp">Sign Up</a>
                    </div>
                </li>
                <c:choose>
                <c:when test="${path.contains('vacanc')}">
                <li class="nav-item active">
                    </c:when>
                    <c:otherwise>
                <li class="nav-item">
                    </c:otherwise>
                    </c:choose>
                    <a class="nav-link" href="${baseUrl}/view-vacancies" title="Look for an available Opening">Browse
                        Openings</a>
                </li>
                <c:if test="${sessionScope.user != null || sessionScope.company != null}">
                <c:choose>
                    <c:when test="${path.contains('application')}">
                        <li class="nav-item active">
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                    </c:otherwise>
                </c:choose>
                        <a class="nav-link" href="${baseUrl}/view-applications" title="Look for an available Opening">
                            Applications</a>
                    </li>
                </c:if>
            </ul>

            <c:if test="${path.contains('company')}">
                <div class="login">
                    <c:choose>
                        <c:when test="${sessionScope.company != null}">
                            <c:set var="company" value="${sessionScope.company}"/>
                            <span class="text-white">Greetings, ${company.name}!</span> &nbsp;
                            <a href="${baseUrl}/company-logout">
                                <button id="btn-login" type="submit" class="btn btn-success" title="Company logout">
                                    LogOut
                                </button>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="${baseUrl}/companylogin.jsp">
                                <button id="btn-login1" type="button" class="btn btn-success"
                                    title="Sign In as a Company">Log In
                                </button>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:if>

            <c:if test="${!path.contains('company')}">
                <div class="login">
                    <c:choose>
                        <c:when test="${sessionScope.user != null}">
                            <c:set var="user" value="${sessionScope.user}"/>
                            <span class="text-white">Greetings, ${user.firstName} ${user.lastName}!</span> &nbsp;
                            <a href="${baseUrl}/applicant-logout">
                                <button class="btn btn-success" title="Sign In as an Individual or Company">Log Out
                                </button>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="${baseUrl}/applicant-login">
                                <button class="btn btn-success" title="Sign In as an Individual">Log In</button>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:if>

        </div>
    </nav>
</header>
