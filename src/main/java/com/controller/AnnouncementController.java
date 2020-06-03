package com.controller;

import com.entity.Announcement;
import com.entity.User1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.AnnouncementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * (Announcement)表控制层
 *
 * @author makejava
 * @since 2020-05-14 19:36:16
 */
@Controller
@RequestMapping("announcement")
public class AnnouncementController {
    /**
     * 服务对象
     */
    @Resource
    private AnnouncementService announcementService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Announcement selectOne(Integer id) {
        return this.announcementService.queryById(id);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(int page, int limit, String aname)  {
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        List<Announcement> list=this.announcementService.queryAllByLimit((page-1)*limit, limit,aname);
        map.put("count",this.announcementService.queryAll().size());
        map.put("data",list);
        return map;


    }

    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(Integer[] id) throws Exception {
        System.out.println(id);
        if(this.announcementService.deleteById(id)){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("insert")
    public String insert(Announcement announcement,HttpSession session) throws IOException {
        announcement.setAtime(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
        ObjectMapper objectMapper = new ObjectMapper();
        User1 u= objectMapper.readValue(session.getAttribute("user1")+"",User1.class);
        announcement.setUid(u.getUid());
        String path=null;
        File f=new File("D:\\Spring\\hrm\\src\\main\\webapp\\announcement\\"+announcement.getAname()+".txt");
        if(!f.exists()){
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(announcement.getAcontent().getBytes());
        fos.close();
        path=f.getAbsolutePath();
        announcement.setAcontent(path);

        this.announcementService.insert(announcement);
        return "announcementAdd";
    }

    @PostMapping("update")
    public String update(Announcement announcement,HttpSession session) throws IOException {
        String path=null;
        File f=new File("D:\\Spring\\hrm\\src\\main\\webapp\\announcement\\"+announcement.getAname()+".txt");
        if(!f.exists()){
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(announcement.getAcontent().getBytes());
        fos.close();
        path=f.getAbsolutePath();
        announcement.setAcontent(path);
        ObjectMapper objectMapper = new ObjectMapper();
        User1 u= objectMapper.readValue(session.getAttribute("user1")+"",User1.class);
        announcement.setUid(u.getUid());
       this.announcementService.update(announcement);


        return "announcementUpdate";
    }
}