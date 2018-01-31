<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Section</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<h1>Section</h1>
<h3>${section.sectionName}</h3>
<c:set var="reports" value="${reports}"/>
<div>
    <table>
        <tr>
            <th>maxNumberReports</th>
            <td>${section.maxNumberReports}</td>
        </tr>
        <tr>
            <th>sectionBeginning</th>
            <td>${section.sectionBeginning}</td>
        </tr>
        <tr>
            <th>sectionEnd</th>
            <td>${section.sectionEnd}</td>
        </tr>
        <tr>
            <th>sectionAddress</th>
            <td>${section.sectionAddress}</td>
        </tr>
        <tr>
            <th>sectionContent</th>
            <td>${section.sectionContent}</td>
        </tr>
        <tr>
            <th>sectionStatus</th>
            <td>${section.sectionStatus}</td>
        </tr>
    </table>
</div>

<br>
<c:if test="${not empty reports}">
    <div>
        <table>
            <tr>
                <th>reportName</th>
                <th>reportTheses</th>
                <th>reportStatus</th>
                <th>reportContent</th>
            </tr>
            <c:forEach items="${reports}" var="current">
                <tr>
                    <td><c:out value="${current.reportName}"/></td>
                    <td><c:out value="${current.reportTheses}"/></td>
                    <td><c:out value="${current.reportStatus}"/></td>
                    <td><c:out value="${current.reportContent}"/></td>
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
