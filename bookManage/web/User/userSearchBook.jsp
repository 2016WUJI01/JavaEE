<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/11
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Title</title>
</head>
<body>
<p align="center">图&nbsp;&nbsp;&nbsp;书&nbsp;&nbsp;&nbsp;信&nbsp;&nbsp;&nbsp;息&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理</p>
<form action="${pageContext.request.contextPath}/SearchBookServlet" method="post">
    <table align="center" class="border">
        <tr>
            <td colspan="2" align="center">搜索书籍</td>
        </tr>
        <tr>
            <td>Bookname:</td>
            <td><input type="text" name="searchname" id="searchname"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
</body>
</html>