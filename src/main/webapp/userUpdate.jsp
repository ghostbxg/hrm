<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/29
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户资料</title>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
<body>

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
        if(form.upassword.value=="")
        {
            alert("请输入管理员密码!");
            form.upassword.focus();
            return false;
        }
        if(form.usend.value==""){
            alert("请输入审核状态")
            form.usend.focus();
            return false;
        }

    }

</script>
<div class="bg-info py-2 text-light" >
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:用户管理 &nbsp;>&nbsp;修改用户
</div>
<center>
    <div class="container mt-2">
        <div class="sign-content  py-5 px-5 border" style=" background: #0c5460 ">
            <form action="/user1/update" method="post" onSubmit="return check_admin(this);" >
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">

                            <div class="form-group">
                                <input type="text" class="form-control text-light"  id="uname" name="uname" placeholder="请输入用户名" onblur="selectByname()" required>
                                <input type="hidden" class="form-control text-light"  id="uid" name="uid">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light" id="upassword" name="upassword" placeholder="请输入密码" required>
                            </div>
                            <div class="form-group">
                                <select name="usend" id="usend" class="form-control text-light" style=" background: #0c5460 " >
                                    <option value="3">普通用户（未审核）</option>
                                    <option value="1">超级管理员（已审核，拥有所有权限）</option>
                                    <option value="2">管理员（已审核，拥有除用户管理的其他权限）</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light" id="utime" name="utime" placeholder="创建时间" readonly>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="signin-footer">
                            <button type="submit" class="btn btn-primary btn-block" name="submit1" onclick="check_admin()">
                                修改
                            </button>
                            <button type="button" class="btn btn-danger btn-block" name="submit2">
                               返回
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        var m = parent.admin
            $("#uid").val(m.uid);
            $("#uname").val(m.uname);
            $("#upassword").val(m.upassword);
            $("#utime").val(m.utime);
            $("#usend").val(m.usend);
            if(m.usend==1){
                $("#usend").innerHTML="超级管理员（已审核，拥有所有权限）"
            }else if(m.usend==2){
                $("#usend").innerHTML="管理员（已审核，拥有除用户管理的其他权限）"
            }else if(m.usend==3){
                $("#usend").innerHTML="普通用户（未审核）"
            }



        $("[name=submit2]").click(function() {
            parent.location.reload()

        })
        $("[name=submit1]").click(function() {
            parent.location.reload()

        })

    </script>
</center>
</body>
</html>
