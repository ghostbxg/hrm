package com.controller;

import com.entity.Department;
import com.entity.Job;
import com.service.JobService;
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
 * (Job)表控制层
 *
 * @author makejava
 * @since 2020-05-25 16:19:35
 */
@Controller
@RequestMapping("job")
public class JobController {
    /**
     * 服务对象
     */
    @Resource
    private JobService jobService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Job selectOne(Integer id) {
        return this.jobService.queryById(id);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(int page, int limit, String jname){
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        List<Job> list=this.jobService.queryAllByLimit((page-1)*limit, limit,jname);
        map.put("count",this.jobService.queryAll().size());
        map.put("data",list);
        return map;
    }

    @GetMapping("insertSelect")
    public String select(Model model){
        List<Job> list=this.jobService.queryAll();
        if(list.size()==0){
            model.addAttribute("flag",true);
        }else{
            model.addAttribute("flag",false);
        }
        model.addAttribute("joblist",list);
        return "forward:/department/insertSelect";
    }

    @GetMapping("updateSelect")
    public String updateSelect(Model model){
        List<Job> list=this.jobService.queryAll();
        if(list.size()==0){
            model.addAttribute("flag",true);
        }else{
            model.addAttribute("flag",false);
        }
        model.addAttribute("joblist",list);
        return "forward:/department/updateSelect";
    }

    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(Integer[] id) throws Exception {

        if(this.jobService.deleteById(id)){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("insert")
    public String insert(Job job, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if(this.jobService.insert(job)>0){
            response.getWriter().print("<script>alert('新增成功！')</script>");
        }else{
            response.getWriter().print("<script>alert('新增失败！')</script>");
        }

        return "jobAdd";
    }

    @PostMapping("update")
    public String update(Job job,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if(this.jobService.update(job)>0){
            response.getWriter().print("<script>alert('修改成功！')</script>");
        }else{
            response.getWriter().print("<script>alert('修改失败！')</script>");
        }

        return "jobUpdate";
    }

}