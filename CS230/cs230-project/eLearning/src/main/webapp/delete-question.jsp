<%@page import="rs.ac.metropolitan.eLearning.database.dao.QuestionDAO" %>
<jsp:useBean id="q" class="rs.ac.metropolitan.eLearning.entity.Question"></jsp:useBean>
<jsp:setProperty property="*" name="q"/>

<%
    QuestionDAO questionDAO = new QuestionDAO();
    questionDAO.remove(q);
    response.sendRedirect("questions.jsp");
%>