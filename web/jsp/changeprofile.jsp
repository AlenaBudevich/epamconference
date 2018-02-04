<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 29.01.2018
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change profile info</title>
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp"%>
<br>
<h1>Change profile info</h1>
<br>
<form name="changeProfileInfoForm" onsubmit="return validateChangeProfileForm()">
    <input type="hidden" name="command" value="changeProfileInfo" />
    <br/>Email:<br/>
    <input type="text" name="email" value="${email}"/>
    <br/>Phone number:<br/>
    <input type="text" name="phoneNumber" value="${phoneNumber}"/>
    <br/>Avatar:<br/>
    <input type="text" name="avatar" value="${avatar}"/>
    <br/>First Name:<br/>
    <input type="text" name="firstName" value="${firstName}"/>
    <br/>Last Name:<br/>
    <input type="text" name="lastName" value="${lastName}"/>
    <br/>Surname:<br/>
    <input type="text" name="surname" value="${surname}"/>
    <br/>
    <input type="submit" value="Change info" formmethod="post" formaction="controller"/>
</form>
<br>
<%@include file="usermenu.jsp"%>
</body>
</html>
