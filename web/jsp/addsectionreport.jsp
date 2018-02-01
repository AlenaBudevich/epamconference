<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.02.2018
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Add section-report</h1>
<form name="addSectionReportForm">
    <input type="hidden" name="command" value="addsectionreport"/>
    Section name:<br/>
    <input type="text" name="sectionName" value=""/>
    <br/>Report name:<br/>
    <input type="text" name="reportName" value=""/>
    <br/>
    <input type="submit" value="Add info" formaction="controller" formmethod="post"/>
</form>
