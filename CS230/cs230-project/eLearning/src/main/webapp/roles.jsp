<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Roles</title>
</head>
<body style="width: 100vw">

<%@page import="java.util.*" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.RoleDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Role" %>
<%@ include file="header.jsp" %>
<br>
<h3 style="text-align: center">Roles Management</h3>

<%
    RoleDAO roleDAO = new RoleDAO();
    List<Role> rolesList = roleDAO.findAll();
    request.setAttribute("roles", rolesList);
%>
<div class="table-wrapper">
    <table style="width: 100%">
        <tr>
            <th>ID</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${roles}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.role}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>
<a class="btn-floating btn-large waves-effect waves-light blue add-button" href="add-role-form.jsp">
    <i class="material-icons">add</i></a>
</body>

</html>