<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/16
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${empty param.username}">unKnow user.</c:when>
    <c:when test="${param.username =='itcast'}">${param.username} is manager.</c:when>
    <c:otherwise>${param.username} is employee.</c:otherwise>
</c:choose>
</body>
</html>
