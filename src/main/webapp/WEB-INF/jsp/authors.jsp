<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authors</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>

<h1>List of Authors</h1>
<ul>

    <c:forEach var="author" items="${requestScope.authors}">
        <li>
            <a href="${pageContext.request.contextPath}/books?bookId=${author.id}&fullName=${author.fullName}">
                    ${author.fullName}'s books
            </a>
        </li>
    </c:forEach>
</ul>

<%@include file="footer.jsp"%>

</body>
</html>
