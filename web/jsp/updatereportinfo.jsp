<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2018
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/validation.js"></script>
<h1>Update report info</h1>
<form name="updateReportInfoForm" onsubmit="return validateUpdateReportForm()">
    <input type="hidden" name="command" value="updateReportInfo" />
    <input type="hidden" name="reportId" value="${report.reportId}" />
    <br/>Report name:<br/>
    <input type="text" name="reportName" value="${report.reportName}"/>
    <br/>Report theses:<br/>
    <input type="text" name="reportTheses" value="${report.reportTheses}"/>
    <br/>Report content:<br/>
    <input type="text" name="reportContent" value="${report.reportContent}"/>
    <br/>
    <input type="submit" value="Change info" formmethod="post" formaction="controller"/>
</form>

