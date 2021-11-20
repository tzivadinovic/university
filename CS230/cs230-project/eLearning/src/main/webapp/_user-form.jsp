<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.RoleDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Role" %>
<%
    RoleDAO roleDAO = new RoleDAO();
    List<Role> roles = roleDAO.findAll();
    request.setAttribute("roles", roles);
%>
<form action="${pageContext.request.contextPath}/add-user" method="post">
    <h6>Firstname:</h6>
    <input type="text" name="firstName"/>
    <h6>Lastname:</h6>
    <input type="text" name="lastName"/>
    <h6>Username:</h6>
    <input type="text" name="username"/>
    <h6>Password:</h6>
    <input type="password" name="password"/>
    <h6>Email:</h6>
    <input type="email" name="email" style="margin-bottom: 50px"/>
    <h6>Roles:</h6>
    <div class="input-field col s12">
        <select multiple name="roles">
            <option value="" disabled selected>Choose your option</option>
            <c:forEach items="${roles}" var="role">
                <option value="${role.id}">${role.role}</option>
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