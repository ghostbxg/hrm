<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/31
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
        if(form.sname.value=="")
        {
            alert("请输入员工名!");
            form.sname.focus();
            return false;
        }
        if(form.sphonenumber.value=="")
        {
            alert("请输入电话号码!");
            form.sphonenumber.focus();
            return false;
        }else if(form.sphonenumber.value.length!=11){
            alert("请输入正确的电话号码!");
            form.sphonenumber.focus();
            return false;
        }

        if(form.ssex.value=="")
        {
            alert("请选择性别!");
            form.ssex.focus();
            return false;
        }

        if(form.semail.value=="")
        {
            alert("请输入邮箱，格式：xxxxxx@qq.com!");
            form.semail.focus();
            return false;
        }else{
            var t=/^([a-zA-Z0-9_\.\-])+\@[a-zA-Z0-9_\.\-]
            if(!t.test(form.semail.value)){
                alert("邮箱格式错误，格式：xxxxxx@qq.com!");
                form.semail.focus();
                return false;
            }
        }
        if(form.jid.value=="")
        {
            alert("请选择职业!");
            form.jid.focus();
            return false;
        }
        if(form.sidnumber.value=="")
        {
            alert("请输入身份证号!");
            form.sidnumber.focus();
            return false;
        }

        if(form.pid.value=="")
        {
            alert("请选择部门!");
            form.pid.focus();
            return false;
        }
        if(form.sadress.value=="")
        {
            alert("请输入联系地址!");
            form.sadress.focus();
            return false;
        }
    }

    -->
</script>
<div class="bg-info py-2 text-light">
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:员工管理 &nbsp;>&nbsp;添加员工
</div>
<center>
    <div class="container mt-2">
        <div class="sign-content  py-5 px-5 border" style=" background: #0c5460 ">
            <form action="/staff/insert" method="post" onSubmit="return check_admin(this);" >
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">

                            <div class="form-group">
                                <input type="text" class="form-control text-light"  name="sname" placeholder="请输入员工名" required>
                            </div>
                            <div class="form-group">
                                <select name="ssex" class="form-control mr-sm-2 text-light" style=" background: #0c5460 " required>
                                    <option value="" >---请选择性别---</option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light"  name="sphonenumber" placeholder="请输入手机号码" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light"  name="semail" placeholder="请输入邮箱，格式：xxxxxx@qq.com" required>
                            </div>
                            <c:if test="${empty flag}">
                                <c:if test="${empty joblist}">
                                    <c:redirect url="/job/insertSelect"></c:redirect>
                                </c:if>
                            </c:if>
                            <div class="form-group">
                                <select name="jid" class="form-control mr-sm-2 text-light " style=" background: #0c5460 " required>
                                    <option value="" >---请选择职业---</option>
                                    <c:if test="${flag}"><option value="">无职业</option></c:if>
                                    <c:if test="${!flag}">
                                        <c:forEach items="${joblist}" var="c" >
                                    <option value="${c.jid}">${c.jname}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                            <div class="form-group">
                                <select name="seduction" class="form-control mr-sm-2 text-light"   style=" background: #0c5460 " required>
                                    <option value="" >---请选择学历---</option>
                                    <option value="本科">本科</option>
                                    <option value="专科">专科</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light" name="sidnumber" placeholder="请输入身份证号" required>
                            </div>
                            <div class="form-group">
                                <select name="pid" class="form-control mr-sm-2 text-light " style=" background: #0c5460 " required>
                                    <option value="" >---请选择部门---</option>
                                 <c:if test="${flag1}"><option value="">无部门</option></c:if>
                                 <c:if test="${!flag1}">
                                     <c:forEach items="${deptlist}" var="c" >
                                         <option value="${c.pid}">${c.pname}</option>
                                     </c:forEach>
                                 </c:if>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control text-light" name="sadress" placeholder="请输入联系地址" required>
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