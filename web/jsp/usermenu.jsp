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
<c:set var="role" value="${role}"/>
<c:if test="${not empty userId}">

    <li><a href="controller?command=viewprofileinfo"><fmt:message key="usermenu.text.myprofile"/></a></li>
    <li><a href="controller?command=viewuserreports"><fmt:message key="usermenu.text.myreports"/></a></li>
    <li><a href="controller?command=viewuserincomingmessages"><fmt:message key="usermenu.text.messages"/></a></li>
    <c:if test="${role == 'ADMIN'}">
        <li><a href="controller?command=viewusers"><fmt:message key="usermenu.text.users"/></a></li>
        <li><a href="controller?command=addconference"><fmt:message key="usermenu.text.addconference"/></a></li>
        <li><a href="controller?command=addsection"><fmt:message key="usermenu.text.addsection"/></a></li>
    </c:if>

</c:if>

