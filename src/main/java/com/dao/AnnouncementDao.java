package com.dao;

import com.entity.Announcement;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Announcement)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-14 19:36:14
 */
public interface AnnouncementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    Announcement queryById(Integer aid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Announcement> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("aname") String aname);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param announcement 实例对象
     * @return 对象列表
     */
    List<Announcement> queryAll(Announcement announcement);

    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 影响行数
     */
    int insert(Announcement announcement);

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 影响行数
     */
    int update(Announcement announcement);

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 影响行数
     */
    int deleteById(Integer aid);

    /**
     *
     * @return
     */
    List<Announcement> queryAll();
}