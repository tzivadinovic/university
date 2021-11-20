<%@page import="rs.ac.metropolitan.eLearning.database.dao.UserDAO" %>
<jsp:useBean id="u" class="rs.ac.metropolitan.eLearning.entity.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
    UserDAO userDAO = new UserDAO();
    userDAO.create(u);
    response.sendRedirect("");
%>