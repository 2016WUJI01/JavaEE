<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/9
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP声明语句</title>
</head>
<body>
<%! public int print() {
    int a = 1, b = 2;
    return a + b;
}%>
</body>
<br>
<%out.println(print()); %>
</html>
