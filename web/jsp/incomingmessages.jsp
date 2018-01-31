<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Incoming Messages</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<h1>${login}'s incoming messages</h1>
<br>
<%@include file="messagemenu.jsp" %>
<br>
<c:set var="messages" value="${messages}"/>
<c:if test="${not empty messages}">
    <div>
        <table>
            <c:forEach items="${messages}" var="current">
                <tr>
                    <td><c:out value="${current.messageTime}"/></td>
                    <td><c:out value="${current.messageText}"/></td>
                    <td><c:out value="${current.messageContent}"/></td>
                    <c:url value="controller?command=deletemessage" var="deleteMessage">
                        <c:param name="messageId" value="${current.messageId}"/>
                    </c:url>
                    <td><a href=${deleteMessage}>Delete message</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<br>
<%@include file="usermenu.jsp" %>
</body>
</html>
