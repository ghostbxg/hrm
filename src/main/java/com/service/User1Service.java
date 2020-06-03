package com.service;

import com.entity.User1;

import java.util.List;

/**
 * (User1)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 16:17:57
 */
public interface User1Service {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    User1 queryById(Integer uid);

    /**
     *
     * @param uname
     * @return
     */
    User1 queryByUsername(String uname);
    /**
     *
     * @param offset
     * @param limit
     * @param uname
     * @param send
     * @return
     */
    List<User1> queryAllByLimit(int offset, int limit,String uname,Integer send);

    /**
     *
     * @return
     */
    List<User1> queryAll();

    /**
     * 新增对象
     * @param user1
     * @return
     */
    int insert(User1 user1);

    /**
     * 修改数据
     *
     * @param user1 实例对象
     * @return
     */
    int update(User1 user1);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer[] uid) throws Exception;

    /**
     * 登入 查看是否有该用户
     *
     * @param uname
     * @param password
     * @return
     */
    User1 login(String uname,String password);

    /**
     *
     * @param uid
     * @param roleid
     * @return
     */
    int roleInsert(Integer uid,Integer roleid);

    /**
     *
     * @param uid
     * @param roleid
     * @return
     */
    int roleUpdate(Integer uid,Integer roleid);

    /**
     *
     * @param uid
     * @return
     */
    boolean roleDelete(Integer uid);
}