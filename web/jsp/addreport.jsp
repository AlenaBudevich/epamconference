<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/validation.js"></script>
<h3><fmt:message key="addreport.text.addreport"/></h3>
<form name="addBasicReportInfoForm" onsubmit="return validateAddReportForm()">
    <input type="hidden" name="command" value="addBasicReportInfo" />
    <label for="reportname"><fmt:message key="addreport.label.reportname"/>:</label>
    <input type="text" id="reportname" name="reportName" value=""/>
    <label for="reporttheses"><fmt:message key="addreport.label.reporttheses"/>:</label>
    <input type="text" id="reporttheses" name="reportTheses" value=""/>
    <br/>
    <input class="button-primary" type="submit" value=<fmt:message key="addreport.text.addreport"/> formmethod="post" formaction="controller"/>
</form>
