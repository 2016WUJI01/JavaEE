<%@ page import="cn.itcast.User" %><%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/21
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果提示</title>
</head>
<body>
<div align="center">
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        if (!user.getUsername().equals("") && !user.getPassword().equals("")) {
            out.print("恭喜您，登陆成功！");
        } else {
            out.print("请输入正确的用户名和密码！");
        }
    %>
    <br><br>
    <a href="index.jsp">返回</a>
</div>
</body>
</html>
