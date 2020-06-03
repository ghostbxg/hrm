<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/27
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出登入</title>
</head>
<body>
<%
    session.invalidate();
%>
<meta http-equiv="refresh" content="0,url=login.jsp">
</body>
</html>
