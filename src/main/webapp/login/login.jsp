<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h3 style="color: red">
    <c:if test="${param.loginFailed != null}"> Login failed , please try again</c:if>
</h3>
<form action="${pageContext.request.contextPath}/login.do" method="post">
    <input type="hidden" name="action" value="login">
    <input type="text" name="username" placeholder="username"> <br>
    <input type="password" name="password" placeholder="password"> <br>
    <input type="submit" value="Login">
</form>
</body>
</html>
