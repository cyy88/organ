package com.mty.organ.service;

import com.mty.organ.mapper.ActivitiesMapper;
import com.mty.organ.entity.Activities;
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
public class ActivitiesService {

    @Autowired
    private ActivitiesMapper activitiesDao;


    /**
     * 通过ID查询单条数据
     */
    public Activities queryById(Integer nid) {
       return activitiesDao.queryById(nid);
    }

    /**
     * 分页查询
     */
    public List<Activities> queryAllByLimit(Map mp) {
       return activitiesDao.queryAllByLimit(mp);
    }

    /**
     * 新增数据
     */
    public int insert(Activities activities) {
        return activitiesDao.insert(activities);
    }

    /**
     * 修改数据
     */
    public boolean update(Activities activities) {
        return activitiesDao.update(activities);
    }

    /**
     * 通过主键删除数据
     */
    public boolean deleteById(Integer id) {
        return activitiesDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询
     */
    public List<Activities> queryCondition(Activities activities) {
        return activitiesDao.queryCondition(activities);
    }


}
