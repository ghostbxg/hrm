package com.service.impl;

import com.entity.Doument;
import com.dao.DoumentDao;
import com.service.DoumentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Doument)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 22:52:42
 */
@Service("doumentService")
public class DoumentServiceImpl implements DoumentService {
    @Resource
    private DoumentDao doumentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    @Override
    public Doument queryById(Integer did) {
        return this.doumentDao.queryById(did);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Doument> queryAllByLimit(int offset, int limit,String dtitle) {
        return this.doumentDao.queryAllByLimit(offset, limit,dtitle);
    }

    @Override
    public List<Doument> queryAll() {
        return this.doumentDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param doument 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Doument doument) {

        return this.doumentDao.insert(doument);
    }

    /**
     * 修改数据
     *
     * @param doument 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Doument doument) {

        return this.doumentDao.update(doument);
    }

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(Integer[] did) throws Exception {
        int num=0;
        for(Integer i:did){
            num=this.doumentDao.deleteById(i);
        }
        if(num<did.length){
            throw new Exception("删除失败!");
        }else{
            return  true;
        }
    }
}