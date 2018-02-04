<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.02.2018
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add conference</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3>Add conference</h3>
    <form name="addConferenceForm" onsubmit="return validateAddConferenceForm()">
        <input type="hidden" name="command" value="addconference"/>
        Conference name:<br/>
        <input type="text" name="conferenceName" value=""/>
        <br/>Conference description:<br/>
        <input type="text" name="conferenceDescription" value=""/>
        <br/>Conference country:<br/>
        <input type="text" name="conferenceCountry" value=""/>
        <br/>Conference city:<br/>
        <input type="text" name="conferenceCity" value=""/>
        <br/>
        <input class="button-primary" type="submit" value="Add" formmethod="post" formaction="controller"/>
    </form>
</div>
<br>
<%@include file="usermenu.jsp" %>
</body>
</html>
