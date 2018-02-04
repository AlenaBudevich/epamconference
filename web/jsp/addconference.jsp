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
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<br>
<h1>Add conference</h1>
<form name="addConferenceForm" onsubmit="return validateAddConferenceForm()">
    <input type="hidden" name="command" value="addconference" />
    Conference name:<br/>
    <input type="text" name="conferenceName" value=""/>
    <br/>Conference description:<br/>
    <input type="text" name="conferenceDescription" value=""/>
    <br/>Conference country:<br/>
    <input type="text" name="conferenceCountry" value=""/>
    <br/>Conference city:<br/>
    <input type="text" name="conferenceCity" value=""/>
    <br/>
    <input type="submit" value="Add conference" formmethod="post" formaction="controller"/>
</form>
<br>
<%@include file="usermenu.jsp" %>
</body>
</html>
