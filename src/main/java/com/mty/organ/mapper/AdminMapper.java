package com.mty.organ.mapper;


import com.mty.organ.entity.Admin;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface AdminMapper extends MyMapper<Admin> {

    /**
     * 通过ID查询单条数据
     */
    Admin queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<Admin> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Admin> queryCondition(Admin admin);

    /**
     * 新增数据
     */
    int insert(Admin admin);

    /**
     * 修改数据
     */
    boolean update(Admin admin);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
