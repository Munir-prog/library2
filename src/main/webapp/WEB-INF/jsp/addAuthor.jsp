<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 26/07/2021
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/addAuthor" method="post">
    <label for="firstNameId">First name:
        <input type="text" name="firstName" id="firstNameId" required>
    </label><br>
    <label for="lastNameId">Last name:
        <input type="text" name="lastName" id="lastNameId" required>
    </label><br>
    <label for="yearOfBirthId">Year of birth:
        <input type="number" name="yearOfBirth" id="yearOfBirthId" required>
    </label><br>

    <button type="submit">Send</button>


</form>

<c:if test="${not empty requestScope.errors}">
    <c:forEach var="error" items="${requestScope.errors}">
        <span class="error">${error.message}</span><br>
    </c:forEach>
</c:if>
<%@include file="footer.jsp"%>

</body>
</html>
