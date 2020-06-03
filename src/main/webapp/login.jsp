<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/26
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>人事系统登入</title>
<link rel="shortcut icon" type="image/icon" href="logo/w.png" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body  style=" background: #9fcdff">
<div class="container" style="padding-top: 100px;">
    <div class="sign-content  py-5 px-5 border" style=" background:#0c5460 ">
        <h2 style="color: white">登陆人事系统</h2>
        <form action="/user1/login" method="post">
            <div class="row">
                <div class="col-sm-12">
                    <div class="signin-form">

                        <div class="form-group">
                            <label for="uname" class="text-light">账户</label>
                            <input type="text" class="form-control text-light"  id="uname" name="uname" placeholder="请输入账户" required>
                        </div>
                        <div class="form-group">
                            <label for="upassword"  class="text-light">密码</label>
                            <input type="password" class="form-control text-light" id="upassword" name="upassword" placeholder="请输入密码" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="signin-footer">
                        <button type="submit" class="btn btn-primary btn-block">
                            登陆
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
