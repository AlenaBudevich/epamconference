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
    <h3><fmt:message key="registration.text.registration"/></h3>
    <form name="registrationForm" onsubmit="return validateRegistrationForm()">
        <input type="hidden" name="command" value="registration"/>
        <label for="login"><fmt:message key="registration.label.login"/>:</label>
        <input type="text" id="login" name="login" value=""/>
        <label for="email"><fmt:message key="registration.label.email"/>:</label>
        <input type="text" id="email" name="email" value=""/>
        <label for="password"><fmt:message key="registration.label.password"/>:</label>
        <input type="password" id="password" name="password" value=""/>
        <label for="repeatpassword"><fmt:message key="registration.label.repeatpassword"/>:</label>
        <input type="password" id="repeatpassword" name="repeatpassword" value=""/>
        <br/>
        <input class="button-primary" type="submit" value=<fmt:message key="registration.text.registration"/> formmethod="post" formaction="controller"/>
    </form>
</div>
</body>
</html>
