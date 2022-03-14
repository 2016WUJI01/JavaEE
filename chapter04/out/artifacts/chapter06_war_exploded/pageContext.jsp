<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/14
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pagecontext</title>
</head>
<body>
<%
    HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
    pageContext.setAttribute("str", "Java", pageContext.PAGE_SCOPE);
    req.setAttribute("str", "Java web");
    String str1 = (String) pageContext.getAttribute("str", pageContext.PAGE_SCOPE);
    String str2 = (String) pageContext.getAttribute("str", pageContext.REQUEST_SCOPE);
%>
<%="page范围：" + str1%>
<br>
<%="request范围：" + str2%>
<br>
</body>
</html>
