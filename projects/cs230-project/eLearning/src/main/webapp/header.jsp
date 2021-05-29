<%@ page import="rs.ac.metropolitan.eLearning.database.dao.UserDAO" %>
<%@ page import="rs.ac.metropolitan.eLearning.entity.User" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>eLearning System</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Assistant:wght@500display=swap');

        html {
            font-family: 'Assistant', sans-serif;

        }

        #navigation ul li {
            display: inline-block;
            padding: 0 5px;
        }

        #navigation ul li a {
            color: #fff;
            text-decoration: none;
        }

        #navigation {
            font-size: 20px;
            background: #4062b7;
            padding: 10px;
            text-align: center;
        }

        #navigation li:hover {
            color: #2a4078;
        }

        .add-button {
            text-align: right;
            float: right;
            margin-right: 110px;
        }

        .add-button:hover {
            background-color: #2a4078;
            color: #2a4078;
        }

        .table-wrapper {
            margin-left: 100px;
            margin-right: 100px;
            display: flex !important;
            justify-content: center !important;
        }

        table {
            margin-left: 10px;
            margin-right: 10px;
            text-align: center !important;
        }

        th {
            text-align: center !important;
        }

        td {
            text-align: center !important;
        }

        .edit-btn {
            font-size: 35px;
        }

        .delete-btn {
            font-size: 35px;
        }

        .edit-btn:hover {
            transition: .5s;
            color: #2a4078;
        }

        .delete-btn:hover {
            transition: .5s;
            color: #2a4078;
        }

    </style>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    Integer id = (Integer) session.getAttribute("id");
    boolean loggedIn = username != null && id != null;
    User user = new UserDAO().findByUsername(username);
%>
<div id="header">
    <div class="shell">
        <div id="navigation">
            <ul>
                <% if (!loggedIn) {%>
                <li><a href="admin/login.jsp" class="active">Login</a></li>
                <%}%>
                <%if (loggedIn) {%>
                <li><a href="index.jsp" class="active">Home</a></li>
                <li><a href="tests.jsp" class="active">Tests</a></li>
                <li><a href="questions.jsp" class="active">Questions</a></li>
                <li><a href="users.jsp" class="active">Users</a></li>
                <li><a href="roles.jsp" class="active">Roles</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/logout" class="active">Logout</a></li>
                <%}%>
            </ul>
            <%if (loggedIn) {%>
            <div style="color: #a8eb12;">
                <span style="color: white;">Hi, </span><span style="color: #a8eb12;"><%=user.getFirstName()%></span>
            </div>
            <%}%>
        </div>
    </div>
</div>

</body>
</html>