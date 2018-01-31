<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2018
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <ul>
        <c:set var="userId" value="${userId}"/>
        <c:if test="${not empty userId}">
            <li><a href="controller?command=logout">Log out</a></li>
        </c:if>
        <c:if test="${empty userId}">
            <li><a href="controller?command=login">Log in</a></li>

            <li><a href="controller?command=registration">Registration</a></li>
        </c:if>
        <li><a href="controller?command=viewallconferences">Main</a></li>
    </ul>
</div>
