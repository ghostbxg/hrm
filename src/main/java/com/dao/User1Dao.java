package com.dao;

import com.entity.User1;
import com.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Set;

/**
 * (User1)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 16:17:57
 */
public interface User1Dao {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    User1 queryById(Integer uid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User1> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("uname") String name,@Param("usend")Integer send);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<User1> queryAll();

    /**
     * 新增数据
     *
     * @param user1 实例对象
     * @return 影响行数
     */
    int insert(User1 user1);

    /**
     * 修改数据
     *
     * @param user1 实例对象
     * @return 影响行数
     */
    int update(User1 user1);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 影响行数
     */
    int deleteById(Integer uid);

    /**
     * 登入 查看是否有该用户
     *
     * @param uname
     * @param password
     * @return
     */
    User1 login(@Param("uname") String uname,@Param("upassword") String password);

    /**
     * 查询用户角色
     * @param uname
     * @return
     */
    Set<String>  queryUserRoles(@Param("uname") String uname);

    /**
     * 查询用户的权限
     * @param uname
     * @return
     */
    Set<String> queryUserPerms(@Param("uname")String uname);

    /**
     * 查询用户信息
     * @param uname
     * @return
     */
    User1 queryByUsername(@Param("uname")String uname);

    /**
     *
     * @param uid
     * @param roleid
     * @return
     */
   int roleInsert(@Param("uid")Integer uid,@Param("role_id")Integer roleid);

    /**
     *
     * @param uid
     * @param roleid
     * @return
     */
   int roleUpdate(@Param("uid")Integer uid,@Param("role_id")Integer roleid);

    /**
     *
     * @param uid
     * @return
     */
   boolean deleteShiro(@Param("uid")Integer uid);
}