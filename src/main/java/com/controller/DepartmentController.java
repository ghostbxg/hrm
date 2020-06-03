package com.controller;

import com.entity.Department;
import com.entity.Job;
import com.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2020-05-25 16:19:51
 */
@Controller
@RequestMapping("department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Department selectOne(Integer id) {
        return this.departmentService.queryById(id);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(int page, int limit,String pname){
        Map<String,Object> map = new HashMap<>();
        System.out.println(pname);
        map.put("code",0);
        List<Department> list=this.departmentService.queryAllByLimit((page-1)*limit, limit,pname);
        map.put("count",this.departmentService.queryAll().size());
        map.put("data",list);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(Integer[] id) throws Exception {

        if(this.departmentService.deleteById(id)){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("insert")
    public String insert(Department dept, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if(this.departmentService.insert(dept)>0){
            response.getWriter().print("<script>alert('新增成功！')</script>");
        }else{
            response.getWriter().print("<script>alert('新增失败！')</script>");
        }

        return "deptAdd";
    }

    @GetMapping("insertSelect")
    public String insertSelect(Model model){
        List<Department> list=this.departmentService.queryAll();
        if(list.size()==0){
            model.addAttribute("flag1",true);
        }else{
            model.addAttribute("flag",false);
        }
        model.addAttribute("deptlist",list);
            return "staffAdd";

    }

    @GetMapping("updateSelect")
    public String updateSelect(Model model){
        List<Department> list=this.departmentService.queryAll();
        if(list.size()==0){
            model.addAttribute("flag1",true);
        }else{
            model.addAttribute("flag",false);
        }
        model.addAttribute("deptlist",list);
        return "staffUpdate";

    }

    @GetMapping("allSelect")
    public String allSelect(Model model){
        List<Department> list=this.departmentService.queryAll();
        if(list.size()==0){
            model.addAttribute("flag1",true);
        }else{
            model.addAttribute("flag",false);
        }
        model.addAttribute("deptlist",list);
        return "staffAll";

    }

    @PostMapping("update")
    public String update(Department dept,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if(this.departmentService.update(dept)>0){
            response.getWriter().print("<script>alert('修改成功！')</script>");
        }else{
            response.getWriter().print("<script>alert('修改失败！')</script>");
        }

        return "deptUpdate";
    }
}