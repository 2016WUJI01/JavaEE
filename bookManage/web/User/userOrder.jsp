<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/11
  Time: 13:43
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
<tr>
    <td><a href="${pageContext.request.contextPath}/UserBookListServlet">图书列表</a></td>
    <td><a href="${pageContext.request.contextPath}/UserOrderServlet">用户管理</a></td>
    <td><a href="${pageContext.request.contextPath}/User/userSearchBook.jsp">搜索</a></td>
</tr>
<table class="table table-hover table-bordered">
    <tr>
        <td colspan="7"></td>
    </tr>
    <tr>
        <td>#</td>
        <td>订单id</td>
        <td>借书用户id</td>
        <td>书籍id</td>
        <td>数量</td>
        <td>日期</td>
        <td>状态</td>
    </tr>
    <c:forEach var="userBookorder" items="${userbookorders}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${userBookorder.id}</td>
            <td>${userBookorder.userid}</td>
            <td>${userBookorder.bookid}</td>
            <td>${userBookorder.number}</td>
            <td>${userBookorder.date}</td>
            <td>${userBookorder.situation}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
