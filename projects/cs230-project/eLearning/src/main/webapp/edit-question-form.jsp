<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Question</title>
</head>
<body>
<%@page import="rs.ac.metropolitan.eLearning.database.dao.QuestionDAO,rs.ac.metropolitan.eLearning.entity.Question" %>
<%@ include file="header.jsp" %>
<%
    QuestionDAO questionDAO = new QuestionDAO();
    String questionId = request.getParameter("id");
    Question q = questionDAO.find(Integer.parseInt(questionId));
%>

<form action="edit-question.jsp" method="post">
    <input type="hidden" name="id" value="<%=q.getId() %>"/>
    <h6>Question Text:</h6>
    <input type="text" name="text" value="<%= q.getText()%>"/>
    <h6>Answer</h6>
    <input type="text" name="answer" value="<%= q.getAnswer()%>"/>
    <h6>Points:</h6>
    <input type="number" name="points" value="<%= q.getPoints()%>"/>

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