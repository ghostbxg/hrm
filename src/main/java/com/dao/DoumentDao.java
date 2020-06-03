package com.dao;

import com.entity.Doument;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Doument)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 22:52:41
 */
public interface DoumentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Doument queryById(Integer did);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Doument> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("dtitle")String dtitle);


    /**
     * 通过实体作为筛选条件查询
     *
     *
     * @return 对象列表
     */
    List<Doument> queryAll();

    /**
     * 新增数据
     *
     * @param doument 实例对象
     * @return 影响行数
     */
    int insert(Doument doument);

    /**
     * 修改数据
     *
     * @param doument 实例对象
     * @return 影响行数
     */
    int update(Doument doument);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 影响行数
     */
    int deleteById(Integer did);

}