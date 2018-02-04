<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 22.01.2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Registration</title></head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp"%>
<br>
<h1>Registration</h1>
<form name="registrationForm" onsubmit="return validateRegistrationForm()">
    <input type="hidden" name="command" value="registration"/>
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>Repeat password:<br/>
    <input type="password" name="repeatpassword" value=""/>
    <br/>Email:<br/>
    <input type="text" name="email" value=""/>
    <br/>
    <input type="submit" value="Registration" formmethod="post" formaction="controller"/>
</form><hr/>
</body></html>
