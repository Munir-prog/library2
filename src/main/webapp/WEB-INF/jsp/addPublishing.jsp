<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 02/08/2021
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add publishing</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/addPublishing" method="post">
    <label for="publishingNameId">Publishing name:
        <input type="text" name="publishingName" id="publishingNameId" required>
    </label>
    <br>
    <label for="phoneNumberId">Phone number: (+77777777777)
        <input type="text" name="phoneNumber" id="phoneNumberId" required>
    </label>
    <br>
    <label for="websiteId">Website:
        <input type="text" name="website" id="websiteId" required>
    </label>
    <br>
    <label for="cityId">City:
        <input type="text" name="city" id="cityId" required>
    </label>
    <br>
    <label for="countryId">Country:
        <input type="text" name="country" id="countryId" required>
    </label>
    <br>
    <button type="submit">Add</button>

</form>


<c:if test="${not empty requestScope.errors}">
    <c:forEach var="error" items="${requestScope.errors}">
        <span class="error">${error.message}</span><br>
    </c:forEach>
</c:if>
<%@include file="footer.jsp"%>

</body>
</html>
