<%--
  Created by IntelliJ IDEA.
  User: Giang Son
  Date: 10/4/2021
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
    <title>List Users</title>
</head>
<body>
<h2>List of All Users</h2>
<hr/>
<a href="<c:url value="/add-user"/> ">Add User</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
<c:forEach items="${users}" var="u">
    <tr>
        <td>${u.id }</td>
        <td>${u.firstName}</td>
        <td>${u.phone}</td>
        <td><a href="<c:url value="/user-detail/${u.id}"/> ">Detail</a></td>
        <td><a href="<c:url value="/delete-user/${u.id}"/> ">Delete</a></td>
        <td><a href="<c:url value="/update-user/${u.id}"/> ">Edit</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
