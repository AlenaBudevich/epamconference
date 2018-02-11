<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.01.2018
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="row" align="center">
    <h3><fmt:message key="users.text.users"/></h3>
    <c:set var="changeId" value="${changeId}"/>
    <c:set var="users" value="${users}"/>
    <c:if test="${not empty users}">
        <div>
            <table>
                <tr>
                    <th><fmt:message key="users.text.login"/></th>
                    <th><fmt:message key="users.text.email"/></th>
                    <th><fmt:message key="users.text.phonenumber"/></th>
                    <th><fmt:message key="users.text.avatar"/></th>
                    <th><fmt:message key="users.text.firstname"/></th>
                    <th><fmt:message key="users.text.lastname"/></th>
                    <th><fmt:message key="users.text.surname"/></th>
                    <th><fmt:message key="users.text.role"/></th>
                </tr>
                <c:forEach items="${users}" var="current">
                    <tr>
                        <td><c:out value="${current.login}"/></td>
                        <td><c:out value="${current.email}"/></td>
                        <td><c:out value="${current.phoneNumber}"/></td>
                        <td><c:out value="${current.avatar}"/></td>
                        <td><c:out value="${current.firstName}"/></td>
                        <td><c:out value="${current.lastName}"/></td>
                        <td><c:out value="${current.surname}"/></td>
                        <c:set var="currentId" value="${current.userId}"/>

                        <c:if test="${changeId != currentId}">
                            <td><c:out value="${current.role}"/></td>
                            <td>
                                <form>
                                    <input type="hidden" name="command" value="assignuserrole"/>
                                    <input type="hidden" name="changeId" value="${current.userId}"/>
                                    <input type="submit" value=<fmt:message key="users.text.changerole"/> formmethod="get" formaction="controller"/>
                                </form>
                            </td>
                        </c:if>

                        <c:if test="${changeId == currentId}">

                            <form name="roleForm">
                                <input type="hidden" name="command" value="assignUserRole"/>
                                <td>
                                    <select name="role">
                                        <option value="USER">USER</option>
                                        <option value="REVIEWER">REVIEWER</option>
                                        <option value="ADMIN">ADMIN</option>
                                        <option value="BANNED">BANNED</option>
                                    </select>
                                </td>
                                <td>
                                    <input type="hidden" name="userId" value="${currentId}"/>
                                    <input type="submit" value=<fmt:message key="users.text.changerole"/> formmethod="post" formaction="controller"/>
                                </td>
                            </form>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>