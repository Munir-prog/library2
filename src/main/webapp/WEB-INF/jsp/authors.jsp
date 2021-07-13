<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>List of Authors</h1>
<ul>

    <c:forEach var="author" items="${requestScope.authors}">
        <li>
            <a href="${pageContext.request.contextPath}/books?bookId=${author.id}&fullName=${author.fullName}">
                    ${author.fullName}
            </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
