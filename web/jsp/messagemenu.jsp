<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="messagemenu">
    <ul>
        <li><a href="controller?command=sendmessage"><fmt:message key="messagemenu.text.newmessage"/></a></li>
        <li><a href="controller?command=viewuserincomingmessages"><fmt:message key="messagemenu.text.incomingmessages"/></a></li>
        <li><a href="controller?command=viewuseroutgoingmessages"><fmt:message key="messagemenu.text.outgoingmessages"/></a></li>
    </ul>
</div>