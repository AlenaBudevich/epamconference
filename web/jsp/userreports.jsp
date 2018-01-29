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
<a href="controller?command=viewallconferences">MainPage</a>
<a href="controller?command=viewprofileinfo">My profile</a>
<h1>${login}'s reports</h1>
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
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
