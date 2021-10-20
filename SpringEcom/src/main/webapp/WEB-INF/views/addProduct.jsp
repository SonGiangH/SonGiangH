<%--
  Created by IntelliJ IDEA.
  User: Giang Son
  Date: 9/20/2021
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<p>Form User</p>

<c:url value="/add-product" var="url"/>

<form:form modelAttribute="product" method="post" action="${url}" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <p>Product Name</p><form:input path="productName"/>
    <p style="color: red;"><form:errors path="productName"></form:errors></p>

    <p>PRICE</p><form:input path="price"/>
    <p style="color: red;"><form:errors path="price"></form:errors></p>

    <p>QUANTITY</p><form:input path="quantity"/>
    <p style="color: red;"><form:errors path="quantity"></form:errors></p>

    <p>DESCRIPTION</p><form:input path="description"/>
    <p style="color: red;"><form:errors path="description"></form:errors></p>

    <form:input path="image" type ="file"/>

    <button type="submit">Submit</button>
</form:form>
</body>
</body>
</html>
