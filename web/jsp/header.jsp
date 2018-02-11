<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.01.2018
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="application"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navcont">
    <div class="nav">
        <ul>
            <li>
                <a class="active" href="../index.jsp"><fmt:message key="header.text.conference"/></a>
            </li>
            <%@include file="usermenu.jsp" %>
            <c:set var="userId" value="${userId}"/>
            <c:if test="${not empty userId}">
                <li>
                    <a href="controller?command=logout"><fmt:message key="header.text.logout"/></a>
                </li>
            </c:if>
            <c:if test="${empty userId}">
                <li>
                    <a href="controller?command=login"><fmt:message key="header.text.login"/></a>
                </li>
                <li>
                    <a href="controller?command=registration"><fmt:message key="header.text.registration"/></a>
                </li>
            </c:if>
        </ul>
    </div>
</div>
