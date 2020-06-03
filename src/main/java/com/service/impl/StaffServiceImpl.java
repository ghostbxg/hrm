package com.service.impl;

import com.dao.StaffDao;
import com.entity.Staff;
import com.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Staff)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 16:19:25
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    @Override
    public Staff queryById(Integer sid) {
        return this.staffDao.queryById(sid);
    }

    @Override
    public List<Staff> queryAllByLimit(int offset, int limit, String sname, String sphonenumber, String sidnumber, String ssex, Integer pid, Integer jid) {
        return this.staffDao.queryAllByLimit(offset, limit, sname, sphonenumber, sidnumber, ssex, pid, jid);
    }


    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Staff staff) {

        return this.staffDao.insert(staff);
    }

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Staff staff) {

        return  this.staffDao.update(staff);
    }

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer[] sid) throws Exception {
        int num=0;
        for(Integer i:sid){
            num=this.staffDao.deleteById(i);
        }
        if(num<sid.length){
            throw new Exception("删除失败!");
        }else{
            return  true;
        }
    }

    @Override
    public List<Staff> queryAll() {
        return this.staffDao.queryAll();
    }
}