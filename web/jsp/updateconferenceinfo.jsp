<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.02.2018
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update conference info</title>
</head>
<body>
<h1>Update conference info</h1>
<form name="updateConferenceInfoForm">
    <input type="hidden" name="command" value="updateconferenceinfo" />
    Conference name:<br/>
    <input type="text" name="conferenceName" value="${conference.conferenceName}"/>
    <br/>Conference description:<br/>
    <input type="text" name="conferenceDescription" value="${conference.conferenceDescription}"/>
    <br/>Max number participants:<br/>
    <input type="number" name="maxNumberParticipants" value="${conference.maxNumberParticipants}"/>
    <br/>Conference beginning:<br/>
    <input type="datetime" name="conferenceBeginning" value="${conference.conferenceBeginning}"/>
    <br/>Conference end:<br/>
    <input type="datetime" name="conferenceEnd" value="${conference.conferenceEnd}"/>
    <br/>Conference country:<br/>
    <input type="text" name="conferenceCountry" value="${conference.conferenceCountry}"/>
    <br/>Conference city:<br/>
    <input type="text" name="conferenceCity" value="${conference.conferenceCity}"/>
    <br/>Conference address:<br/>
    <input type="text" name="conferenceAddress" value="${conference.conferenceAddress}"/>
    <br/>Conference content:<br/>
    <input type="text" name="conferenceContent" value="${conference.conferenceContent}"/>
    <br/>Conference status:<br/>
    <select name="conferenceStatus">
        <option value="RECRUITED">RECRUITED</option>
        <option value="ACCEPTED">ACCEPTED</option>
        <option value="RUNNING">RUNNING</option>
        <option value="COMPLETED">COMPLETED</option>
    </select>
    <br/>
    <input type="submit" value="Update conference" formmethod="post" formaction="controller"/>
</form>
</body>
</html>
