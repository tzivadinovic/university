<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${pageContext.session.getAttribute('lang')}"/>
<fmt:setBundle basename="i18n/strings"/>

<!DOCTYPE html>
<html lang="<%=session.getAttribute("lang")%>">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
    <div class="row">
        <form class="col s12" method="post" action="${pageContext.request.contextPath}/login">
            <div class="row">
                <br/>
                <br/>
                <div class="col s12 m12 l3"></div>
                <div class="col s12 m12 l6">
                    <div class="input-field col s12 m12 l12">
                        <i class="material-icons prefix">account_circle</i>
                        <input id="username" name="username" type="text" class="validate">
                    </div>
                    <div class="input-field col s12 m12 l12">
                        <i class="material-icons prefix">lock</i>
                        <input id="password" name="password" type="password" class="validate">
                    </div>
                    <div class="row">
                        <div class="col s12">
                            <button class="btn waves-light light-blue lighten-1 right" type="submit" name="action">
                                Login<i class="material-icons right">send</i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <br><br>
</div>
<script>
    document.addEventListener("DOMContentLoaded", () => {
        M.updateTextFields()
    });
</script>
<jsp:include page="../footer.html"></jsp:include>
</body>
</html>
