<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.02.2018
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update section info</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3><fmt:message key="updatesection.text.updatesection"/></h3>
    <form name="updateSectionInfoForm" onsubmit="return validateUpdateSectionForm()">
        <input type="hidden" name="command" value="updatesectioninfo"/>
        <input type="hidden" name="sectionId" value="${section.sectionId}"/>
        <label for="sectionname"><fmt:message key="updatesection.label.sectionname"/>:</label>
        <input type="text" id="sectionname" name="sectionName" value="${section.sectionName}"/>
        <label for="maxnumberreports"><fmt:message key="updatesection.label.maxnumberreports"/>:</label>
        <input type="number" id="maxnumberreports" name="maxNumberReports" value="${section.maxNumberReports}"/>
        <label for="sectionbeginning"><fmt:message key="updatesection.label.sectionbeginning"/>:</label>
        <input type="datetime" id="sectionbeginning" name="sectionBeginning" value="${section.sectionBeginning}"/>
        <label for="sectionend"><fmt:message key="updatesection.label.sectionend"/>:</label>
        <input type="datetime" id="sectionend" name="sectionEnd" value="${section.sectionEnd}"/>
        <label for="sectionaddress"><fmt:message key="updatesection.label.sectionaddress"/>:</label>
        <input type="text" id="sectionaddress" name="sectionAddress" value="${section.sectionAddress}"/>
        <label for="sectioncontent"><fmt:message key="updatesection.label.sectioncontent"/>:</label>
        <input type="text" id="sectioncontent" name="sectionContent" value="${section.sectionContent}"/>
        <label><fmt:message key="updatesection.label.sectionstatus"/>:</label>
        <select name="sectionStatus">
            <option value="RECRUITED">RECRUITED</option>
            <option value="ACCEPTED">ACCEPTED</option>
            <option value="RUNNING">RUNNING</option>
            <option value="COMPLETED">COMPLETED</option>
        </select>
        <br>
        <input class="button-primary" type="submit" value=<fmt:message key="updatesection.text.updatesection"/> formmethod="post" formaction="controller"/>
    </form>
</div>
</body>
</html>
