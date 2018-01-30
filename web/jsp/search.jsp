<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2018
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<h1>Search</h1>
<div>
    <table>
        <c:forEach items="${result}" var="current">
            <tr>
                <td><c:out value="${current.reportName}"/></td>
                <td><c:out value="${current.reportTheses}"/></td>
                <td><c:out value="${current.reportStatus}"/></td>
                <td><c:out value="${current.reportContent}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <table>
        <c:forEach items="${result}" var="current">
            <tr>
                <td><c:out value="${current.sectionName}"/></td>
                <td><c:out value="${current.maxNumberReports}"/></td>
                <td><c:out value="${current.sectionAddress}"/></td>
                <td><c:out value="${current.sectionContent}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <table>
        <c:forEach items="${result}" var="current">
            <tr>
                <td><c:out value="${current.conferenceName}"/></td>
                <td><c:out value="${current.conferenceDescription}"/></td>
                <td><c:out value="${current.maxNumberParticipants}"/></td>
                <td><c:out value="${current.conferenceCountry}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
