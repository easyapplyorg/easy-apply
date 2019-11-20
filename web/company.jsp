<%--
  Created by IntelliJ IDEA.
  User: LuckyGilbert
  Date: 19-Nov-19
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>company</title>
</head>
<body>
<%@ include file="/includes/header.jsp" %>
<main>
    <div class="container">
        <form>
            <div class="form-group">
                <label class="form-control">Company Name:</label>
                <input class="form-control" type="text" placeholder="eg. elites company" name="name"><br>
                <label class="form-control">Location:</label>
                <input class="form-control" type="text" name="location"><br>
                <label class="form-control">Industry</label>
                <input class="form-control" type="text" name="industry"><br>
                <label class="form-control">Company Website: </label>
                <input class="form-control" name="website" type="text" placeholder="eg. abc.com">
            </div>
        </form>
    </div>
</main>
<%@include file="/includes/footer.jsp"%>
</body>
</html>
