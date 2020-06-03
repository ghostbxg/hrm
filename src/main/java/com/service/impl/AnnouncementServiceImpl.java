package com.service.impl;

import com.entity.Announcement;
import com.dao.AnnouncementDao;
import com.service.AnnouncementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * (Announcement)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 19:36:16
 */
@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {
    @Resource
    private AnnouncementDao announcementDao;

    @Override
    public List<Announcement> queryAll() {
        return this.announcementDao.queryAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    @Override
    public Announcement queryById(Integer aid) {
        return this.announcementDao.queryById(aid);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Announcement> queryAllByLimit(int offset, int limit, String aname) {

        List<Announcement> list = this.announcementDao.queryAllByLimit(offset, limit,aname);
        List<Announcement> list1=new ArrayList<>();
        for(Announcement a:list){
            try{
                FileInputStream fis = new FileInputStream(a.getAcontent());
                byte[] b = new byte[fis.available()];
                int length = fis.read(b);
                String str = new String(b,0,length);
                fis.close();
                a.setAcontent(str);
                list1.add(a);
            }catch (Exception e){

            }


        }

        return list1;
    }

    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Announcement announcement) {

        return this.announcementDao.insert(announcement);
    }

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Announcement announcement) {

        return  this.announcementDao.update(announcement);
    }

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(Integer[] aid) throws Exception {

        int num=0;
        for(Integer i:aid){
            num=this.announcementDao.deleteById(i);
        }
        if(num<aid.length){
            throw new Exception("删除失败!");
        }else{
            return  true;
        }
    }
}