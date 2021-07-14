<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 14/07/2021
  Time: 13:14
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
    <c:forEach var="book" items="${requestScope.book}">
        <img src="${pageContext.request.contextPath}/images/${book.bookImage}" alt="Book image" class="imgFace">
        <span>Name: ${book.bookName}</span><br>
        <span>Pages: ${book.pageCount}</span><br>
        <span>Chapters: ${book.chapterCount}</span><br>
        <span>Year of release: ${book.yearOfRelease}</span><br>
        <span>Publishing id: ${book.publishingId}</span><br>
        <a href="${pageContext.request.contextPath}/download?bookPart=${book.bookPart}">Download</a>
    </c:forEach>
    <%@include file="footer.jsp"%>

</body>
</html>
