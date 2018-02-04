<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/validation.js"></script>
<h1>Add basic report info</h1>
<form name="addBasicReportInfoForm" onsubmit="return validateAddReportForm()">
    <input type="hidden" name="command" value="addBasicReportInfo" />
    <br/>Report name:<br/>
    <input type="text" name="reportName" value=""/>
    <br/>Report theses:<br/>
    <input type="text" name="reportTheses" value=""/>
    <br/>
    <input type="submit" value="Add report" formmethod="post" formaction="controller"/>
</form>
