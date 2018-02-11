<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.02.2018
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add section</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3><fmt:message key="addsection.text.addsection"/></h3>
    <form name="addSectionForm" onsubmit="return validateAddSectionForm()">
        <input type="hidden" name="command" value="addsection"/>
        <label for="conferencename"><fmt:message key="addsection.label.conferencename"/>:</label>
        <input type="text" id="conferencename" name="conferenceName" value=""/>
        <label for="sectionname"><fmt:message key="addsection.label.sectionname"/>:</label>
        <input type="text" id="sectionname" name="sectionName" value=""/>
        <br/>
        <input class="button-primary" type="submit" value=<fmt:message key="addsection.text.addsection"/> formmethod="post" formaction="controller"/>
    </form>
</div>
</body>
</html>
