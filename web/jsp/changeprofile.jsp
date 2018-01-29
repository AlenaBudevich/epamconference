<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 29.01.2018
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change profile info</title>
</head>
<body>
<h1>Change profile info</h1>
<a href="controller?command=viewallconferences">MainPage</a>
<a href="controller?command=viewprofileinfo">My profile</a>
<br>
<form name="changeProfileInfoForm">
    <input type="hidden" name="command" value="changeProfileInfo" />
    <br/>Email:<br/>
    <input type="text" name="email" value="${email}"/>
    <br/>Phone number:<br/>
    <input type="text" name="phoneNumber" value="${phoneNumber}"/>
    <br/>Avatar:<br/>
    <input type="text" name="avatar" value="${avatar}"/>
    <br/>First Name:<br/>
    <input type="text" name="firstName" value="${firstName}"/>
    <br/>Last Name:<br/>
    <input type="text" name="lastName" value="${lastName}"/>
    <br/>Surname:<br/>
    <input type="text" name="surname" value="${surname}"/>
    <br/>
    <input type="submit" value="Change info" formmethod="post" formaction="controller"/>
</form>
</body>
</html>
