package com.service;

import com.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Staff)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 16:19:25
 */
public interface StaffService {

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    Staff queryById(Integer sid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Staff> queryAllByLimit(int offset, int limit,String sname, String sphonenumber, String sidnumber,String ssex, Integer pid, Integer jid);

    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    int insert(Staff staff);

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    int update(Staff staff);

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer[] sid) throws Exception;

    /**
     *
     * @return
     */
    List<Staff> queryAll();
}