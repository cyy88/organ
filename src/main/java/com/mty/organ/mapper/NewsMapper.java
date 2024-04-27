package com.mty.organ.mapper;


import com.mty.organ.entity.News;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface NewsMapper extends MyMapper<News> {

    /**
     * 通过ID查询单条数据
     */
    News queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<News> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<News> queryCondition(News news);

    /**
     * 新增数据
     */
    int insert(News news);

    /**
     * 修改数据
     */
    boolean update(News news);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
