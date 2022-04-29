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
<tr>
    <td><a href="${pageContext.request.contextPath}/ListAllBookServlet">图书管理</a></td>
    <td><a href="${pageContext.request.contextPath}/ListAllUserServlet">用户管理</a></td>
    <td><a href="${pageContext.request.contextPath}/ListAllBookorderServlet">借书管理</a></td>
</tr>
<table class="table table-hover table-bordered">
    <tr>
        <td colspan="5"></td>
        <td>
            <a href="${pageContext.request.contextPath}/Book/insBookForm.jsp">添加书籍</a>
        </td>
    </tr>
    <tr>
        <td>#</td>
        <td>书籍id</td>
        <td>书名</td>
        <td>出版社</td>
        <td>价格</td>
        <td>剩余数量</td>

    </tr>
    <c:forEach var="book" items="${books}" varStatus="vs">

        <tr>
            <td>${vs.count}</td>
            <td>${book.id}</td>
            <td>${book.bookname}</td>
            <td>${book.supplier}</td>
            <td>${book.price}</td>
            <td>${book.reserve}</td>

            <td><a href="${pageContext.request.contextPath}/FindBookByIdServlet?id=${book.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/DelBookServlet?id=${book.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
