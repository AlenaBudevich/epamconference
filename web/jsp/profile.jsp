<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 29.01.2018
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<%@include file="header.jsp"%>
<br>
<h1>Profile</h1>
<div>
    <table>
        <tr>
            <th>login</th>
            <td>${login}</td>
        </tr>
        <tr>
            <th>email</th>
            <td>${email}</td>
        </tr>
        <tr>
            <th>role</th>
            <td>${role}</td>
        </tr>
        <tr>
            <th>phoneNumber</th>
            <td>${phoneNumber}</td>
        </tr>
        <tr>
            <th>avatar</th>
            <td>${avatar}</td>
        </tr>
        <tr>
            <th>firstName</th>
            <td>${firstName}</td>
        </tr>
        <tr>
            <th>lastName</th>
            <td>${lastName}</td>
        </tr>
        <tr>
            <th>surname</th>
            <td>${surname}</td>
        </tr>
    </table>
</div>
<br>
<%@include file="usermenu.jsp"%>
<br>
<a href="controller?command=changeprofileinfo">ChangeProfileInfoPage</a>
</body>
</html>
