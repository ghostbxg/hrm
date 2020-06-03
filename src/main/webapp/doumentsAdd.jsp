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
        if(form.dtitle.value=="")
        {
            alert("请输入文档名!");
            form.dtitle.focus();
            return false;
        }
        if(form.dcontent.value=="")
        {
            alert("请输入详细信息!");
            form.dcontent.focus();
            return false;
        }

    }

    -->
</script>
<div class="bg-info py-2 text-light">
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:文档管理 &nbsp;>&nbsp;上传文档
</div>
<center>
    <div class="container mt-2">
        <div class="sign-content  py-5 px-5 border" style=" background: #0c5460 ">
            <form action="/doument/insert" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">

                            <div class="form-group">
                                <input type="text" class="form-control text-light"  id="dtitle" name="dtitle" placeholder="请输入文档名" >
                            </div>
                            <div class="form-group">
                                <textarea id="dcontent" name="dcontent" class="form-control text-light" style="height: 300px"  placeholder="文档描述" required></textarea>
                            </div>
                            <div class="form-group">
                                <fieldset>
                                    <legend>文档上传</legend>
                                    选择文件：<input type="file" name="upfile">
                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="signin-footer">
                            <button type="submit" class="btn btn-primary btn-block"  onclick="check_admin()">
                                上传
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