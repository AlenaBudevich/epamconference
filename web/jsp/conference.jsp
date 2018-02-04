<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conference</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3>Conference</h3>
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
                        <c:if test="${role == 'ADMIN'}">
                            <td>
                                <form>
                                    <input type="hidden" name="command" value="updatesectioninfo"/>
                                    <input type="hidden" name="sectionId" value="${current.sectionId}"/>
                                    <input type="submit" value="Update" formmethod="get" formaction="controller"/>
                                </form>
                            </td>
                            <td>
                                <form>
                                    <input type="hidden" name="command" value="deletesection"/>
                                    <input type="hidden" name="sectionId" value="${current.sectionId}"/>
                                    <input type="submit" value="Delete" formmethod="get" formaction="controller"/>
                                </form>
                            </td>
                        </c:if>
                        <td>
                            <form>
                                <input type="hidden" name="command" value="viewsectionreports"/>
                                <input type="hidden" name="sectionId" value="${current.sectionId}"/>
                                <input type="submit" value="More info" formmethod="get" formaction="controller"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>

</div>
<%@include file="usermenu.jsp" %>
<br>
</body>
</html>
