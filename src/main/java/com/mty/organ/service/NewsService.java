package com.mty.organ.service;

import com.mty.organ.mapper.NewsMapper;
import com.mty.organ.entity.News;
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
public class NewsService {

    @Autowired
    private NewsMapper newsDao;


    /**
     * 通过ID查询单条数据
     */
    public News queryById(Integer nid) {
       return newsDao.queryById(nid);
    }

    /**
     * 分页查询
     */
    public List<News> queryAllByLimit(Map mp) {
       return newsDao.queryAllByLimit(mp);
    }

    /**
     * 新增数据
     */
    public int insert(News news) {
        return newsDao.insert(news);
    }

    /**
     * 修改数据
     */
    public boolean update(News news) {
        return newsDao.update(news);
    }

    /**
     * 通过主键删除数据
     */
    public boolean deleteById(Integer id) {
        return newsDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询
     */
    public List<News> queryCondition(News news) {
        return newsDao.queryCondition(news);
    }


}
