<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.entity.User1" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/29
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改公告</title>
</head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css"/>
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
    <!--
    function check_admin(form)
    {

        if(form.aname.value=="")
        {
            alert($("#uid").innerHTML)
            alert("请输入公告名称!");
            form.aname.focus();
            return false;
        }
        if(form.acontent.value=="")
        {
            alert("请输入公告内容!");
            form.acontent.focus();
            return false;
        }

    }

    -->
</script>

<div class="bg-info py-2 text-light" style="margin-top: 200px">
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:公告管理 &nbsp;>&nbsp;修改公告
</div>
<center>
    <div class="container mt-2">
        <div class="sign-content  py-5 px-5 border" style=" background: #0c5460 ">
            <form action="/announcement/update" method="post" onSubmit="return check_admin(this);" >
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">

                            <div class="form-group">
                               发布公告人 :<input type="text" style=" background: #0c5460 ;color: white;border: #0c5460 " id="uname" name="uname" readonly>
                                <input type="text" class="form-control text-light"  id="aname" name="aname" placeholder="请输入公告名称" required>

                            </div>
                            <div class="form-group">
                                <textarea id="acontent" name="acontent" class="form-control text-light" style="height: 300px"  placeholder="请输入公告内容" required></textarea>
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
        $("#uname").val(m.uname);
        $("#aname").val(m.aname);
        $("#acontent").val(m.acontent);


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
