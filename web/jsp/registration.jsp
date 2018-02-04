<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 22.01.2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3>Registration</h3>
    <form name="registrationForm" onsubmit="return validateRegistrationForm()">
        <input type="hidden" name="command" value="registration"/>
        Login:<br/>
        <input type="text" name="login" value=""/>
        <br/>Email:<br/>
        <input type="text" name="email" value=""/>
        <br/>Password:<br/>
        <input type="password" name="password" value=""/>
        <br/>Repeat password:<br/>
        <input type="password" name="repeatpassword" value=""/>
        <br/>
        <input class="button-primary" type="submit" value="Registration" formmethod="post" formaction="controller"/>
    </form>
</div>
</body>
</html>
