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
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3>Change profile info</h3>
    <br>
    <form name="changeProfileInfoForm" onsubmit="return validateChangeProfileForm()">
        <input type="hidden" name="command" value="changeProfileInfo"/>
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
        <input class="button-primary" type="submit" value="Change" formmethod="post" formaction="controller"/>
    </form>
</div>
</body>
</html>
