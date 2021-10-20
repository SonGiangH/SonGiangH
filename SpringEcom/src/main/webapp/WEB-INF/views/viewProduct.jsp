<%--
  Created by IntelliJ IDEA.
  User: Giang Son
  Date: 9/20/2021
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product information</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" >

</head>
<body>
<h1>Product Information</h1>
<p>ID:${product.id }</p>
<p>Product Name:${product.productName }</p>
<p>Price:${product.price }</p>
<p>Quantity:${product.quantity }</p>
<p>Description:${product.description }</p>
<p>Image:${product.image.getOriginalFilename() }</p>
</body>
</html>
