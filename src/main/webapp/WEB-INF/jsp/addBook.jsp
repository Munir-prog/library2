<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 13/07/2021
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding Book</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
    <p>Add book on this form if you know the author name and publishing name!!!<br>
    If you don't know, go to book or publishing pages and see.</p>
    <form action="${pageContext.request.contextPath}/add" method="post" enctype="multipart/form-data">
        <label for="bookNameId">Book name:
            <input type="text" name="bookName" id="bookNameId" required>
        </label><br>
        <label for="pageCountId">Page count:
            <input type="number" name="pageCount" id="pageCountId" required>
        </label><br>
        <label for="chapterCountId">Chapter count:
            <input type="number" name="chapterCount" id="chapterCountId" required>
        </label><br>
        <label for="bookImageId">Book image:
            <input type="file" name="bookImage" id="bookImageId" required>
        </label><br>
        <label for="bookPartId">Book part:
            <input type="file" name="bookPart" id="bookPartId" required>
        </label><br>
        <label for="yearOfReleaseId">Year of release:
            <input type="number" name="yearOfRelease" id="yearOfReleaseId" required>
        </label><br>
        <label for="authorFirstNameId">Author first name:
            <input type="text" name="authorFirstName" id="authorFirstNameId" required>
        </label><br>
        <label for="authorLastNameId">Author last name:
            <input type="text" name="authorLastName" id="authorLastNameId" required>
        </label><br>
        <label for="publishingNameId">Publishing name:
            <input type="text" name="publishingName" id="publishingNameId" required>
        </label><br>
        <button type="submit">Send</button>


    </form>

    <c:if test="${not empty requestScope.errors}">
        <c:forEach var="error" items="${requestScope.errors}">
            <span class="error">${error.message}</span><br>
        </c:forEach>
    </c:if>
    <%@include file="footer.jsp"%>

</body>
</html>
