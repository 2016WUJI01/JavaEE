<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/6
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<br><br><br>
<form action="${pageContext.request.contextPath}/InsBookServlet" method="post">
    <table align="center" class="border">
        <tr>
            <td colspan="2" align="center">插入数据</td>
        </tr>
        <tr>
            <td>Bookname:</td>
            <td><input type="text" name="bookname"></td>
        </tr>
        <tr>
            <td>Reserve:</td>
            <td><input type="text" name="reserve"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
