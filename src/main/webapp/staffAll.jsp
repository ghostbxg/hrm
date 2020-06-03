<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/31
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
<script src="js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<link href="css/bootstrap/bootstrap-table.css" rel="stylesheet">
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/bootstrap/bootstrap-table.js"></script>
<script src="js/bootstrap/bootstrap-table-zh-CN.js"></script>
<link rel="stylesheet" href="layui/css/layui.css"  media="all">
<script src="layui/layui.js" charset="utf-8"></script>
<body>

<div class="bg-info py-2 text-light">
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:员工管理 &nbsp;>&nbsp;员工查询
</div>

<div class="py-3">

    <div class="demoTable">
        <div class="layui-inline" >
            <select name="jid" id="jid" class="form-control mr-sm-2">
                <option value="" >---请选择要查询的职业---</option>
                <option value="4">JAVA实习生</option>
                <option value="5">JAVA开发实习生</option>
            </select>
        </div>
        <div class="layui-inline">
            <input class="form-control mr-sm-2" type="text" name="sname" id="sname" placeholder="请输入要查询的姓名" aria-label="Search" size="28px">
        </div>
        <div class="layui-inline ">
            <input class="form-control mr-sm-2" type="text" name="sidnumber" id="sidnumber" placeholder="请输入要查询的身份证号码" aria-label="Search" size="28px">
        </div>
        <div class="layui-inline">
            <select name="ssex" id="ssex"class="form-control mr-sm-2">
                <option value="" >---请选择要查询的性别---</option>

                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
        <div class="layui-inline">
            <input class="form-control mr-sm-2" type="text" name="sphonenumber" id="sphonenumber" placeholder="请输入要查询的手机号" aria-label="Search" size="28px">
        </div>
        <div class="layui-inline">
            <select name="pid" id="pid"class="form-control mr-sm-2">
            <option value="" >---请选择要查询的部门---</option>
                <option value="5">技术部</option>
                <option value="6">运营部</option>
            </select>
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
        <button class="layui-btn layui-btn-danger" data-type="delTest">删除</button>
    </div>


</div>


<table class="layui-hide" id="test" lay-filter="test"></table>




<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs text-light" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs text-light" lay-event="del">删除</a>
</script>

<script>





    var admin;


    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/staff/selectAll'
            ,cols: [[
                {type:'checkbox'}
                ,{field:'sname',  title: '姓名', sort: true}
                ,{field:'ssex',title: '性别'}
                ,{field:'sphonenumber',  title: '手机号码', sort: true}
                ,{field:'semail',  title: '邮箱'}
                ,{field:'jname',  title: '职位'}
                ,{field:'seduction',  title: '学历'}
                ,{field:'sidnumber', title: '身份证号'}
                ,{field:'pname',  title: '部门'}
                ,{field:'sadress',  title: '联系地址'}
                ,{field:'stime', title: '建档日期'}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
            ]]
            ,id:"reloadTable"
            ,page: true
        });



        //监听工具条
        table.on('tool(test)', function(obj){
            var data = obj.data;
            admin=data;
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                    $.post("/staff/delete",{id:data.sid},function(r){
                        alert(r)
                    })
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    type: 2,
                    title: '修改用户资料',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['800px', '700'],
                    content: 'staffUpdate.jsp'
                });
            }
        });

        table.on('checkbox(reloadTable)', function(obj){
            console.log(obj)
        });

        var $ = layui.$, active = {
            delTest: function(){ //获取选中数据
                var checkStatus = table.checkStatus('reloadTable')
                    ,data = checkStatus.data;
                if(data.length==0){
                    layer.alert("请勾选要删除的行")
                    return;
                }else {
                    layer.confirm("是否要删除", function(index){
                        var d=new Array();
                        for(var i=0; i< data.length;i++){
                            d[i]= data[i].sid;
                        }
                        $.ajax({
                            url: "/staff/delete",
                            data: { id: d},
                            dataType: "json",
                            type: "POST",
                            traditional: true,//这里设为true就可以了
                            success: function (r) {
                                alert(r)

                            }
                        });
                        parent.location.reload()
                    });

                }

            }
            ,reload:function () {

                var jid = $('#jid');
                var sname=$('#sname');
                var sidnumber=$('#sidnumber');
                var ssex=$('#ssex');
                var pid=$('#pid');
                var sphonenumber=$('#sphonenumber');
                //执行重载
                table.reload('reloadTable', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        jid: jid.val()
                        ,sname:sname.val()
                        ,sidnumber:sidnumber.val()
                        ,ssex:ssex.val()
                        ,pid:pid.val()
                        ,sphonenumber:sphonenumber.val()
                    }
                }, 'data');


            }

        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });

</script>
</body>
</html>
