<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of Authors</h1>
<ul>
    <c:forEach var="author" items="${requestScope.authors}">
        <li>
            <a href="${pageContext.request.contextPath}/books?bookId=${author.id}&fullName=${author.fullName}">
                    ${author.fullName}
            </a>
        </li>
    </c:forEach>


<%--    authorService.findAll().forEach(authorDto -> {--%>
<%--    writer.write("""--%>
<%--    <li>--%>
<%--        <a href="/books?bookId=%d&fullName=%s">%s</a>--%>
<%--    </li>--%>
<%--    """.formatted(authorDto.getId(), authorDto.getFullName(), authorDto.getFullName()));--%>
<%--    });--%>
</ul>
</body>
</html>
