<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/21
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息添加</title>
</head>
<body>
<form action="info.jsp" method="post">
    <table align="center" width="400" height="200" border="1">
        <tr>
            <td align="center" colspan="2" height="40"><b>添加图书信息</b></td>
        </tr>
        <tr>
            <td align="center">名称：<input type="text" name="bookName"></td>
        </tr>
        <tr>
            <td align="center">价格：<input type="text" name="price"></td>
        </tr>
        <tr>
            <td align="center">作者：<input type="text" name="author"></td>
        </tr>
        <tr>
            <td align="center" colspan="2"><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
</body>
</html>
