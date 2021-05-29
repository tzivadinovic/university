<%@ page import="java.util.List" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.QuestionDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Question" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.UserDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    QuestionDAO questionDAO = new QuestionDAO();
    List<Question> questions = questionDAO.findAll();
    request.setAttribute("questions", questions);

    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.findAll();
    request.setAttribute("users", users);
%>
<form action="${pageContext.request.contextPath}/add-test" method="post">
    <h6>Title:</h6>
    <input type="text" name="title"/>
    <h6>Date & Time:</h6>
    <input type="datetime-local" name="dateTime"/>
    <h6>Max points:</h6>
    <input type="number" name="maxPoints"/>
    <h6>Questions:</h6>
    <div class="input-field col s12">
        <select multiple name="questions">
            <option value="" disabled>Choose your option</option>
            <c:forEach items="${questions}" var="question">
                <option value="${question.id}">${question.text}</option>
            </c:forEach>
        </select>
    </div>

    <h6>Users:</h6>
    <div class="input-field col s12">
        <select multiple name="users">
            <option value="" disabled>Choose your option</option>
            <c:forEach items="${users}" var="user">
                <option value="${user.id}">${user.firstName} ${user.firstName}</option>
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

    input[type=datetime-local]{
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