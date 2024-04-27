package com.mty.organ.mapper;


import com.mty.organ.entity.User;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface UserMapper extends MyMapper<User> {

    /**
     * 通过ID查询单条数据
     */
    User queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<User> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<User> queryCondition(User user);

    /**
     * 新增数据
     */
    int insert(User user);

    /**
     * 修改数据
     */
    boolean update(User user);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
