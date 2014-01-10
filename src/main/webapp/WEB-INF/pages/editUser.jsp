<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC Application</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>

<body>
<div class="container">

    <c:if test="${empty user}">
        <h3>User not found: ${userId}</h3>
    </c:if>
    <c:if test="${not empty user}">
        <h1>Edit User</h1>
        <form:form method="post" action="/update" commandName="user" role="form">
            <form:hidden path="id" />
            <div class="form-group">
                <form:label path="firstName">First Name:</form:label>
                <form:input path="firstName" class="form-control" placeholder="First Name"/>
            </div>
            <div class="form-group">
                <form:label path="lastName">Last Name:</form:label>
                <form:input path="lastName" class="form-control" placeholder="Last Name"/>
            </div>
            <div class="form-group">
                <form:label path="email">Email:</form:label>
                <form:input path="email" class="form-control" placeholder="Email"/>
            </div>
            <button type="submit" class="btn btn-default">Save</button>
        </form:form>
    </c:if>

    <br><a href="/" class="btn btn-primary">Back</a>

</div>
</body>
</html>