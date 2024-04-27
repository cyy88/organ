package com.mty.organ.mapper;


import com.mty.organ.entity.Resources;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface ResourcesMapper extends MyMapper<Resources> {

    /**
     * 通过ID查询单条数据
     */
    Resources queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<Resources> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Resources> queryCondition(Resources resources);

    /**
     * 新增数据
     */
    int insert(Resources resources);

    /**
     * 修改数据
     */
    boolean update(Resources resources);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
