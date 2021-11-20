<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Tests</title>
</head>
<body style="width: 100vw">

<%@page import="java.util.*" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.TestDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Test" %>
<%@ include file="header.jsp" %>
<br>
<h3 style="text-align: center">Tests Management</h3>

<%
    TestDAO testDAO = new TestDAO();
    List<Test> tests = testDAO.findAll();
    request.setAttribute("tests", tests);
%>
<div class="table-wrapper">
    <table style="width: 100%">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Date & Time</th>
            <th>Max points</th>
            <th>Questions</th>
            <th>Users</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${tests}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.title}</td>
                <td>${u.dateTime}</td>
                <td>${u.maxPoints}</td>
                <td>${u.questions}</td>
                <td>${u.users}</td>
                <td><a href="edit-test-form.jsp?id=${u.id}"><i class="material-icons edit-btn">create</i></a></td>
                <td><a href="delete-test.jsp?id=${u.id}"><i class="material-icons delete-btn">delete</i></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>
<a class="btn-floating btn-large waves-effect waves-light blue add-button" href="add-test-form.jsp">
    <i class="material-icons">add</i></a>
</body>

</html>