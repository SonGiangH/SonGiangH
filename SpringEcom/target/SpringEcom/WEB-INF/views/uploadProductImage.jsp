<%--
  Created by IntelliJ IDEA.
  User: Giang Son
  Date: 9/26/2021
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Upload Image of Product</title>
</head>
<body>
<p>Form Upload Image of Product</p>

<c:url value="/upload-product-image" var="url"/>

<form:form  method="post" action="${url}" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">Submit</button>

</form:form>
</body>
</body>
</html>
