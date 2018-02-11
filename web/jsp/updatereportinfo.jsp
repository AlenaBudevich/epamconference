<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2018
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/validation.js"></script>
<h3<fmt:message key="updatereport.text.updatereport"/></h3>
<form name="updateReportInfoForm" onsubmit="return validateUpdateReportForm()">
    <input type="hidden" name="command" value="updateReportInfo" />
    <input type="hidden" name="reportId" value="${report.reportId}" />
    <label for="reportname"><fmt:message key="updatereport.label.reportname"/>:</label>
    <input type="text" id="reportname" name="reportName" value="${report.reportName}"/>
    <label for="reporttheses"><fmt:message key="updatereport.label.reporttheses"/>:</label>
    <input type="text" id="reporttheses" name="reportTheses" value="${report.reportTheses}"/>
    <label for="reportcontent"><fmt:message key="updatereport.label.reportcontent"/>:</label>
    <input type="text" id="reportcontent" name="reportContent" value="${report.reportContent}"/>
    <br/>
    <input class="button-primary" type="submit" value=<fmt:message key="updatereport.text.updatereport"/> formmethod="post" formaction="controller"/>
</form>

