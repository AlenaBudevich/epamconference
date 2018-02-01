<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 29.01.2018
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User reports</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<c:set var="report" value="${report}"/>
<c:if test="${not empty report}">
    <%@include file="updatereportinfo.jsp" %>
</c:if>
<br>
<c:set var="addReport" value="${addReport}"/>
<c:if test="${not empty addReport}">
    <%@include file="addreport.jsp" %>
</c:if>

<br>
<c:set var="addSectionReport" value="${addSectionReport}"/>
<c:if test="${not empty addSectionReport}">
    <%@include file="addsectionreport.jsp" %>
</c:if>

<c:set var="deleteSectionReport" value="${deleteSectionReport}"/>
<c:if test="${not empty deleteSectionReport}">
    <%@include file="deletesectionreport.jsp" %>
</c:if>

<c:set var="reports" value="${userReports}"/>
<c:if test="${not empty reports}">
    <div>
        <table>
            <tr>
                <th>reportName</th>
                <th>reportTheses</th>
                <th>reportStatus</th>
                <th>reportContent</th>
            </tr>
            <c:forEach items="${userReports}" var="current">
                <tr>
                    <td><c:out value="${current.reportName}"/></td>
                    <td><c:out value="${current.reportTheses}"/></td>
                    <td><c:out value="${current.reportStatus}"/></td>
                    <td><c:out value="${current.reportContent}"/></td>

                    <c:url value="controller?command=updatereportinfo" var="updateReport">
                        <c:param name="reportId" value="${current.reportId}"/>
                    </c:url>
                    <td><a href=${updateReport}>Update report info</a></td>

                    <c:url value="controller?command=deletereport" var="deleteReport">
                        <c:param name="reportId" value="${current.reportId}"/>
                    </c:url>
                    <td><a href=${deleteReport}>Delete report</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<br>
<%@include file="usermenu.jsp" %>
<br>
<a href="controller?command=addbasicreportinfo">Add new report</a>
<br>
<a href="controller?command=addsectionreport">Add section-report</a>
<br>
<a href="controller?command=deletesectionreport">Delete section-report</a>
</body>
</html>
