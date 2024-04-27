package com.mty.organ.mapper;


import com.mty.organ.entity.Activities;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface ActivitiesMapper extends MyMapper<Activities> {

    /**
     * 通过ID查询单条数据
     */
    Activities queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<Activities> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Activities> queryCondition(Activities activities);

    /**
     * 新增数据
     */
    int insert(Activities activities);

    /**
     * 修改数据
     */
    boolean update(Activities activities);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
