<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/21
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="email" class="cn.itcast.Email"></jsp:useBean>
<jsp:useBean id="encoding" class="cn.itcast.CharactorEncoding"></jsp:useBean>
<jsp:setProperty name="email" property="*"></jsp:setProperty>
<div align="center">
    <div id="container">
        <div class="title"><%=encoding.toString(email.getTitle())%>
        </div>
        <hr>
        <div id="content"><%=encoding.toString(email.getContent())%>
        </div>
    </div>
</div>
</body>
</html>
