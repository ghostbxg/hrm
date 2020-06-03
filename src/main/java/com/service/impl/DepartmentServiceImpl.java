package com.service.impl;

import com.entity.Department;
import com.dao.DepartmentDao;
import com.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 16:19:51
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer pid) {
        return this.departmentDao.queryById(pid);
    }

    @Override
    public List<Department> queryAll() {
            return this.departmentDao.queryAll();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Department> queryAllByLimit(int offset, int limit,String pname) {
        return this.departmentDao.queryAllByLimit(offset, limit,pname);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Department department) {

        return this.departmentDao.insert(department);
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Department department) {

        return this.departmentDao.update(department);
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(Integer[] pid) throws Exception {
        int num=0;
        for(Integer i:pid){
            num=this.departmentDao.deleteById(i);
        }
        if(num<pid.length){
            throw new Exception("删除失败!");
        }else{
            return  true;
        }
    }
}