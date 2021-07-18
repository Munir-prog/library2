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
    <title>Title</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
    <p>Add book on this form if you know the author name and publishing name!!!<br>
    If you don't know, go to book or publishing pages and see.</p>
    <form action="${pageContext.request.contextPath}/add" method="post" enctype="multipart/form-data">
        <label for="bookNameId">Book name:
            <input type="text" name="bookName" id="bookNameId">
        </label><br>
        <label for="pageCountId">Page count:
            <input type="number" name="pageCount" id="pageCountId">
        </label><br>
        <label for="chapterCountId">Chapter count:
            <input type="number" name="chapterCount" id="chapterCountId">
        </label><br>
        <label for="bookImageId">Book image:
            <input type="file" name="bookImage" id="bookImageId">
        </label><br>
        <label for="bookPartId">Book part:
            <input type="file" name="bookPart" id="bookPartId">
        </label><br>
        <label for="yearOfReleaseId">Year of release:
            <input type="number" name="yearOfRelease" id="yearOfReleaseId">
        </label><br>
        <label for="authorFirstNameId">Author first name:
            <input type="text" name="authorFirstName" id="authorFirstNameId">
        </label><br>
        <label for="authorLastNameId">Author last name:
            <input type="text" name="authorLastName" id="authorLastNameId">
        </label><br>
        <label for="publishingNameId">Publishing name:
            <input type="text" name="publishingName" id="publishingNameId">
        </label><br>
        <button type="submit">Send</button>


    </form>
    <%@include file="footer.jsp"%>

</body>
</html>
