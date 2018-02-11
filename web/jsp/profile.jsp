<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 29.01.2018
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3><fmt:message key="profile.text.profile"/></h3>
    <div>
        <table>
            <tr>
                <th><fmt:message key="profile.text.login"/></th>
                <td>${login}</td>
            </tr>
            <tr>
                <th><fmt:message key="profile.text.email"/></th>
                <td>${email}</td>
            </tr>
            <tr>
                <th><fmt:message key="profile.text.role"/></th>
                <td>${role}</td>
            </tr>
            <tr>
                <th><fmt:message key="profile.text.phonenumber"/></th>
                <td>${phoneNumber}</td>
            </tr>
            <tr>
                <th><fmt:message key="profile.text.avatar"/></th>
                <td>${avatar}</td>
            </tr>
            <tr>
                <th><fmt:message key="profile.text.firstname"/></th>
                <td>${firstName}</td>
            </tr>
            <tr>
                <th><fmt:message key="profile.text.lastname"/></th>
                <td>${lastName}</td>
            </tr>
            <tr>
                <th><fmt:message key="profile.text.surname"/></th>
                <td>${surname}</td>
            </tr>
        </table>
        <form>
            <input type="hidden" name="command" value="changeprofileinfo"/>
            <input type="submit" value=<fmt:message key="profile.text.change"/> formmethod="get" formaction="controller"/>
        </form>
    </div>
</div>
</body>
</html>
