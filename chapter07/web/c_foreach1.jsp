<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/16
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
<% String[] fruits = {"apple", "orange", "grape", "banana"};%>
String数组中的元素：<br>
<c:forEach var="name" items="<%=fruits%>">${name}<br></c:forEach>
<% Map userMap = new HashMap();
    userMap.put("Tom", "123");
    userMap.put("Lina", "123");
    userMap.put("Make", "123");%>
<hr>
HashMap集合中的元素：
<br>
<c:forEach var="entry" items="<%=userMap%>">${entry.key}&nbsp;${entry.value}<br></c:forEach>
</body>
</html>
