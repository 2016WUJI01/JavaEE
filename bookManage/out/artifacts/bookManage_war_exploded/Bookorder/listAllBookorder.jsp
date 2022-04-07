<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/6
  Time: 13:05
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
<p align="center">图&nbsp;&nbsp;&nbsp;书&nbsp;&nbsp;&nbsp;信&nbsp;&nbsp;&nbsp;息&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理</p>
<table class="table table-hover table-bordered">
    <tr>
        <td colspan="7"></td>
        <td>
            <a href="${pageContext.request.contextPath}/Bookorder/insBookorderForm.jsp">添加书籍</a>
        </td>
    </tr>
    <tr>
        <td>#</td>
        <td>订单id</td>
        <td>管理员id</td>
        <td>借书用户id</td>
        <td>书籍id</td>
        <td>数量</td>
        <td>日期</td>
        <td>状态</td>
    </tr>
    <c:forEach var="bookorder" items="${bookorders}" varStatus="vs">

        <tr>
            <td>${vs.count}</td>
            <td>${bookorder.id}</td>
            <td>${bookorder.adminid}</td>
            <td>${bookorder.userid}</td>
            <td>${bookorder.bookid}</td>
            <td>${bookorder.number}</td>
            <td>${bookorder.date}</td>
            <td>${bookorder.situation}</td>
            <td><a href="${pageContext.request.contextPath}/FindBookorderByIdServlet?id=${bookorder.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/DelBookorderServlet?id=${bookorder.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
