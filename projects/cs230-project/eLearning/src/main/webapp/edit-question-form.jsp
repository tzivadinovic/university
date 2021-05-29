<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    request.setAttribute("question",  q);
%>

<form action="${pageContext.request.contextPath}/edit-question" method="post">
    <input type="number" hidden name="id" value="${question.id}"/>
    <h6>Question Text:</h6>
    <input type="text" name="text" value="${question.text}"/>
    <h6>Points:</h6>
    <input type="number" name="points" min="1" value="${question.points}"/>
    <h6>Answers:</h6>
    <c:forEach items="${question.answers}" var="answ" varStatus="i">
        <div>
            <input hidden type="text" name="answer${i.index+1}id" value="${answ.id}">
            <textarea class="materialize-textarea" type="text" name="answer${i.index+1}text">${answ.text}</textarea>
            <p>
                <label>
                    <input type="checkbox" class="filled-in" ${answ.correct ? 'checked' : ''} name="answer${i.index+1}correct"/>
                    <span>Correct</span>
                </label>
            </p>
        </div>
    </c:forEach>
<%--    <div>--%>
<%--        <textarea class="materialize-textarea" type="text" name="answer1text"></textarea>--%>
<%--        <p>--%>
<%--            <label>--%>
<%--                <input type="checkbox" class="filled-in" checked="checked" name="answer1correct"/>--%>
<%--                <span>Correct</span>--%>
<%--            </label>--%>
<%--        </p>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <textarea class="materialize-textarea" type="text" name="answer2text"></textarea>--%>
<%--        <p>--%>
<%--            <label>--%>
<%--                <input type="checkbox" class="filled-in" checked="checked" name="answer2correct"/>--%>
<%--                <span>Correct</span>--%>
<%--            </label>--%>
<%--        </p>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <textarea class="materialize-textarea" type="text" name="answer3text"></textarea>--%>
<%--        <p>--%>
<%--            <label>--%>
<%--                <input type="checkbox" class="filled-in" checked="checked" name="answer3correct"/>--%>
<%--                <span>Correct</span>--%>
<%--            </label>--%>
<%--        </p>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <textarea class="materialize-textarea" type="text" name="answer4text"></textarea>--%>
<%--        <p>--%>
<%--            <label>--%>
<%--                <input type="checkbox" class="filled-in" checked="checked" name="answer4correct"/>--%>
<%--                <span>Correct</span>--%>
<%--            </label>--%>
<%--        </p>--%>
<%--    </div>--%>

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