package com.mty.organ.service;

import com.mty.organ.mapper.AdminMapper;
import com.mty.organ.entity.Admin;
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
public class AdminService {

    @Autowired
    private AdminMapper adminDao;


    /**
     * 通过ID查询单条数据
     */
    public Admin queryById(Integer nid) {
       return adminDao.queryById(nid);
    }

    /**
     * 分页查询
     */
    public List<Admin> queryAllByLimit(Map mp) {
       return adminDao.queryAllByLimit(mp);
    }

    /**
     * 新增数据
     */
    public int insert(Admin admin) {
        return adminDao.insert(admin);
    }

    /**
     * 修改数据
     */
    public boolean update(Admin admin) {
        return adminDao.update(admin);
    }

    /**
     * 通过主键删除数据
     */
    public boolean deleteById(Integer id) {
        return adminDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询
     */
    public List<Admin> queryCondition(Admin admin) {
        return adminDao.queryCondition(admin);
    }


}
