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

<link rel="stylesheet" type="text/css" href="/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css"/>
<script src="/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<link href="/css/bootstrap/bootstrap-table.css" rel="stylesheet">
<script src="/js/bootstrap/bootstrap.min.js"></script>
<script src="js/bootstrap/bootstrap-table.js"></script>
<script src="/js/bootstrap/bootstrap-table-zh-CN.js"></script>
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">
<script src="/layui/layui.js" charset="utf-8"></script>
<body>

<div class="bg-info py-2 text-light">
    <i class="fa fa-arrow-circle-right pr-5" ></i>当前位置:公告管理 &nbsp;>&nbsp;公告查询
</div>

<div class="py-3">

    <div class="demoTable">
        <div class="layui-inline">
            <input class="form-control mr-sm-2" type="text" name="aname" id="aname" placeholder="请输入要查询的公告" aria-label="Search" size="28px">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
        <button class="layui-btn layui-btn-danger" data-type="delTest">删除</button>
    </div>


</div>


<table class="layui-hide" id="test" lay-filter="test"></table>




<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs text-light" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs text-light" lay-event="del">删除</a>
    <a class="layui-btn layui-btn-xs layui-btn-xs text-light" lay-event="select">预览</a>
</script>

<script>

    var admin;


    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/announcement/selectAll'
            ,cols: [[
                {type:'checkbox'}
                ,{field:'aname',  title: '公告内容', sort: true}
                ,{field:'acontent',title: '公告名称'}
                ,{field:'atime',  title: '创建时间', sort: true}
                ,{field:'uname',  title: '公告人', sort: true}
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
                    $.post("/announcement/delete",{id:data.aid},function(r){
                        alert(r)
                    })
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    type: 2,
                    title: '修改公告资料',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['800px', '700'],
                    content: 'announcementUpdate.jsp'
                });
            }else if(obj.event === 'select'){
                layer.open({
                    type: 2,
                    title: '预览公告',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['800px', '700'],
                    content: 'announcementSelect.jsp'
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
                            d[i]= data[i].aid;
                        }
                        $.ajax({
                            url: "/announcement/delete",
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

                var aname=$('#aname');
                var acontent=$('#acontent');
                //执行重载
                table.reload('reloadTable', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {

                        aname:aname.val()

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
