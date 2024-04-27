package com.mty.organ.mapper;


import com.mty.organ.entity.Notice;
import com.mty.organ.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * DAO层接口
 * @author: mty
 */
public interface NoticeMapper extends MyMapper<Notice> {

    /**
     * 通过ID查询单条数据
     */
    Notice queryById(Integer nid);

    /**
     * 分页查询数据
     */
    List<Notice> queryAllByLimit(Map mp);

    /**
     * 通过实体作为筛选条件查询
     */
    List<Notice> queryCondition(Notice notice);

    /**
     * 新增数据
     */
    int insert(Notice notice);

    /**
     * 修改数据
     */
    boolean update(Notice notice);

    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);

}
