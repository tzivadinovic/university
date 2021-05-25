<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
</head>
<body>

<%@page import="rs.ac.metropolitan.eLearning.database.dao.UserDAO,java.util.*" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.User" %>

<h1>Users List</h1>

<%
    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.findAll();
    request.setAttribute("users", users);
%>

<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td>${u.email}</td>
                <%--            <td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>--%>
                <%--            <td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>--%>
        </tr>
    </c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>