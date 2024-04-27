package com.mty.organ.service;

import com.mty.organ.mapper.OrganMapper;
import com.mty.organ.entity.Organ;
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
public class OrganService {

    @Autowired
    private OrganMapper organDao;


    /**
     * 通过ID查询单条数据
     */
    public Organ queryById(Integer nid) {
       return organDao.queryById(nid);
    }

    /**
     * 分页查询
     */
    public List<Organ> queryAllByLimit(Map mp) {
       return organDao.queryAllByLimit(mp);
    }

    /**
     * 新增数据
     */
    public int insert(Organ organ) {
        return organDao.insert(organ);
    }

    /**
     * 修改数据
     */
    public boolean update(Organ organ) {
        return organDao.update(organ);
    }

    /**
     * 通过主键删除数据
     */
    public boolean deleteById(Integer id) {
        return organDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询
     */
    public List<Organ> queryCondition(Organ organ) {
        return organDao.queryCondition(organ);
    }


}
