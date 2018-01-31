<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2018
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="userId" value="${userId}"/>
<c:if test="${not empty userId}">
    <div class="usermenu">
        <ul>
            <li><a href="controller?command=viewprofileinfo">My profile</a></li>
            <li><a href="controller?command=viewuserreports">My reports</a></li>
            <li><a href="controller?command=viewuserincomingmessages">Messages</a></li>
        </ul>
    </div>
</c:if>

