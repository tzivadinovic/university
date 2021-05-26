<%@ page import="java.util.List" %>
<%@ page import="rs.ac.metropolitan.eLearning.database.dao.QuestionDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.Question" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    QuestionDAO questionDAO = new QuestionDAO();
    List<Question> questions = questionDAO.findAll();
    request.setAttribute("questions", questions);
%>
<form action="add-test.jsp" method="post">
    <h6>Title:</h6>
    <input type="text" name="title"/>
    <h6>Date & Time:</h6>
    <input type="datetime-local" name="dateTime"/>
    <h6>Max points:</h6>
    <input type="number" name="maxPoints"/>
    <h6>Question:</h6>
    <div class="input-field col s12">
        <select multiple>
            <option value="" disabled selected>Choose your option</option>
            <c:forEach items="${questions}" var="question">
                <option value="${question.id}">${question.text}</option>
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