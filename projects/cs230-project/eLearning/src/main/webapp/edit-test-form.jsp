<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit User</title>
</head>
<body>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.TestDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Test" %>
<%@ include file="header.html" %>
<%
    TestDAO testDAO = new TestDAO();
    String id = request.getParameter("id");
    Test t = testDAO.find(Integer.parseInt(id));
%>

<form action="edit-test.jsp" method="post">
    <input type="hidden" name="id" value="<%=t.getId() %>"/>
    <h6>Title:</h6>
    <input type="text" name="title" value="<%= t.getTitle()%>"/>
    <h6>Date & Time:</h6>
    <input type="text" name="dateTime" value="<%= t.getDateTime()%>"/>
    <h6>Max points:</h6>
    <input type="number" name="maxPoints" value="<%= t.getMaxPoints()%>"/>

    <button class="btn waves-effect waves-light blue" type="submit" name="action">Submit
        <i class="material-icons right">send</i>
    </button>
</form>

</body>
<style>
    input[type=text] {
        width: 100px;
        color: white;
    }

    input[type=number] {
        color: white;
    }

    form {
        width: 20%;
        text-align: center;
        margin-left: 40%;
        margin-top: 8%;
    }

    body {
        background-image: linear-gradient(to right, #2a4078, #4062b7);
    }

    h6 {
        color: white;
    }
</style>
</html>