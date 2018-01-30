<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2018
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update report info</title>
</head>
<body>
<%@include file="header.jsp"%>
<br>
<h1>Update report info</h1>
<form name="updateReportInfoForm">
    <input type="hidden" name="command" value="updateReportInfo" />
    <br/>Report name:<br/>
    <input type="text" name="reportName" value="${reportName}"/>
    <br/>Report theses:<br/>
    <input type="text" name="reportTheses" value="${reportTheses}"/>
    <br/>Report content:<br/>
    <input type="text" name="reportContent" value="${reportContent}"/>
    <br/>
    <input type="submit" value="Change info" formmethod="post" formaction="controller"/>
</form>
</body>
</html>
