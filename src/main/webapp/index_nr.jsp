<%@ page import="com.entity.User1" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/27
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内容</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css"/>
<script src="/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<body>

<div class="bg-info py-2 text-light">
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:后台管理 &nbsp;>&nbsp;当前用户
</div>
<table style="width: 100% " class="table border-bottom table-info">
<%
    String str;
    ObjectMapper objectMapper = new ObjectMapper();
    User1 u= objectMapper.readValue(session.getAttribute("user1")+"",User1.class);
%>
    <tr>
        <td>用户姓名：<span style="color: red"><%=u.getUname() %></span></td>
    </tr>
    <%if(u.getUsend()==1 || u.getUsend()==2){str="已审核";}else {
        str="未审核";
    }%>
    <tr>
        <td>用户状态：<span style="color: red"><%=str%></span></td>
    </tr>
    <tr>
        <td>创建时间：<span style="color: red"><%=u.getUtime() %></span></td>
    </tr>
</table>
</body>
</html>
