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
<c:if test="${not empty requestScope.publishingHouse}">
    <span>${requestScope.publishingHouse.publishingName}</span><br>
    <span>${requestScope.publishingHouse.location}</span><br>
    <span>${requestScope.publishingHouse.phoneNumber}</span><br>
    <span><a href="${requestScope.publishingHouse.website}">Go to website</a></span><br>

</c:if>

<%@include file="footer.jsp"%>
</body>
</html>
