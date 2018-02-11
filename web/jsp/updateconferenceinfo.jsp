<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.02.2018
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update conference info</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3><fmt:message key="updateconference.text.updateconference"/></h3>
    <form name="updateConferenceInfoForm" onsubmit="return validateUpdateConferenceForm()">
        <input type="hidden" name="command" value="updateconferenceinfo"/>
        <input type="hidden" name="conferenceId" value="${conference.conferenceId}"/>
        <label for="conferencename"><fmt:message key="updateconference.label.conferencename"/>:</label>
        <input type="text" id="conferencename" name="conferenceName" value="${conference.conferenceName}"/>
        <label for="conferencedescription"><fmt:message key="updateconference.label.conferencedescription"/>:</label>
        <input type="text" id="conferencedescription" name="conferenceDescription" value="${conference.conferenceDescription}"/>
        <label for="maxnumberparticipants"><fmt:message key="updateconference.label.maxnumberparticipants"/>:</label>
        <input type="number" id="maxnumberparticipants" name="maxNumberParticipants" value="${conference.maxNumberParticipants}"/>
        <label for="conferencebegining"><fmt:message key="updateconference.label.conferencebeginning"/>:</label>
        <input type="datetime" id="conferencebegining" name="conferenceBeginning" value="${conference.conferenceBeginning}"/>
        <label for="conferenceend"><fmt:message key="updateconference.label.conferenceend"/>:</label>
        <input type="datetime" id="conferenceend" name="conferenceEnd" value="${conference.conferenceEnd}"/>
        <label for="conferencecountry"><fmt:message key="updateconference.label.conferencecountry"/>:</label>
        <input type="text" id="conferencecountry" name="conferenceCountry" value="${conference.conferenceCountry}"/>
        <label for="conferencecity"><fmt:message key="updateconference.label.conferencecity"/>:</label>
        <input type="text" id="conferencecity" name="conferenceCity" value="${conference.conferenceCity}"/>
        <label for="conferenceaddress"><fmt:message key="updateconference.label.conferenceaddress"/>:</label>
        <input type="text" id="conferenceaddress" name="conferenceAddress" value="${conference.conferenceAddress}"/>
        <label for="conferencecontent"><fmt:message key="updateconference.label.conferencecontent"/>:</label>
        <input type="text" id="conferencecontent" name="conferenceContent" value="${conference.conferenceContent}"/>
        <label><fmt:message key="updateconference.label.conferencestatus"/>:</label>
        <select name="conferenceStatus">
            <option value="RECRUITED">RECRUITED</option>
            <option value="ACCEPTED">ACCEPTED</option>
            <option value="RUNNING">RUNNING</option>
            <option value="COMPLETED">COMPLETED</option>
        </select>
        <br/>
        <input class="button-primary" type="submit" value=<fmt:message key="updateconference.text.updateconference"/> formmethod="post" formaction="controller"/>
    </form>
</div>
</body>
</html>
