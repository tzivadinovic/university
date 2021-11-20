<%@ page import="rs.ac.metropolitan.eLearning.database.dao.TestDAO" %>
<jsp:useBean id="t" class="rs.ac.metropolitan.eLearning.entity.Test"></jsp:useBean>
<jsp:setProperty property="*" name="t"/>

<%
    TestDAO testDAO = new TestDAO();
    testDAO.remove(t);
    response.sendRedirect("tests.jsp");
%>