package com.mty.organ.mapper;


import com.mty.organ.entity.Appoint;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface AppointMapper extends MyMapper<Appoint> {

    /**
     * 通过ID查询单条数据
     */
    Appoint queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<Appoint> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Appoint> queryCondition(Appoint appoint);

    /**
     * 新增数据
     */
    int insert(Appoint appoint);

    /**
     * 修改数据
     */
    boolean update(Appoint appoint);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
