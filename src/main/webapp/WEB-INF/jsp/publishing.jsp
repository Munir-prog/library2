<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 13/07/2021
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publishing</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
<h1>Publishing Houses:</h1>
<c:if test="${not empty requestScope.publishing}">

    <ul>
        <c:forEach var="name" items="${requestScope.publishing}">
            <li>
                <a href="${pageContext.request.contextPath}/publishing?publishingName=${name}">${name}</a>
                <form action="${pageContext.request.contextPath}/deletePublishing" method="post">
                    <input type="text" name="publishingName" value="${name}" hidden>
                    <button>Delete</button>
                </form>
            </li>

        </c:forEach>
    </ul>
</c:if>

<c:if test="${not empty requestScope.errors}">
        <span class="error">${requestScope.errors}</span><br>
</c:if>

<%@include file="footer.jsp"%>
</body>
</html>
