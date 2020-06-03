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

<script>
    <!--
    function check_admin(form)
    {
        if(form.pname.value=="")
        {
            alert("请输入部门名称!");
            form.pname.focus();
            return false;
        }
        if(form.pcontent.value=="")
        {
            alert("请输入详细信息!");
            form.pcontent.focus();
            return false;
        }

    }

    -->
</script>
<div class="bg-info py-2 text-light">
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:部门管理 &nbsp;>&nbsp;添加部门
</div>
<center>
    <div class="container mt-2">
        <div class="sign-content  py-5 px-5 border" style=" background: #0c5460 ">
            <form action="/department/insert" method="post" onSubmit="return check_admin(this);" >
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">

                            <div class="form-group">
                                <input type="text" class="form-control text-light"  id="pname" name="pname" placeholder="请输入部门名称" >
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light" id="pcontent" name="pcontent" placeholder="请输入详细信息">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="signin-footer">
                            <button type="submit" class="btn btn-primary btn-block"  onclick="check_admin()">
                                添加
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
