/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-02 18:36:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class announcementAll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/bootstrap.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/font-awesome.min.css\"/>\r\n");
      out.write("<script src=\"/js/jquery-3.4.1.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("<link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"/js/bootstrap.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("<link href=\"/css/bootstrap/bootstrap-table.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap/bootstrap-table.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap-table-zh-CN.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/layui/css/layui.css\"  media=\"all\">\r\n");
      out.write("<script src=\"/layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"bg-info py-2 text-light\">\r\n");
      out.write("    <i class=\"fa fa-arrow-circle-right pr-5\" ></i>当前位置:公告管理 &nbsp;>&nbsp;公告查询\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"py-3\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"demoTable\">\r\n");
      out.write("        <div class=\"layui-inline\">\r\n");
      out.write("            <input class=\"form-control mr-sm-2\" type=\"text\" name=\"aname\" id=\"aname\" placeholder=\"请输入要查询的公告\" aria-label=\"Search\" size=\"28px\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <button class=\"layui-btn\" data-type=\"reload\">搜索</button>\r\n");
      out.write("        <button class=\"layui-btn layui-btn-danger\" data-type=\"delTest\">删除</button>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class=\"layui-hide\" id=\"test\" lay-filter=\"test\"></table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/html\" id=\"barDemo\">\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs text-light\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-danger layui-btn-xs text-light\" lay-event=\"del\">删除</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs layui-btn-xs text-light\" lay-event=\"select\">预览</a>\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    var admin;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    layui.use('table', function(){\r\n");
      out.write("        var table = layui.table;\r\n");
      out.write("\r\n");
      out.write("        table.render({\r\n");
      out.write("            elem: '#test'\r\n");
      out.write("            ,url:'/announcement/selectAll'\r\n");
      out.write("            ,cols: [[\r\n");
      out.write("                {type:'checkbox'}\r\n");
      out.write("                ,{field:'aname',  title: '公告内容', sort: true}\r\n");
      out.write("                ,{field:'acontent',title: '公告名称'}\r\n");
      out.write("                ,{field:'atime',  title: '创建时间', sort: true}\r\n");
      out.write("                ,{field:'uname',  title: '公告人', sort: true}\r\n");
      out.write("                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}\r\n");
      out.write("            ]]\r\n");
      out.write("            ,id:\"reloadTable\"\r\n");
      out.write("            ,page: true\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        //监听工具条\r\n");
      out.write("        table.on('tool(test)', function(obj){\r\n");
      out.write("            var data = obj.data;\r\n");
      out.write("            admin=data;\r\n");
      out.write("            if(obj.event === 'del'){\r\n");
      out.write("                layer.confirm('真的删除行么', function(index){\r\n");
      out.write("                    obj.del();\r\n");
      out.write("                    layer.close(index);\r\n");
      out.write("                    $.post(\"/announcement/delete\",{id:data.aid},function(r){\r\n");
      out.write("                        alert(r)\r\n");
      out.write("                    })\r\n");
      out.write("                });\r\n");
      out.write("            } else if(obj.event === 'edit'){\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    type: 2,\r\n");
      out.write("                    title: '修改公告资料',\r\n");
      out.write("                    shadeClose: true,\r\n");
      out.write("                    shade: false,\r\n");
      out.write("                    maxmin: true, //开启最大化最小化按钮\r\n");
      out.write("                    area: ['800px', '700'],\r\n");
      out.write("                    content: 'announcementUpdate.jsp'\r\n");
      out.write("                });\r\n");
      out.write("            }else if(obj.event === 'select'){\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    type: 2,\r\n");
      out.write("                    title: '预览公告',\r\n");
      out.write("                    shadeClose: true,\r\n");
      out.write("                    shade: false,\r\n");
      out.write("                    maxmin: true, //开启最大化最小化按钮\r\n");
      out.write("                    area: ['800px', '700'],\r\n");
      out.write("                    content: 'announcementSelect.jsp'\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        table.on('checkbox(reloadTable)', function(obj){\r\n");
      out.write("            console.log(obj)\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        var $ = layui.$, active = {\r\n");
      out.write("            delTest: function(){ //获取选中数据\r\n");
      out.write("                var checkStatus = table.checkStatus('reloadTable')\r\n");
      out.write("                    ,data = checkStatus.data;\r\n");
      out.write("                if(data.length==0){\r\n");
      out.write("                    layer.alert(\"请勾选要删除的行\")\r\n");
      out.write("                    return;\r\n");
      out.write("                }else {\r\n");
      out.write("                    layer.confirm(\"是否要删除\", function(index){\r\n");
      out.write("                        var d=new Array();\r\n");
      out.write("                        for(var i=0; i< data.length;i++){\r\n");
      out.write("                            d[i]= data[i].aid;\r\n");
      out.write("                        }\r\n");
      out.write("                        $.ajax({\r\n");
      out.write("                            url: \"/announcement/delete\",\r\n");
      out.write("                            data: { id: d},\r\n");
      out.write("                            dataType: \"json\",\r\n");
      out.write("                            type: \"POST\",\r\n");
      out.write("                            traditional: true,//这里设为true就可以了\r\n");
      out.write("                            success: function (r) {\r\n");
      out.write("                                alert(r)\r\n");
      out.write("\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("                        parent.location.reload()\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            ,reload:function () {\r\n");
      out.write("\r\n");
      out.write("                var aname=$('#aname');\r\n");
      out.write("                var acontent=$('#acontent');\r\n");
      out.write("                //执行重载\r\n");
      out.write("                table.reload('reloadTable', {\r\n");
      out.write("                    page: {\r\n");
      out.write("                        curr: 1 //重新从第 1 页开始\r\n");
      out.write("                    }\r\n");
      out.write("                    ,where: {\r\n");
      out.write("\r\n");
      out.write("                        aname:aname.val()\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("                }, 'data');\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        $('.demoTable .layui-btn').on('click', function(){\r\n");
      out.write("            var type = $(this).data('type');\r\n");
      out.write("            active[type] ? active[type].call(this) : '';\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
