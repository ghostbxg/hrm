package com.controller;

import com.entity.User1;
import com.entity.UserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.User1Service;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (User1)表控制层
 *
 * @author makejava
 * @since 2020-05-25 16:17:57
 */
@Controller
@RequestMapping("user1")
public class User1Controller {
    /**
     * 服务对象
     */
    @Resource
    private User1Service user1Service;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("selectOne")
    public User1 selectOne(Integer id) {
        return this.user1Service.queryById(id);
    }


    @PostMapping("login")
    public String login(User1 user1,HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user1.getUname(), user1.getUpassword());
        User1 u = this.user1Service.login(user1.getUname(), user1.getUpassword());
        ObjectMapper objectMapper = new ObjectMapper();
            Subject subject = SecurityUtils.getSubject();
            try {
                session.setAttribute("user1", objectMapper.writeValueAsString(u));
                subject.login(usernamePasswordToken);
                return "index";
            } catch (ArithmeticException e) {
                e.printStackTrace();
                return "login";
            }


    }





    @RequestMapping("selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(int page, int limit,String uname,Integer usend){
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        List<User1> list=this.user1Service.queryAllByLimit((page-1)*limit, limit,uname,usend);
        map.put("count",this.user1Service.queryAll().size());
        map.put("data",list);
        return map;


    }

    @RequestMapping("selectByname")
    @ResponseBody
    public boolean selectByname(String uname) throws Exception {
        if(this.user1Service.queryByUsername(uname).getUname()!=null){
            return false;
        }else{
            return true;
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer[] id) throws Exception {
        if(this.user1Service.deleteById(id)){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @PostMapping("insert")
    public String insert(User1 user,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        user.setUsend(3);
        user.setUtype("3");
        user.setUtime(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));

        if(this.user1Service.insert(user)>0){
            User1 user1 = this.user1Service.login(user.getUname(),user.getUpassword());
            this.user1Service.roleInsert(user1.getUid(),3);
            response.getWriter().print("<script>alert('新增成功！')</script>");
        }else{
            response.getWriter().print("<script>alert('新增失败！')</script>");
        }

        return "usersAdd";
    }

    @PostMapping("update")
    public String update(User1 user,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        User1 user1 = this.user1Service.login(user.getUname(),user.getUpassword());

        if(this.user1Service.update(user)>0){
            if(user.getUsend()==2){
                if(user1.getUsend()==1){
                    this.user1Service.roleDelete(user.getUid());
                    this.user1Service.roleInsert(user1.getUid(),2);
                }else{
                    this.user1Service.roleUpdate(user.getUid(),2);
                }

            }else  if(user.getUsend()==1){
                if(user1.getUsend()==3){
                    this.user1Service.roleUpdate(user.getUid(),2);
                    this.user1Service.roleInsert(user1.getUid(),1);
                }else if(user1.getUsend()==2){
                    this.user1Service.roleInsert(user1.getUid(),1);
                }
            }else  if(user.getUsend()==3){
                if(user1.getUsend()==1){
                    this.user1Service.roleDelete(user.getUid());
                    this.user1Service.roleInsert(user1.getUid(),3);
                }else{
                    this.user1Service.roleUpdate(user.getUid(),3);
                }
            }
            response.getWriter().print("<script>alert('修改成功！')</script>");
        }else{
            response.getWriter().print("<script>alert('修改失败！')</script>");
        }

        return "userUpdate";
    }

}