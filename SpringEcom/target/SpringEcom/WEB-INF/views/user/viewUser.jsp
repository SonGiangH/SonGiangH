<%--
  Created by IntelliJ IDEA.
  User: Giang Son
  Date: 9/20/2021
  Time: 12:55 AM
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
    <title>Insert title here</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" >

</head>
<body>
<h1>Thong tin nguoi dung</h1>

<p>ID:${user.id }</p>
<p>Name:${user.firstName }</p>
<p>Phone:${user.phone }</p>

<a href="<c:url value="/all-user"/>">All Users</a>
</body>
</html>
