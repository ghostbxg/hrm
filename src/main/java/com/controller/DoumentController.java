package com.controller;

import com.entity.Doument;
import com.entity.User1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.DoumentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (Doument)表控制层
 *
 * @author makejava
 * @since 2020-06-01 22:52:42
 */
@RestController
@RequestMapping("doument")
public class DoumentController {
    /**
     * 服务对象
     */
    @Resource
    private DoumentService doumentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Doument selectOne(Integer id) {
        return this.doumentService.queryById(id);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(int page, int limit, String dtitle)  {
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        List<Doument> list=this.doumentService.queryAllByLimit((page-1)*limit, limit,dtitle);
        map.put("count",this.doumentService.queryAll().size());
        map.put("data",list);
        return map;


    }

    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(Integer[] id) throws Exception {
        return this.doumentService.deleteById(id);
    }

    @PostMapping("insert")
    public String upload(MultipartFile upfile, Doument doument, HttpServletRequest request, HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        User1 u= objectMapper.readValue(session.getAttribute("user1")+"",User1.class);

            //将文件上传到服务器指定目录下
            String dir = request.getServletContext().getRealPath("doument");
            String filename = UUID.randomUUID().toString();
            String filesuffx = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."));
            String savepath = dir+"/"+filename+filesuffx;
            upfile.transferTo(new File(savepath));

            //将文件信息保存到数据库
            doument.setUid(u.getUid());
            doument.setDtime(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
            doument.setDcontentnr("doument/"+filename+filesuffx);
            this.doumentService.insert(doument);

        return "doumentsAdd";
    }

    @PostMapping("update")
    public String update(MultipartFile upfile, Doument doument, HttpServletRequest request) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User1 u= objectMapper.readValue(request.getSession().getAttribute("user1")+"",User1.class);
        try{
            //将文件上传到服务器指定目录下
            String dir = request.getServletContext().getRealPath("doument");
            String filename = UUID.randomUUID().toString();
            String filesuffx = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."));
            String savepath = dir+"/"+filename+filesuffx;
            upfile.transferTo(new File(savepath));

            //将文件信息保存到数据库
            doument.setUid(u.getUid());
            doument.setDtime(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
            doument.setDcontentnr("doument/"+filename+filesuffx);
            this.doumentService.update(doument);
        }catch (Exception e){

        }
        return "doumentUpdate";
    }
}