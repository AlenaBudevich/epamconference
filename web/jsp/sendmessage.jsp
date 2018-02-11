<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/validation.js"></script>
<form name="sendMessageForm" onsubmit="return validateSendMessageForm()">
    <input type="hidden" name="command" value="sendMessage" />
    <label for="userlogin"><fmt:message key="sendmessage.label.userlogin"/>:</label>
    <input type="text" id="userlogin" name="login" value=""/>
    <label for="messagetext"><fmt:message key="sendmessage.label.messagetext"/>:</label>
    <input type="text" id="messagetext" name="messageText" value=""/>
    <label for="messagecontent"><fmt:message key="sendmessage.label.messagecontent"/>:</label>
    <input type="text" id="messagecontent" name="messageContent" value=""/>
    <br/>
    <input class="button-primary" type="submit" value=<fmt:message key="sendmessage.text.send"/> formmethod="post" formaction="controller"/>
</form>
