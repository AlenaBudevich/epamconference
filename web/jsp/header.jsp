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
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navcont">
    <div class="nav">
        <ul>
            <li>
                <a class="active" href="controller?command=viewallconferences">CONFERENCE</a>
            </li>
            <%@include file="usermenu.jsp" %>
            <c:set var="userId" value="${userId}"/>
            <c:if test="${not empty userId}">
                <li>
                    <a href="controller?command=logout">LOG OUT</a>
                </li>
            </c:if>
            <c:if test="${empty userId}">
                <li>
                    <a href="controller?command=login">LOG IN</a>
                </li>
                <li>
                    <a href="controller?command=registration">REGISTRATION</a>
                </li>
            </c:if>

            <%--<li class="drop">--%>
            <%--<a href="#">ABOUT</a>--%>

            <%--<div class="dropdownContain">--%>
            <%--<div class="dropOut">--%>

            <%--<ul>--%>
            <%--<li>ABOUT ME</li>--%>
            <%--<li>ABOUT ME</li>--%>
            <%--<li>ABOUT ME</li>--%>
            <%--<li>ABOUT ME</li>--%>
            <%--</ul>--%>
            <%--</div>--%>
            <%--</div>--%>

            <%--</li>--%>

        </ul>
    </div>
</div>


<%--<form >--%>
<%--<select id="language" name="language" onchange="submit()">--%>
<%--<option value="ru" ${language == 'ru' ? 'selected' : ''}>RU</option>--%>
<%--<option value="en" ${language == 'en' ? 'selected' : ''}>EN</option>--%>
<%--</select>--%>
<%--</form>--%>

<br>