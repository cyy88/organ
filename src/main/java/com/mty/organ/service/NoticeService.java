package com.mty.organ.service;

import com.mty.organ.mapper.NoticeMapper;
import com.mty.organ.entity.Notice;
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
public class NoticeService {

    @Autowired
    private NoticeMapper noticeDao;


    /**
     * 通过ID查询单条数据
     */
    public Notice queryById(Integer nid) {
       return noticeDao.queryById(nid);
    }

    /**
     * 分页查询
     */
    public List<Notice> queryAllByLimit(Map mp) {
       return noticeDao.queryAllByLimit(mp);
    }

    /**
     * 新增数据
     */
    public int insert(Notice notice) {
        return noticeDao.insert(notice);
    }

    /**
     * 修改数据
     */
    public boolean update(Notice notice) {
        return noticeDao.update(notice);
    }

    /**
     * 通过主键删除数据
     */
    public boolean deleteById(Integer id) {
        return noticeDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询
     */
    public List<Notice> queryCondition(Notice notice) {
        return noticeDao.queryCondition(notice);
    }


}
