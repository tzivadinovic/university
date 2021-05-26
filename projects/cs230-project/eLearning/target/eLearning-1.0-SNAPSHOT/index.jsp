<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>eLearning System</title>
</head>
<body>
<%@ include file="header.html" %>
<br>

<div class="row">
    <div class="col s12 m6 l3">
        <div class="card">
            <div class="card-image">
                <img src="assets/sample-1.jpg" alt="">
                <span class="card-title">Tests</span>
                <a class="btn-floating halfway-fab waves-effect waves-light light-blue" href="tests.jsp"><i
                        class="material-icons">arrow_forward</i></a>
            </div>
            <div class="card-content">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias asperiores at dolore excepturi hic
                    non nostrum sequi soluta temporibus voluptatum?</p>
            </div>
        </div>
    </div>

    <div class="col s12 m6 l3">
        <div class="card">
            <div class="card-image">
                <img src="assets/sample-1.jpg" alt="">
                <span class="card-title">Questions</span>
                <a class="btn-floating halfway-fab waves-effect waves-light light-blue" href="questions.jsp"><i
                        class="material-icons">arrow_forward</i></a>
            </div>
            <div class="card-content">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias asperiores at dolore excepturi hic
                    non nostrum sequi soluta temporibus voluptatum?</p>
            </div>
        </div>
    </div>

    <div class="col s12 m6 l3">
        <div class="card">
            <div class="card-image">
                <img src="assets/sample-1.jpg" alt="">
                <span class="card-title">Users</span>
                <a class="btn-floating halfway-fab waves-effect waves-light light-blue" href="users.jsp"><i
                        class="material-icons">arrow_forward</i></a>
            </div>
            <div class="card-content">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias asperiores at dolore excepturi hic
                    non nostrum sequi soluta temporibus voluptatum?</p>
            </div>
        </div>
    </div>

    <div class="col s12 m6 l3">
        <div class="card">
            <div class="card-image">
                <img src="assets/sample-1.jpg" alt="">
                <span class="card-title">Roles</span>
                <a class="btn-floating halfway-fab waves-effect waves-light light-blue" href="roles.jsp"><i
                        class="material-icons">arrow_forward</i></a>
            </div>
            <div class="card-content">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias asperiores at dolore excepturi hic
                    non nostrum sequi soluta temporibus voluptatum?</p>
            </div>
        </div>
    </div>
</div>
    <jsp:include page="footer.html"></jsp:include>
</body>

<style>
    body {
        background-image: url("assets/Home-Page-Background-Picture.jpg");
        min-height: 100vh;
        margin: 0;
        padding: 0;
    }

    html{
        min-height: 100vh;
        margin: 0;
        padding: 0;
        height: 100%;
    }

    /*img{*/
    /*    max-width: 350px;*/
    /*    max-height: 500px;*/
    /*}*/


</style>
</html>