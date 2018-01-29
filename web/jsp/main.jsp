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
<h1>Main</h1>
<a href="controller?command=login">Login</a>
<a href="controller?command=logout">Logout</a>
<a href="controller?command=registration">Registration</a>
<br>
<h5>hi, ${login}</h5>
<h5>You are ${role}</h5>
<a href="controller?command=viewprofileinfo">My profile</a>
<a href="controller?command=viewuserreports">My reports</a>
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
</body>
</html>
