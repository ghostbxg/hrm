package com.service;

import com.entity.Department;

import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 16:19:51
 */
public interface DepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Department queryById(Integer pid);
    /**
     *
     * @return
     */
    List<Department> queryAll();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(int offset, int limit,String pname);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    int insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    int update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer[] pid) throws Exception;

}