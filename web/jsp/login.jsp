<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 21.01.2018
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="${language}">
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3>Let's Login</h3>
    <form name="loginForm" onsubmit="return validateLoginForm()">
        <input type="hidden" name="command" value="login"/>
        <label for="login"><fmt:message key="login.label.login"/>:</label>
        <input type="text" id="login" name="login" value=""/>
        <br/>Password:<br/>
        <input type="password" name="password" value=""/>
        <br/>
        <input class="button-primary" type="submit" value="Log in" formaction="controller" formmethod="post"/>
    </form>
</div>
</body>
</html>