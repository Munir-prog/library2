<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>

<c:choose>
    <c:when test="${not empty param.fullName}">
        <h1>${param.fullName}'s books:</h1>
        <br />
    </c:when>
    <c:otherwise>
        <h1>All books:</h1>
        <br />
    </c:otherwise>
</c:choose>

<c:if test="${not empty requestScope.books}">
    <ul>
        <c:forEach var="book" items="${requestScope.books}">
            <li>${book.bookName}${book.bookDescription}Publishing id: ${book.publishingId}<br>***************</li>
            <br>
        </c:forEach>
    </ul>
</c:if>

</body>
</html>
