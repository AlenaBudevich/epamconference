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
    <h3><fmt:message key="addconference.text.addconference"/></h3>
    <form name="addConferenceForm" onsubmit="return validateAddConferenceForm()">
        <input type="hidden" name="command" value="addconference"/>
        <label for="conferencename"><fmt:message key="addconference.label.conferencename"/>:</label>
        <input type="text" id="conferencename" name="conferenceName" value=""/>
        <label for="conferencedescription"><fmt:message key="addconference.label.conferencedescription"/>:</label>
        <input type="text" id="conferencedescription" name="conferenceDescription" value=""/>
        <label for="conferencecountry"><fmt:message key="addconference.label.conferencecountry"/>:</label>
        <input type="text" id="conferencecountry" name="conferenceCountry" value=""/>
        <label for="conferencecity"><fmt:message key="addconference.label.conferencecity"/>:</label>
        <input type="text" id="conferencecity" name="conferenceCity" value=""/>
        <br/>
        <input class="button-primary" type="submit" value=<fmt:message key="addconference.text.addconference"/> formmethod="post" formaction="controller"/>
    </form>
</div>
</body>
</html>
