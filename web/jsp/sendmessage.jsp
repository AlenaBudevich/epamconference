<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form name="sendMessageForm">
    <input type="hidden" name="command" value="sendMessage" />
    <br/>User login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Message text:<br/>
    <input type="text" name="messageText" value="null"/>
    <br/>Message content:<br/>
    <input type="text" name="messageContent" value=""/>
    <br/>
    <input type="submit" value="Send" formmethod="post" formaction="controller"/>
</form>
