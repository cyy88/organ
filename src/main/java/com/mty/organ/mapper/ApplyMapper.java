package com.mty.organ.mapper;


import com.mty.organ.entity.Apply;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface ApplyMapper extends MyMapper<Apply> {

    /**
     * 通过ID查询单条数据
     */
    Apply queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<Apply> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Apply> queryCondition(Apply apply);

    /**
     * 新增数据
     */
    int insert(Apply apply);

    /**
     * 修改数据
     */
    boolean update(Apply apply);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
