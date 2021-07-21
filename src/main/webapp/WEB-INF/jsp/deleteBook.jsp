<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 19/07/2021
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting Book</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>

</head>
<body>
<form action="${pageContext.request.contextPath}/delete" method="post">
    <label for="bookNameId">Book name:
        <input type="text" name="bookName" id="bookNameId">
    </label><br>
    <button type="submit">Delete</button>
</form>

<c:if test="${not empty requestScope.errors}">
    <c:forEach var="error" items="${requestScope.errors}">
        <span class="error">${error.message}</span><br>
    </c:forEach>
</c:if>
<%@include file="footer.jsp"%>
</body>
</html>
