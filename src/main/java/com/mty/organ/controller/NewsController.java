package com.mty.organ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.entity.News;
import com.mty.organ.entity.ParamQuery;
import com.mty.organ.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @description: 社团新闻控制层
 * @author: mty
 */
@RestController
@RequestMapping("news")
public class NewsController {

    // 依赖注入
    @Autowired
    private NewsService newsService;


    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<News> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<News> list = newsService.queryAllByLimit(mp);
        PageInfo<News> pageInfo = new PageInfo<News>(list);
        return pageInfo;
    }

    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody News news) {
        try {
            newsService.update(news);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
            return "201";
        }
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    public String add(@RequestBody News news) {
        try {
            Date date = new Date();
            news.setCreateTime(date);
            newsService.insert(news);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
            return "201";
        }
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("selectOne")
    public News selectOne(Integer id) {
        return newsService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            newsService.deleteById(id);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
            return "201";
        }
    }


    /**
     * 导出excel
     */
    @RequestMapping("/downExcel")
    public List<News> downExcel(){
        News news = new News();
        return newsService.queryCondition(news);
    }


}
