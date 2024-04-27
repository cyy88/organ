package com.mty.organ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.entity.Notice;
import com.mty.organ.entity.ParamQuery;
import com.mty.organ.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @description: 公告控制层
 * @author: mty
 */
@RestController
@RequestMapping("notice")
public class NoticeController {

    // 依赖注入
    @Autowired
    private NoticeService noticeService;


    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<Notice> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<Notice> list = noticeService.queryAllByLimit(mp);
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(list);
        return pageInfo;
    }

    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody Notice notice) {
        try {
            noticeService.update(notice);
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
    public String add(@RequestBody Notice notice) {
        try {
            Date date = new Date();
            notice.setCreateTime(date);
            noticeService.insert(notice);
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
    public Notice selectOne(Integer id) {
        return noticeService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            noticeService.deleteById(id);
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
    public List<Notice> downExcel(){
        Notice notice = new Notice();
        return noticeService.queryCondition(notice);
    }


}
