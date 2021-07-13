<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 12/07/2021
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="emailId">Email:
        <input type="text" name="email" value="${param.email}" id="emailId" required>
    </label><br>
    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId" required>
    </label><br>
    <button type="submit">Login</button>
    <a href="${pageContext.request.contextPath}/registration">
        <button type="button">Register</button>
    </a>
    <c:if test="${param.error != null}">
        <div style="color: red">
            <span>Email or password is not correct</span>
        </div>
    </c:if>
</form>
<%@include file="footer.jsp"%>

</body>
</html>
