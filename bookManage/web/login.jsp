<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/4/10
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div>
    <div>图书管理系统</div>
    <div>
        <form action="${pageContext.request.contextPath}/AdminLoginServlet" method="post">
            <table align="center" class="border">
                <tr>
                    <td colspan="2" align="center">请输入账号密码</td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
