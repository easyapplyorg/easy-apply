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
                <li class="nav-item">
                    <a class="nav-link" href="${baseUrl}/company.jsp" title="Easy Apply for Companies">Companies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${baseUrl}/view-vacancies" title="Look for an available Opening">Browse
                        Openings</a>
                </li>
            </ul>
            <div class="login">
                <button class="btn btn-success" title="Sign In as an Individual or Company"><a
                        href="${baseUrl}/applicant-login">Log In</a></button>
            </div>
        </div>
    </nav>
</header>
