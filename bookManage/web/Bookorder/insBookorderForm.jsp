<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/7
  Time: 14:54
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
<form action="${pageContext.request.contextPath}/InsBookorderServlet" method="post">
    <table align="center" class="border">
        <tr>
            <td colspan="2" align="center">插入数据</td>
        </tr>
        <tr>
            <td>userid:</td>
            <td><input type="text" name="userid"></td>
        </tr>
        <tr>
            <td>Bookid:</td>
            <td><input type="text" name="bookid"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
