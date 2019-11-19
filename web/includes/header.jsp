<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./contact-form">Contact Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./browse-messages">Browse Messages</a>
                </li>
            </ul>
                <button type="button" class="btn btn-light">Individual</button>
                <button type="button" class="btn btn-secondary">Company</button>
                <button type="button" class="btn btn-success">Log In</button>
        </div>
    </nav>
</header>
