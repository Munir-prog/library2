<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 13/07/2021
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    requestScope.userName--%>
    <title>${sessionScope.user.name}'s profile</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
    <div>
        <img src="${pageContext.request.contextPath}/images/users/42.jpg" alt="User image">
    </div>

<%@include file="footer.jsp"%>
</body>
</html>
