<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Section</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3><fmt:message key="section.text.section"/></h3>
    <h3>${section.sectionName}</h3>
    <c:set var="changeId" value="${changeId}"/>
    <c:set var="reports" value="${reports}"/>
    <c:set var="role" value="${role}"/>
    <div>
        <table>
            <tr>
                <th><fmt:message key="section.text.maxnumberreports"/></th>
                <td>${section.maxNumberReports}</td>
            </tr>
            <tr>
                <th><fmt:message key="section.text.sectionbeginning"/></th>
                <td>${section.sectionBeginning}</td>
            </tr>
            <tr>
                <th><fmt:message key="section.text.sectionend"/></th>
                <td>${section.sectionEnd}</td>
            </tr>
            <tr>
                <th><fmt:message key="section.text.sectionaddress"/></th>
                <td>${section.sectionAddress}</td>
            </tr>
            <tr>
                <th><fmt:message key="section.text.sectioncontent"/></th>
                <td>${section.sectionContent}</td>
            </tr>
            <tr>
                <th><fmt:message key="section.text.sectionstatus"/></th>
                <td>${section.sectionStatus}</td>
            </tr>
        </table>
    </div>

    <br>
    <c:if test="${not empty reports}">
        <div>
            <table>
                <tr>
                    <th><fmt:message key="section.text.reportname"/></th>
                    <th><fmt:message key="section.text.reporttheses"/></th>
                    <th><fmt:message key="section.text.reportstatus"/></th>
                    <th><fmt:message key="section.text.reportcontent"/></th>
                </tr>
                <c:forEach items="${reports}" var="current">
                    <tr>
                        <td><c:out value="${current.reportName}"/></td>
                        <td><c:out value="${current.reportTheses}"/></td>
                        <td><c:out value="${current.reportContent}"/></td>
                        <c:set var="currentId" value="${current.reportId}"/>

                        <c:if test="${changeId != currentId}">
                            <td><c:out value="${current.reportStatus}"/></td>
                            <c:if test="${role == 'ADMIN'}">
                                <td>
                                    <form>
                                        <input type="hidden" name="command" value="assignreportstatus"/>
                                        <input type="hidden" name="changeId" value="${current.reportId}"/>
                                        <input type="hidden" name="sectionId" value="${section.sectionId}"/>
                                        <input type="submit" value=<fmt:message key="section.text.change"/> formmethod="get"
                                               formaction="controller"/>
                                    </form>
                                </td>
                            </c:if>
                        </c:if>

                        <c:if test="${changeId == currentId}">
                            <td>
                                <form name="statusForm">
                                    <input type="hidden" name="command" value="assignReportStatus"/>
                                    <select name="status">
                                        <option value="FREE">FREE</option>
                                        <option value="REVIEWED">REVIEWED</option>
                                        <option value="REFUSED">REFUSED</option>
                                        <option value="ACCEPTED">ACCEPTED</option>
                                    </select>
                                    <input type="hidden" name="sectionId" value="${section.sectionId}"/>
                                    <input type="hidden" name="reportId" value="${currentId}"/>
                                    <input type="submit" value=<fmt:message key="section.text.change"/> formmethod="post" formaction="controller"/>
                                </form>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
