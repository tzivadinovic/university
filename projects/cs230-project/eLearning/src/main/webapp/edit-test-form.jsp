<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Test</title>
</head>
<body>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.TestDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Test" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.QuestionDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Question" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.UserDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.User" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>
<%
    TestDAO testDAO = new TestDAO();
    String testId = request.getParameter("id");
    Test t = testDAO.find(Integer.parseInt(testId));

    QuestionDAO questionDAO = new QuestionDAO();
    List<Question> questions = questionDAO.findAll();
    request.setAttribute("questions", questions);

    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.findAll();
    request.setAttribute("users", users);
    request.setAttribute("test", t);
%>

<form action="${pageContext.request.contextPath}/edit-test" method="post">
    <input type="hidden" name="id" value="<%=t.getId() %>"/>
    <h6>Title:</h6>
    <input type="text" name="title" value="<%= t.getTitle()%>"/>
    <h6>Date & Time:</h6>
    <input type="text" name="dateTime" value="<%= t.getDateTime()%>"/>
    <h6>Max points:</h6>
    <input type="number" name="maxPoints" value="<%= t.getMaxPoints()%>"/>
    <h6>Questions:</h6>
    <div class="input-field col s12">
        <select multiple name="questions">
            <option value="" disabled>Choose your option</option>
            <c:forEach items="${questions}" var="question">
                <option ${test.questions.contains(question) ? 'selected' : ''} value="${question.id}">${question.text}</option>
            </c:forEach>
        </select>
    </div>

    <h6>Users:</h6>
    <div class="input-field col s12">
        <select multiple name="users">
            <option value="" disabled>Choose your option</option>
            <c:forEach items="${users}" var="user">
                <option ${test.users.contains(user) ? 'selected' : ''}
                        value="${user.id}">${user.firstName} ${user.firstName}</option>
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