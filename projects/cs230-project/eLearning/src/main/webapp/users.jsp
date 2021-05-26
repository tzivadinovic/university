<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users</title>
</head>
<body style="width: 100vw">

<%@page import="rs.ac.metropolitan.eLearning.database.dao.UserDAO,java.util.*" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.User" %>
<%@ include file="header.html" %>
<br>
<h3 style="text-align: center">Users Management</h3>

<%
    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.findAll();
    request.setAttribute("users", users);
%>
<div class="table-wrapper">
    <table style="width: 100%">
        <tr>
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.firstName}</td>
                <td>${u.lastName}</td>
                <td>${u.username}</td>
                <td>**************</td>
                <td>${u.email}</td>
                <td><a href="edit-user-form.jsp?id=${u.id}"><i class="material-icons edit-btn">create</i></a></td>
                <td><a href="delete-user.jsp?id=${u.id}"><i class="material-icons delete-btn">delete</i></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>
<a class="btn-floating btn-large waves-effect waves-light blue add-button" href="add-user-form.jsp">
    <i class="material-icons">add</i></a>
</body>
</html>