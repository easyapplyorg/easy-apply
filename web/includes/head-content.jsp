<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="request" value="${pageContext.request}" />
<c:set var="baseUrl" value="${request.scheme}://${request.serverName}:${request.serverPort}${request.contextPath}" />
<title>Easy Apply :: WAP 2019</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lumen/bootstrap.min.css" rel="stylesheet"
      crossorigin="anonymous">
<link rel="stylesheet" href="${baseUrl}/css/style.css">
