<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/29
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

<div class="bg-info py-2 text-light" style="margin-top: 150px" >
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:部门管理 &nbsp;>&nbsp;修改部门
</div>
<center>
    <div class="container mt-2">
        <div class="sign-content  py-5 px-5 border" style=" background: #0c5460 ">
            <form action="/job/update" method="post" onSubmit="return check_admin(this);" >
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">

                            <div class="form-group">
                                <input type="text" class="form-control text-light"  id="jname" name="jname" placeholder="请输入部门名称" required>
                                <input type="hidden" class="form-control text-light"  id="jid" name="jid">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light" id="jcontent" name="jcontent" placeholder="请输入详细信息" required>
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
        $("#jid").val(m.jid);
        $("#jname").val(m.jname);
        $("#jcontent").val(m.jcontent);


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
