<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/16
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
使用绝对路径构造URL：<br>
<c:url var="myURL" value="http://localhost:8080/chapter07/c_out1.jsp"><c:param name="username" value="张三"></c:param>
</c:url>
<a href="${myURL}">c_out1.jsp</a><br>
使用相对路径构造URL：<br>
<c:url var="myURL" value="c_out1.jsp?username=Tom"/>
<a href="${myURL}">c_out1.jsp</a><br>
</body>
</html>
