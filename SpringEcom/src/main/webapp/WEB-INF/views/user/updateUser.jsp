<%--
  Created by IntelliJ IDEA.
  User: Giang Son
  Date: 9/23/2021
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<p>Form Update User</p>

<c:url value="/update-user" var="url"/>

<form:form modelAttribute="userUpdate" method="post" action="${url}">

    <p>ID</p><form:input path="id"/>
    <p style="color: red;"><form:errors path="id"></form:errors></p>

    <p>Name</p><form:input path="firstName"/>
    <p style="color: red;"><form:errors path="firstName"></form:errors></p>

    <p>Phone</p><form:input path="phone"/>
    <p style="color: red;"><form:errors path="phone"></form:errors></p>

    <button type="submit">Submit</button>
</form:form>

</body>
</body>
</html>
