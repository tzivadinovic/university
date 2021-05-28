<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit User</title>
</head>
<body>
<%@page import="rs.ac.metropolitan.eLearning.database.dao.UserDAO,rs.ac.metropolitan.eLearning.entity.User" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.RoleDAO" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>
<%
    UserDAO userDAO = new UserDAO();
    String userId = request.getParameter("id");
    User u = userDAO.find(Integer.parseInt(userId));

    RoleDAO roleDAO = new RoleDAO();
    List<Role> roleList = roleDAO.findAll();
    request.setAttribute("roles", roleList);
    request.setAttribute("user", u);
%>

<form action="${pageContext.request.contextPath}/edit-user" method="post">
    <input type="hidden" name="id" value="<%=u.getId() %>"/>
    <h6>Firstname:</h6>
    <input type="text" name="firstName" value="<%= u.getFirstName()%>"/>
    <h6>Lastname:</h6>
    <input type="text" name="lastName" value="<%= u.getLastName()%>"/>
    <h6>Username:</h6>
    <input type="text" name="username" value="<%= u.getUsername()%>"/>
    <h6>Email:</h6>
    <input type="email" name="email" value="<%= u.getEmail()%>"/>
    <h6>Roles:</h6>
    <div class="input-field col s12">
        <select  multiple name="roles">
            <option value="" disabled>Choose your option</option>
            <c:forEach items="${roles}" var="role">
                <option ${user.roles.contains(role) ? 'selected' : ''} value="${role.id}">${role.role}</option>
            </c:forEach>
        </select>
    </div>

    <button class="btn waves-effect waves-light blue" type="submit" name="action">Submit
        <i class="material-icons right">send</i>
    </button>
</form>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const elems = document.querySelectorAll('select');
        const instances = M.FormSelect.init(elems, {});
    });
</script>

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