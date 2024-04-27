package com.mty.organ.service;

import com.mty.organ.mapper.ApplyMapper;
import com.mty.organ.entity.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Service接口实现类
 * @author: mty
 */
@Service
@Transactional
public class ApplyService {

    @Autowired
    private ApplyMapper applyDao;


    /**
     * 通过ID查询单条数据
     */
    public Apply queryById(Integer nid) {
       return applyDao.queryById(nid);
    }

    /**
     * 分页查询
     */
    public List<Apply> queryAllByLimit(Map mp) {
       return applyDao.queryAllByLimit(mp);
    }

    /**
     * 新增数据
     */
    public int insert(Apply apply) {
        return applyDao.insert(apply);
    }

    /**
     * 修改数据
     */
    public boolean update(Apply apply) {
        return applyDao.update(apply);
    }

    /**
     * 通过主键删除数据
     */
    public boolean deleteById(Integer id) {
        return applyDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询
     */
    public List<Apply> queryCondition(Apply apply) {
        return applyDao.queryCondition(apply);
    }


}
