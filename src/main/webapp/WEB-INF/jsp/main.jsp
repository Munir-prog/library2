<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 12/07/2021
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
    <%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>--%>
    <%--2--%>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
<div class="test">
    <h1 class="h1test">LIBRARY</h1>
    <div class="buttons">
        <a href="${pageContext.request.contextPath}/login">
            <button class="mainButton" type="button">Sign in</button>
        </a>
        <a href="${pageContext.request.contextPath}/registration">
            <button class="mainButton" type="button">Sign up</button>
        </a>
    </div>


</div>
<%--<div class="img" style="background-image: url('/lib.jpg')">--%>
<div class="figure">
    <div class="d22">
    </div>
    <div class="d23">
    </div>
    <div class="d21">
    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
<%--<c:url value="../css/style.css"></c:url>--%>
<%--<c:url value='../css/style.css'/>--%>
