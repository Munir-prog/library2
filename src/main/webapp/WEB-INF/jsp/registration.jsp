<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 10/07/2021
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Registration</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
    <label for="nameId">Name:
        <input type="text" name="name" id="nameId">
    </label><br>

    <label for="birthdayId">Birthday:
        <input type="date" name="birthday" id="birthdayId">
    </label><br>

    <label for="emailId">Email:
        <input type="email" name="email" id="emailId">
    </label><br>

    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId">
    </label><br>

    <select name="role" id="roleId">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</
            option>
        </c:forEach>

    </select><br>
    <c:forEach var="gender" items="${requestScope.gender}">
        <input type="radio" name="gender" value="${gender}">${gender}
        <br>
    </c:forEach>

    <label for="imageId">Image:
        <input type="file" name="image" id="imageId">
    </label><br>
    <button type="submit">Send</button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </c:if>
</form>
<%@include file="footer.jsp"%>

</body>
</html>
