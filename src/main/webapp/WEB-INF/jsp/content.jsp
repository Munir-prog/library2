<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 10/07/2021
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <div>
        <span>Content. Русский язык.</span>
        <p>Size: ${requestScope.flights.size()}</p>
        <p>Id1: ${requestScope.flights.get(0).id}</p>
        <p>Id2: ${requestScope.flights[1].id}</p>
        <p>Map Id2: ${sessionScope.flightsMap[1]}</p>
        <p>JSESSION ID: ${cookie["JSESSIONID"]}, unique identifier</p>
        <p>Header: ${header["Cookie"]}</p>
        <p>Param id: ${param.id}</p>
        <p>Param <tes></tes>t: ${param.test}</p>
        <p>Empty list ${not empty requestScope.flights}</p>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
