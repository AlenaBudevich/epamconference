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
    <h3><fmt:message key="changeprofile.text.changeprofile"/></h3>
    <br>
    <form name="changeProfileInfoForm" onsubmit="return validateChangeProfileForm()">
        <input type="hidden" name="command" value="changeProfileInfo"/>
        <label for="email"><fmt:message key="changeprofile.label.email"/>:</label>
        <input type="text" id="email" name="email" value="${email}"/>
        <label for="phonenumber"><fmt:message key="changeprofile.label.phonenumber"/>:</label>
        <input type="text" id="phonenumber" name="phoneNumber" value="${phoneNumber}" pattern="[0-9]+"/>
        <label for="avatar"><fmt:message key="changeprofile.label.avatar"/>:</label>
        <input type="text" id="avatar" name="avatar" value="${avatar}"/>
        <label for="firstname"><fmt:message key="changeprofile.label.firstname"/>:</label>
        <input type="text" id="firstname" name="firstName" value="${firstName}"/>
        <label for="lastname"><fmt:message key="changeprofile.label.lastname"/>:</label>
        <input type="text" id="lastname" name="lastName" value="${lastName}"/>
        <label for="surname"><fmt:message key="changeprofile.label.surname"/>:</label>
        <input type="text" id="surname" name="surname" value="${surname}"/>
        <br/>
        <input class="button-primary" type="submit" value=<fmt:message key="changeprofile.text.changeprofile"/> formmethod="post" formaction="controller"/>
    </form>
</div>
</body>
</html>
