package com.mty.organ.service;

import com.mty.organ.mapper.AppointMapper;
import com.mty.organ.entity.Appoint;
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
public class AppointService {

    @Autowired
    private AppointMapper appointDao;


    /**
     * 通过ID查询单条数据
     */
    public Appoint queryById(Integer nid) {
       return appointDao.queryById(nid);
    }

    /**
     * 分页查询
     */
    public List<Appoint> queryAllByLimit(Map mp) {
       return appointDao.queryAllByLimit(mp);
    }

    /**
     * 新增数据
     */
    public int insert(Appoint appoint) {
        return appointDao.insert(appoint);
    }

    /**
     * 修改数据
     */
    public boolean update(Appoint appoint) {
        return appointDao.update(appoint);
    }

    /**
     * 通过主键删除数据
     */
    public boolean deleteById(Integer id) {
        return appointDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询
     */
    public List<Appoint> queryCondition(Appoint appoint) {
        return appointDao.queryCondition(appoint);
    }


}
