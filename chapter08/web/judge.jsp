<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/21
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="username" class="cn.itcast.Username" scope="page">
    <jsp:setProperty name="username" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>验证反馈界面</title>
</head>
<body>
<ul style="font-size: 20px;">
    <li>输入的用户名为：
        <jsp:getProperty property="username" name="username"/>
    </li>
    <li>&nbsp;&nbsp;&nbsp;是否有效：
        <jsp:getProperty property="isval" name="username"/>
    </li>
    <li>&nbsp;&nbsp;&nbsp;提示信息：
        <jsp:getProperty property="tip" name="username"/>
    </li>
</ul>
</body>
</html>
