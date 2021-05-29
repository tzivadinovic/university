<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Questions</title>
</head>
<body style="width: 100vw">

<%@page import="java.util.*" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.QuestionDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Question" %>
<%@ include file="header.jsp" %>
<br>
<h3 style="text-align: center">Questions Management</h3>

<%
    QuestionDAO questionDAO = new QuestionDAO();
    List<Question> questions = questionDAO.findAll();
    request.setAttribute("questions", questions);
%>
<div class="table-wrapper">
    <table style="width: 100%">
        <tr>
            <th>ID</th>
            <th>Text</th>
            <th>Points</th>
            <th>Correct Answers</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${questions}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.text}</td>
                <td>${u.points}</td>
                <td>
                    <c:forEach items="${u.answers}" var="answer">
                        <c:if test="${answer.correct}"><div class="chip green accent-2">${answer.text}</div></c:if>
                    </c:forEach>
                </td>
                <td><a href="edit-question-form.jsp?id=${u.id}"><i class="material-icons edit-btn">create</i></a></td>
                <td><a href="delete-question.jsp?id=${u.id}"><i class="material-icons delete-btn">delete</i></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>
<a class="btn-floating btn-large waves-effect waves-light blue add-button" href="add-question-form.jsp">
    <i class="material-icons">add</i></a>
</body>

</html>