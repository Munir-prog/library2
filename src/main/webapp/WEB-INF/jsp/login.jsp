<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 12/07/2021
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="emailId">Email:
            <input type="text" name="email" id="emailId" required>
        </label><br>
        <label for="passwordId">Password:
            <input type="password" name="password" id="passwordId" required>
        </label><br>
        <button type="submit">Login</button>
        <a href="${pageContext.request.contextPath}/registration">
            <button type="button">Register</button>
        </a>
    </form>
</body>
</html>
