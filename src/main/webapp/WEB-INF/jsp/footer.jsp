<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 10/07/2021
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="footer">
    <a href="${pageContext.request.contextPath}/main">MAIN PAGE</a>
    <c:if test="${not empty sessionScope.user}">
        <div class="logoutButton">
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit">Logout</button>
            </form>
        </div>
    </c:if>
    <c:if test="${not empty sessionScope.user}">
        <div class="goToProfile">
            <a href="${pageContext.request.contextPath}/profile">
                <button type="button">My profile</button>
            </a>
        </div>
    </c:if>

</div>
