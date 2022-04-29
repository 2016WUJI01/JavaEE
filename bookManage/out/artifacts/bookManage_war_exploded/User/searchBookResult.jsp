<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/12
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<p align="center">图&nbsp;&nbsp;&nbsp;书&nbsp;&nbsp;&nbsp;信&nbsp;&nbsp;&nbsp;息&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理</p>
<div><a href="${pageContext.request.contextPath}/User/userSearchBook.jsp">搜索</a></div>
<table class="table table-hover table-bordered">
    <tr>
        <td colspan="5"></td>

    </tr>
    <tr>
        <td>#</td>
        <td>书籍id</td>
        <td>书名</td>
        <td>出版社</td>
        <td>价格</td>
        <td>剩余数量</td>

    </tr>
    <c:forEach var="book" items="${searchbooks}" varStatus="vs">

        <tr>
            <td>${vs.count}</td>
            <td>${book.id}</td>
            <td>${book.bookname}</td>
            <td>${book.supplier}</td>
            <td>${book.price}</td>
            <td>${book.reserve}</td>
            <td><a href="${pageContext.request.contextPath}/InsBookorderServlet?bookid=${book.id}">借书</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>