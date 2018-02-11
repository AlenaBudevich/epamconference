<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 28.01.2018
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>

    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<%@include file="header.jsp" %>

<div class="row" align="center">
    <h3><fmt:message key="main.text.main"/></h3>
    <c:set var="userId" value="${userId}"/>
    <c:set var="role" value="${role}"/>
    <c:if test="${not empty userId}">
        <h3><fmt:message key="main.text.hi"/> ${login}</h3>
        <h3><ctg:role role="${role}"/></h3>
    </c:if>
    <br>
    <table>
        <tr>
            <th><fmt:message key="main.text.conferencename"/></th>
            <th><fmt:message key="main.text.conferencedescription"/></th>
            <th><fmt:message key="main.text.maxnumberparticipants"/></th>
            <th><fmt:message key="main.text.conferencecountry"/></th>
        </tr>
        <c:forEach items="${conferences}" var="current">
            <tr>
                <td><c:out value="${current.conferenceName}"/></td>
                <td><c:out value="${current.conferenceDescription}"/></td>
                <td><c:out value="${current.maxNumberParticipants}"/></td>
                <td><c:out value="${current.conferenceCountry}"/></td>
                <c:if test="${role == 'ADMIN'}">
                    <td>
                        <form>
                            <input type="hidden" name="command" value="updateconferenceinfo"/>
                            <input type="hidden" name="conferenceId" value="${current.conferenceId}"/>
                            <input type="submit" value=<fmt:message key="main.text.update"/> formmethod="get" formaction="controller"/>
                        </form>
                    </td>
                    <td>
                        <form>
                            <input type="hidden" name="command" value="deleteconference"/>
                            <input type="hidden" name="conferenceId" value="${current.conferenceId}"/>
                            <input type="submit" value=<fmt:message key="main.text.delete"/> formmethod="get" formaction="controller"/>
                        </form>
                    </td>
                </c:if>
                <c:if test="${not empty userId}">

                    <td>
                        <form>
                            <input type="hidden" name="command" value="viewconferencesections"/>
                            <input type="hidden" name="conferenceId" value="${current.conferenceId}"/>
                            <input type="submit" value=<fmt:message key="main.text.moreinfo"/> formmethod="get" formaction="controller"/>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>