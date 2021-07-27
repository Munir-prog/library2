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
<body >
<div class="content">
    <div class="profileContent">
        <img src="${pageContext.request.contextPath}/images/${sessionScope.user.image}" alt="User image" class="imgFace">
        <span>Name: ${sessionScope.user.name}</span>
        <span>Email: ${sessionScope.user.email}</span>
        <span>Birthday: ${sessionScope.user.birthday}</span>
    </div>
    <div class="libContent">
        <a href="${pageContext.request.contextPath}/authors">Authors</a>
        <a href="${pageContext.request.contextPath}/books">Books</a>
        <a href="${pageContext.request.contextPath}/publishing">Publishing</a>
        <a href="${pageContext.request.contextPath}/addBook">Add book</a>
        <a href="${pageContext.request.contextPath}/deleteBook">Delete book</a>
        <a href="${pageContext.request.contextPath}/addAuthor">Add author</a>
        <a href="${pageContext.request.contextPath}/deleteAuthor">Delete author</a>

    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
