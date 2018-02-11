<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.02.2018
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/validation.js"></script>
<h3><fmt:message key="addsectionreport.text.addsectionreport"/></h3>
<form name="addSectionReportForm" onsubmit="return validateAddSectionReportForm()">
    <input type="hidden" name="command" value="addsectionreport"/>
    <label for="sectionname"><fmt:message key="addsectionreport.label.sectionname"/>:</label>
    <input type="text" id="sectionname" name="sectionName" value=""/>
    <label for="reportname"><fmt:message key="addsectionreport.label.reportname"/>:</label>
    <input type="text" id="reportname" name="reportName" value=""/>
    <br/>
    <input class="button-primary" type="submit" value=<fmt:message key="addsectionreport.text.addsectionreport"/> formaction="controller" formmethod="post"/>
</form>
