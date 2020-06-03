<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/29
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css"/>
<body>
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<style type="text/css">
    <!--
    #a{
        margin-top:10%;
    }
    .STYLE1 {
        font-size: 12px;
    }
    .STYLE2 {
        font-size: 14px;
        color: #333333;
    }
    .STYLE4 {
        font-size: 24px;
        color: #FF0000;
        font-family: "创艺简行楷";
    }
    -->
</style>

<script>
var flag=false;
    function selectByname() {
        var uname=$("#uname").val();
        if(uname!=null && uname != ""){
        $.post("/user1/selectByname",{uname:uname},function (r) {
            if(!r){
                alert("该用户名已存在！！");
                flag=true;
            }
        })
        }
    }
    function check_admin(form)
    {
        if(flag){
            alert("该用户名已存在！！");
            return false;
        }
        if(form.uname.value=="")
        {
            alert("请输入管理员账号!");
            form.uname.focus();
            return false;
        }
        if(form.upassword1.value=="")
        {
            alert("请输入管理员密码!");
            form.upassword.focus();
            return false;
        }
        if(form.upassword1.value!=form.upassword.value)
        {
            alert("密码两次输入不正确!");
            form.upassword1.focus();
            return false;
        }


    }

</script>
<div class="bg-info py-2 text-light">
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:用户管理 &nbsp;>&nbsp;添加用户
</div>
<center>
    <div class="container mt-2">
        <div class="sign-content  py-5 px-5 border" style=" background: #0c5460 ">
            <form action="/user1/insert" method="post" onSubmit="return check_admin(this);" >
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">

                            <div class="form-group">
                                <input type="text" class="form-control text-light"  id="uname" name="uname" placeholder="请输入用户名" onblur="selectByname()" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light" id="upassword" name="upassword" placeholder="请输入密码" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light" id="upassword1" name="upassword1" placeholder="请确定密码" required>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="signin-footer">
                            <button type="submit" class="btn btn-primary btn-block"  onclick="check_admin()">
                               注册
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

</center>
</body>
</html>
