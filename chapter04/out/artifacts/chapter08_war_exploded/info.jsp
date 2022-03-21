<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/21
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="book" class="cn.itcast.Book" scope="page">
    <jsp:setProperty name="book" property="*"></jsp:setProperty>
</jsp:useBean>
<table align="center" width="400">
    <tr>
        <td align="center">名称：
            <jsp:getProperty name="book" property="bookName"/>
        </td>
    </tr>
    <tr>
        <td align="center">价格：
            <jsp:getProperty name="book" property="price"/>
        </td>
    </tr>
    <tr>
        <td align="center">作者：
            <jsp:getProperty name="book" property="author"/>
        </td>
    </tr>
</table>

</body>
</html>
