<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Outgoing messages</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<%@include file="header.jsp" %>
<br>
<h1>${login}'s outgoing messages</h1>
<br>
<%@include file="messagemenu.jsp" %>
<div class="row" align="center">
    <c:set var="sendMessage" value="${sendMessage}"/>
    <c:if test="${not empty sendMessage}">
        <%@include file="sendmessage.jsp" %>
    </c:if>
    <br>
    <c:set var="changeMessage" value="${changeMessage}"/>
    <c:if test="${not empty changeMessage}">
        <%@include file="changemessage.jsp" %>
    </c:if>
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
                        <td>
                            <form>
                                <input type="hidden" name="command" value="changemessage"/>
                                <input type="hidden" name="messageId" value="${current.messageId}"/>
                                <input type="submit" value="Change" formmethod="get" formaction="controller"/>
                            </form>
                        </td>
                        <td>
                            <form>
                                <input type="hidden" name="command" value="deletemessage"/>
                                <input type="hidden" name="messageId" value="${current.messageId}"/>
                                <input type="submit" value="Delete" formmethod="get" formaction="controller"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
<%@include file="usermenu.jsp" %>
</body>
</html>
