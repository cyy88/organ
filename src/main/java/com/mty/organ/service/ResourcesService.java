package com.mty.organ.service;

import com.mty.organ.mapper.ResourcesMapper;
import com.mty.organ.entity.Resources;
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
public class ResourcesService {

    @Autowired
    private ResourcesMapper resourcesDao;


    /**
     * 通过ID查询单条数据
     */
    public Resources queryById(Integer nid) {
       return resourcesDao.queryById(nid);
    }

    /**
     * 分页查询
     */
    public List<Resources> queryAllByLimit(Map mp) {
       return resourcesDao.queryAllByLimit(mp);
    }

    /**
     * 新增数据
     */
    public int insert(Resources resources) {
        return resourcesDao.insert(resources);
    }

    /**
     * 修改数据
     */
    public boolean update(Resources resources) {
        return resourcesDao.update(resources);
    }

    /**
     * 通过主键删除数据
     */
    public boolean deleteById(Integer id) {
        return resourcesDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询
     */
    public List<Resources> queryCondition(Resources resources) {
        return resourcesDao.queryCondition(resources);
    }


}
