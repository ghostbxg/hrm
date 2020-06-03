package com.controller;

import com.entity.Staff;

import com.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Staff)表控制层
 *
 * @author makejava
 * @since 2020-05-25 16:19:25
 */
@Controller
@RequestMapping("staff")
public class StaffController {
    /**
     * 服务对象
     */
    @Resource
    private StaffService staffService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Staff selectOne(Integer id) {
        return this.staffService.queryById(id);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(int page, int limit,String sname, String sphonenumber, String sidnumber, String ssex, Integer pid, Integer jid){

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        List<Staff> list=this.staffService.queryAllByLimit((page-1)*limit, limit, sname, sphonenumber, sidnumber, ssex, pid, jid);
        map.put("count",this.staffService.queryAll().size());
        map.put("data",list);
        return map;


    }

    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(Integer[] id) throws Exception {
        return this.staffService.deleteById(id);

    }

    @PostMapping("insert")
    public String insert(Staff staff, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        staff.setStime(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
        if(this.staffService.insert(staff)>0){
            response.getWriter().print("<script>alert('新增成功！')</script>");
        }else{
            response.getWriter().print("<script>alert('新增失败！')</script>");
        }

        return "staffAdd";
    }

    @PostMapping("update")
    public String update(Staff staff,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if(this.staffService.update(staff)>0){
            response.getWriter().print("<script>alert('修改成功！')</script>");
        }else{
            response.getWriter().print("<script>alert('修改失败！')</script>");
        }

        return "staffUpdate";
    }

}