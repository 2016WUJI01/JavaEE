<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/6
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Title</title>
</head>
<body>
<p align="center">用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;信&nbsp;&nbsp;&nbsp;息&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理</p>
<table class="table table-hover table-bordered">
    <tr>
        <td colspan="6"></td>
        <td>
            <a href="${pageContext.request.contextPath}/insUserForm.jsp">添加用户</a>
        </td>
    </tr>
    <tr>
        <td>#</td>
        <td>用户id</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td></td>
        <td></td>
        <td></td>

    </tr>
    <c:forEach var="user" items="${users}" varStatus="vs">

        <tr>
            <td>${vs.count}</td>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>.....</td>
            <td><a href="${pageContext.request.contextPath}/FindUserByIdServlet?id=${user.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/DelUserServlet?id=${user.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
