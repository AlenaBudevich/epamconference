<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conference</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<h1>Conference</h1>
<h3>${conference.conferenceName}</h3>
<c:set var="sections" value="${sections}"/>
<br>
<div>
    <table>
        <tr>
            <th>conferenceDescription</th>
            <td>${conference.conferenceDescription}</td>
        </tr>
        <tr>
            <th>maxNumberParticipants</th>
            <td>${conference.maxNumberParticipants}</td>
        </tr>
        <tr>
            <th>conferenceBeginning</th>
            <td>${conference.conferenceBeginning}</td>
        </tr>
        <tr>
            <th>conferenceEnd</th>
            <td>${conference.conferenceEnd}</td>
        </tr>
        <tr>
            <th>conferenceCountry</th>
            <td>${conference.conferenceCountry}</td>
        </tr>
        <tr>
            <th>conferenceCity</th>
            <td>${conference.conferenceCity}</td>
        </tr>
        <tr>
            <th>conferenceAddress</th>
            <td>${conference.conferenceAddress}</td>
        </tr>
        <tr>
            <th>conferenceContent</th>
            <td>${conference.conferenceContent}</td>
        </tr>
        <tr>
            <th>conferenceStatus</th>
            <td>${conference.conferenceStatus}</td>
        </tr>
    </table>
</div>

<br>
<c:if test="${not empty sections}">
    <div>
        <table>
            <tr>
                <th>sectionName</th>
                <th>sectionBeginning</th>
                <th>sectionAddress</th>
                <th>sectionStatus</th>
            </tr>
            <c:forEach items="${sections}" var="current">
                <tr>
                    <td><c:out value="${current.sectionName}"/></td>
                    <td><c:out value="${current.sectionBeginning}"/></td>
                    <td><c:out value="${current.sectionAddress}"/></td>
                    <td><c:out value="${current.sectionStatus}"/></td>
                    <c:url value="controller?command=viewsectionreports" var="viewReports">
                        <c:param name="sectionId" value="${current.sectionId}"/>
                    </c:url>
                    <td><a href=${viewReports}>More info>></a></td>

                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>

<br>
<%@include file="usermenu.jsp" %>
<br>
</body>
</html>
