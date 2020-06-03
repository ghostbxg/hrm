package com.service.impl;

import com.entity.User1;
import com.dao.User1Dao;
import com.service.User1Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User1)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 16:17:57
 */
@Service("user1Service")
public class User1ServiceImpl implements User1Service {
    @Resource
    private User1Dao user1Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public User1 queryById(Integer uid) {
        return this.user1Dao.queryById(uid);
    }

    @Override
    public User1 queryByUsername(String uname) {
     return this.user1Dao.queryByUsername(uname);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User1> queryAllByLimit(int offset, int limit,String uname,Integer usend) {
        return this.user1Dao.queryAllByLimit(offset, limit,uname,usend);
    }

    @Override
    public List<User1> queryAll() {
        return this.user1Dao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param user1 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(User1 user1) {
        return this.user1Dao.insert(user1);
    }

    /**
     * 修改数据
     *
     * @param user1 实例对象
     * @return 实例对象
     */
    @Override
    public int update(User1 user1) {

        return this.user1Dao.update(user1);
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(Integer[] uid) throws Exception{
        int num=0;
        for(Integer i:uid){
            num=this.user1Dao.deleteById(i);
            this.user1Dao.deleteShiro(i);
        }
        if(num<uid.length){
            throw new Exception("删除失败!");
        }else{
            return  true;
        }

    }

    @Override
    public User1 login(String uname, String password) {
        return this.user1Dao.login(uname,password);

    }

    @Override
    public int roleInsert(Integer uid,Integer roleid) {
        return this.user1Dao.roleInsert(uid,roleid);
    }

    @Override
    public int roleUpdate(Integer uid,Integer roleid) {
        return this.user1Dao.roleUpdate(uid,roleid);
    }

    @Override
    public boolean roleDelete(Integer uid) {
        return  this.user1Dao.deleteShiro(uid);
    }


}