<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.02.2018
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3><fmt:message key="deletesectionreport.text.deletesectionreport"/></h3>
<form name="deleteSectionReportForm">
    <input type="hidden" name="command" value="deletesectionreport"/>
    <label for="sectionname"><fmt:message key="deletesectionreport.label.sectionname"/>:</label>
    <input type="text" id="sectionname" name="sectionName" value=""/>
    <label for="reportname"><fmt:message key="deletesectionreport.label.reportname"/>:</label>
    <input type="text" id="reportname" name="reportName" value=""/>
    <br/>
    <input class="button-primary" type="submit" value=<fmt:message key="deletesectionreport.text.deletesectionreport"/> formaction="controller" formmethod="post"/>
</form>
