<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/validation.js"></script>
<h1>Update report info</h1>
<form name="changeMessageForm" onsubmit="return validateChangeMessageForm()">
    <input type="hidden" name="command" value="changeMessage" />
    <input type="hidden" name="messageId" value="${message.messageId}" />
    <br/>Message text:<br/>
    <input type="text" name="messageText" value="${message.messageText}"/>
    <br/>Message content:<br/>
    <input type="text" name="messageContent" value="${message.messageContent}"/>
    <br/>
    <input type="submit" value="Change message" formmethod="post" formaction="controller"/>
</form>
