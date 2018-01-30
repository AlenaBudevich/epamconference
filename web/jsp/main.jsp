<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 28.01.2018
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<h1>Main</h1>
<c:set var="userId" value="${userId}"/>
<c:if test="${not empty userId}">
    <h3>hi, ${login}</h3>
    <h3>You are ${role}</h3>
</c:if>
<br>
<div>
    <table>
        <tr>
            <th>conferenceName</th>
            <th>conferenceDescription</th>
            <th>maxNumberParticipants</th>
            <th>conferenceCountry</th>
        </tr>
        <c:forEach items="${conferences}" var="current">
            <tr>
                <td><c:out value="${current.conferenceName}"/></td>
                <td><c:out value="${current.conferenceDescription}"/></td>
                <td><c:out value="${current.maxNumberParticipants}"/></td>
                <td><c:out value="${current.conferenceCountry}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<%@include file="usermenu.jsp" %>
</body>
</html>
