<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit User</title>
</head>
<body>
<%@page import="rs.ac.metropolitan.eLearning.database.dao.UserDAO,rs.ac.metropolitan.eLearning.entity.User" %>
<%@ include file="header.html" %>
<%
    UserDAO userDAO = new UserDAO();
    String id = request.getParameter("id");
    User u = userDAO.find(Integer.parseInt(id));
%>

<form action="edit-user.jsp" method="post">
    <input type="hidden" name="id" value="<%=u.getId() %>"/>
    <h6>Firstname:</h6>
    <input type="text" name="firstName" value="<%= u.getFirstName()%>"/>
    <h6>Lastname:</h6>
    <input type="text" name="lastName" value="<%= u.getLastName()%>"/>
    <h6>Username:</h6>
    <input type="text" name="username" value="<%= u.getUsername()%>"/>
    <h6>Email:</h6>
    <input type="email" name="email" value="<%= u.getEmail()%>"/>

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

    input[type=password] {
        color: white;
    }

    input[type=email] {
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