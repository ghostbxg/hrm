package com.dao;

import com.entity.Job;
import com.entity.Staff;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Staff)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 16:19:25
 */
public interface StaffDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    Staff queryById(Integer sid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Staff> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("sname")String sname,@Param("sphonenumber")String sphonenumber,@Param("sidnumber")String sidnumber,@Param("ssex")String ssex,@Param("pid")Integer pid,@Param("jid")Integer jid);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param staff 实例对象
     * @return 对象列表
     */
    List<Staff> queryAll(Staff staff);

    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 影响行数
     */
    int insert(Staff staff);

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 影响行数
     */
    int update(Staff staff);

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 影响行数
     */
    int deleteById(Integer sid);

    /**
     *
     * @return
     */
    List<Staff> queryAll();
}