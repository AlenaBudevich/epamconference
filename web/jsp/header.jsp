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
        <li><c:if test="${empty userId}"><a href="controller?command=login">Log in</a></c:if></li>
        <li><c:if test="${not empty userId}"><a href="controller?command=logout">Log out</a></c:if></li>
        <li><c:if test="${empty userId}"><a href="controller?command=registration">Registration</a></c:if></li>
        <li><a href="controller?command=viewallconferences">Main</a></li>
    </ul>
</div>
