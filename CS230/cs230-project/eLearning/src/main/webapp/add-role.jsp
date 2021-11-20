<%@ page import="rs.ac.metropolitan.eLearning.database.dao.RoleDAO" %>
<jsp:useBean id="r" class="rs.ac.metropolitan.eLearning.entity.Role"></jsp:useBean>
<jsp:setProperty property="*" name="r"/>

<%
    RoleDAO roleDAO = new RoleDAO();
    roleDAO.create(r);
    response.sendRedirect("roles.jsp");
%>