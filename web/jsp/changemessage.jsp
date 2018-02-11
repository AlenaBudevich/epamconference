<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/validation.js"></script>
<h3><fmt:message key="changemessage.text.changemessage"/></h3>
<form name="changeMessageForm" onsubmit="return validateChangeMessageForm()">
    <input type="hidden" name="command" value="changeMessage" />
    <input type="hidden" name="messageId" value="${message.messageId}" />
    <label for="messagetext"><fmt:message key="changemessage.label.messagetext"/>:</label>
    <input type="text" id="messagetext" name="messageText" value="${message.messageText}"/>
    <label for="messagecontent"><fmt:message key="changemessage.label.messagecontent"/>:</label
    <input type="text" id="messagecontent" name="messageContent" value="${message.messageContent}"/>
    <br/>
    <input class="button-primary" type="submit" value=<fmt:message key="changemessage.text.changemessage"/> formmethod="post" formaction="controller"/>
</form>
