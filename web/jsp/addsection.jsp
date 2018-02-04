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
</head>
<body>
<script src="js/validation.js"></script>
<%@include file="header.jsp" %>
<br>
<h1>Add section</h1>
<form name="addSectionForm" onsubmit="return validateAddSectionForm()">
    <input type="hidden" name="command" value="addsection" />
    Conference name:<br/>
    <input type="text" name="conferenceName" value=""/>
    <br/>Section name:<br/>
    <input type="text" name="sectionName" value=""/>
    <br/>
    <input type="submit" value="Add section" formmethod="post" formaction="controller"/>
</form>
<br>
<%@include file="usermenu.jsp" %>
</body>
</html>
