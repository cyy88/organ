package com.mty.organ.mapper;


import com.mty.organ.entity.Organ;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface OrganMapper extends MyMapper<Organ> {

    /**
     * 通过ID查询单条数据
     */
    Organ queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<Organ> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Organ> queryCondition(Organ organ);

    /**
     * 新增数据
     */
    int insert(Organ organ);

    /**
     * 修改数据
     */
    boolean update(Organ organ);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
