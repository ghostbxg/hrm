package com.service;

import com.entity.Doument;

import java.util.Collection;
import java.util.List;

/**
 * (Doument)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 22:52:42
 */
public interface DoumentService {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Doument queryById(Integer did);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Doument> queryAllByLimit(int offset, int limit,String dtitle);

    /**
     *
     * @return
     */
    List<Doument> queryAll();
    /**
     * 新增数据
     *
     * @param doument 实例对象
     * @return 实例对象
     */
    int insert(Doument doument);

    /**
     * 修改数据
     *
     * @param doument 实例对象
     * @return 实例对象
     */
    int update(Doument doument);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 是否成功
     */
    boolean deleteById(Integer[] did) throws Exception;
}