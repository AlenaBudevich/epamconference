<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 22.01.2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Registration</title></head>
<body>
<a href="controller?command=login">LoginPage</a>
<a href="controller?command=viewallconferences">MainPage</a>
<br>
<form name="registrationForm">
    <input type="hidden" name="command" value="registration" />
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>Email:<br/>
    <input type="text" name="email" value=""/>
    <br/>
    <input type="submit" value="Registration" formmethod="post" formaction="controller"/>
</form><hr/>
</body></html>
