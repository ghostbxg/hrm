<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/26
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人事管理后台系统</title>
    <link rel="shortcut icon" type="image/icon" href="/logo/w.png" />
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css"/>
    <script src="/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<c:if test="${empty user1}">
    <c:redirect url="/login.jsp"></c:redirect>

</c:if>
<nav class="navbar navbar-expand-lg  " style="background-color: #0c5460;">
    <span class="navbar-brand text-light">人事管理后台系统</span>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">



        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <span class="mr-3 text-light">当前用户：【${user1.uname}】</span>
                <i class="fa fa-clock-o text-light px-2">&nbsp;:</i><span class="mr-3 text-light" id="mytime"></span>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a class="btn btn-danger" href="/exit.jsp" role="button"><i class="fa fa-power-off" ></i>注销退出</a>
        </form>
    </div>
</nav>
<div class="row" style="height: 100%">
    <div class="col-2 border" style="background-color: #e3f2fd;">
        <nav class="navbar border text-light" style="background-color: #0c5460;">
            <div class="my-1"><i class="fa fa-bars mr-2" ></i>菜单</div>
        </nav>
        <nav class="navbar border">
            <a class="nav-link dropdown-toggle text-dark" href="#" role="button" data-toggle="collapse" data-target="#navbarToggleExternalContent">
                <i class="fa fa-user" ></i> <strong>用户管理</strong>
            </a>
        </nav>
        <div class="pos-f-t">
            <div class="collapse" id="navbarToggleExternalContent">
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/userAll.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i> 用户查询
                    </a>
                </div>
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/usersAdd.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>  添加用户
                    </a>
                </div>

            </div>

        </div>

        <nav class="navbar border">
            <a class="nav-link dropdown-toggle text-dark" href="#"  role="button" data-toggle="collapse" data-target="#navbarToggleExternalContent1">
                <i class="fa fa-edit" ></i>   <strong>部门管理</strong>
            </a>
        </nav>

        <div class="pos-f-t">
            <div class="collapse" id="navbarToggleExternalContent1">
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/deptAll.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>  部门查询
                    </a>
                </div>
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/deptAdd.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i> 添加部门
                    </a>
                </div>

            </div>

        </div>

        <nav class="navbar border">
            <a class="nav-link dropdown-toggle text-dark" href="#"  role="button" data-toggle="collapse" data-target="#navbarToggleExternalContent2">
                <i class="fa fa-edit" ></i>  <strong>  职位管理</strong>
            </a>
        </nav>

        <div class="pos-f-t">
            <div class="collapse" id="navbarToggleExternalContent2">
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/jobAll.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>   职位查询
                    </a>
                </div>
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/jobAdd.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i> 添加职位
                    </a>
                </div>

            </div>

        </div>

        <nav class="navbar border">
            <a class="nav-link dropdown-toggle text-dark" href="#"  role="button" data-toggle="collapse" data-target="#navbarToggleExternalContent3">
                <i class="fa fa-edit" ></i>  <strong>员工管理</strong>
            </a>
        </nav>

        <div class="pos-f-t">
            <div class="collapse" id="navbarToggleExternalContent3">
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/staffAll.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>  员工查询
                    </a>
                </div>
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/staffAdd.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>  添加员工
                    </a>
                </div>

            </div>

        </div>

        <nav class="navbar border">
            <a class="nav-link dropdown-toggle text-dark" href="#"  role="button" data-toggle="collapse" data-target="#navbarToggleExternalContent4">
                <i class="fa fa-edit" ></i>  <strong>公告管理</strong>
            </a>
        </nav>

        <div class="pos-f-t">
            <div class="collapse" id="navbarToggleExternalContent4">
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/announcementAll.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>  公告查询
                    </a>
                </div>
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/announcementAdd.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>  添加公告
                    </a>
                </div>

            </div>

        </div>

        <nav class="navbar border">
            <a class="nav-link dropdown-toggle text-dark" href="#"  role="button" data-toggle="collapse" data-target="#navbarToggleExternalContent5">
                <i class="fa fa-edit" ></i>  <strong>下载中心</strong>
            </a>
        </nav>

        <div class="pos-f-t">
            <div class="collapse" id="navbarToggleExternalContent5">
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/doumentsAll.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>  文档查询
                    </a>
                </div>
                <div class="p-3 border">
                    <a class="text-dark ml-3" href="/doumentsAdd.jsp" target="iframe1">
                        <i class="fa fa-caret-right " ></i>  上传文档
                    </a>
                </div>

            </div>

        </div>

    </div>
    <div class="col text-center">
        <iframe src="/index_nr.jsp" width="100%" frameborder="0" height="100%" scrolling="auto" name="iframe1"></iframe>
    </div>
</div>
<script>
function showTime(){
nowtime=new Date();
year=nowtime.getFullYear();
month=nowtime.getMonth()+1;
date=nowtime.getDate();
document.getElementById("mytime").innerText=year+"年"+month+"月"+date+" "+nowtime.toLocaleTimeString();
}

setInterval("showTime()",1000);

</script>
</body>
</html>
