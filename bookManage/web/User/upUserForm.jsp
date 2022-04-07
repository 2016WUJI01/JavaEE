<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/6
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<br><br><br>
<form action="${pageContext.request.contextPath}/UpUserServlet?id=${user.id}" method="post">
    <table align="center" class="border">
        <tr>
            <td colspan="2" align="center">修改数据</td>
        </tr>
        <tr>
            <td>Id:</td>
            <td><input type="text" value="${user.id}" disabled></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" value="${user.username}"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>

</body>
</html>
