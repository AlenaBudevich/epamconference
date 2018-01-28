<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 21.01.2018
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Login</title></head>
<body>
<form name="loginForm">
    <input type="hidden" name="command" value="login" />
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    <input type="submit" value="Log in" formaction="controller" formmethod="post"/>
    <input type="submit" value="Registration" formaction="controller" formmethod="get"/>
</form>
</body></html>


