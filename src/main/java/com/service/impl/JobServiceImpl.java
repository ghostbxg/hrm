package com.service.impl;

import com.entity.Job;
import com.dao.JobDao;
import com.service.JobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Job)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 16:19:35
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
    @Resource
    private JobDao jobDao;

    @Override
    public List<Job> queryAll() {
        return this.jobDao.queryAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param jid 主键
     * @return 实例对象
     */
    @Override
    public Job queryById(Integer jid) {
        return this.jobDao.queryById(jid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Job> queryAllByLimit(int offset, int limit,String jname) {
        return this.jobDao.queryAllByLimit(offset, limit,jname);
    }

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Job job) {

        return this.jobDao.insert(job);
    }

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Job job) {

        return this.jobDao.update(job);
    }

    /**
     * 通过主键删除数据
     *
     * @param jid 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(Integer[] jid) throws Exception {
        int num=0;
        for(Integer i:jid){
            num=this.jobDao.deleteById(i);
        }
        if(num<jid.length){
            throw new Exception("删除失败!");
        }else{
            return  true;
        }
    }
}