package com.dao;

import com.entity.Department;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 16:19:51
 */
public interface DepartmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Department queryById(Integer pid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("pname") String pname);



    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 影响行数
     */
    int deleteById(Integer pid);

    /**
     *
     * @return
     */
    List<Department> queryAll();
}