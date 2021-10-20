<%--
  Created by IntelliJ IDEA.
  User: Giang Son
  Date: 9/20/2021
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<p>Form User</p>

<c:url value="/add-user" var="url"/>

<form:form modelAttribute="user" method="post" action="${url}">

    <form:hidden path="id"/>

    <p>Name</p><form:input path="firstName"/>
    <p style="color: red;"><form:errors path="firstName"></form:errors></p>

    <p>Phone</p><form:input path="phone"/>
    <p style="color: red;"><form:errors path="phone"></form:errors></p>

    <button type="submit">Submit</button>
</form:form>
</body>
</body>
</html>
