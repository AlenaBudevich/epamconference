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
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3><fmt:message key="userreports.text.userrepoerts"/></h3>
</div>

<div class="row" align="center">
    <c:set var="report" value="${report}"/>
    <c:if test="${not empty report}">
        <%@include file="updatereportinfo.jsp" %>
    </c:if>

    <c:set var="addReport" value="${addReport}"/>
    <c:if test="${not empty addReport}">
        <%@include file="addreport.jsp" %>
    </c:if>

    <c:set var="deleteSectionReport" value="${deleteSectionReport}"/>
    <c:if test="${not empty deleteSectionReport}">
        <%@include file="deletesectionreport.jsp" %>
    </c:if>
    <c:set var="addSectionReport" value="${addSectionReport}"/>
    <c:if test="${not empty addSectionReport}">
        <%@include file="addsectionreport.jsp" %>
    </c:if>
</div>

<div class="row">
    <div class="three columns">
        <ul class="nav navmenu-nav">
            <li><a href="controller?command=addbasicreportinfo"><fmt:message key="userreports.text.addreport"/></a></li>
            <li><a href="controller?command=addsectionreport"><fmt:message key="userreports.text.addsectionreport"/></a></li>
            <li><a href="controller?command=deletesectionreport"><fmt:message key="userreports.text.deletesectionreport"/></a></li>
        </ul>
    </div>

    <c:set var="reports" value="${userReports}"/>
    <c:if test="${not empty reports}">


        <div class="nine columns">
            <table>
                <tr>
                    <th><fmt:message key="userreports.text.reportname"/></th>
                    <th><fmt:message key="userreports.text.reporttheses"/></th>
                    <th><fmt:message key="userreports.text.reportstatus"/></th>
                    <th><fmt:message key="userreports.text.reportcontent"/></th>
                </tr>
                <c:forEach items="${userReports}" var="current">
                    <tr>
                        <td><c:out value="${current.reportName}"/></td>
                        <td><c:out value="${current.reportTheses}"/></td>
                        <td><c:out value="${current.reportStatus}"/></td>
                        <td><c:out value="${current.reportContent}"/></td>
                        <td>
                            <form>
                                <input type="hidden" name="command" value="updatereportinfo"/>
                                <input type="hidden" name="reportId" value="${current.reportId}"/>
                                <input type="submit" value=<fmt:message key="userreports.text.update"/> formmethod="get" formaction="controller"/>
                            </form>
                        </td>
                        <td>
                            <form>
                                <input type="hidden" name="command" value="deletereport"/>
                                <input type="hidden" name="reportId" value="${current.reportId}"/>
                                <input type="submit" value=<fmt:message key="userreports.text.delete"/> formmethod="get" formaction="controller"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
