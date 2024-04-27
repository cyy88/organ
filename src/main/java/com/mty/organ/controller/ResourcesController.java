package com.mty.organ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.entity.Resources;
import com.mty.organ.entity.ParamQuery;
import com.mty.organ.service.ResourcesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @description: 共享资源控制层
 * @author: mty
 */
@RestController
@RequestMapping("resources")
public class ResourcesController {

    // 依赖注入
    @Autowired
    private ResourcesService resourcesService;


    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<Resources> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<Resources> list = resourcesService.queryAllByLimit(mp);
        PageInfo<Resources> pageInfo = new PageInfo<Resources>(list);
        return pageInfo;
    }

    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody Resources resources) {
        try {
            resourcesService.update(resources);
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
    public String add(@RequestBody Resources resources) {
        try {
            Date date = new Date();
            resources.setCreateTime(date);
            resourcesService.insert(resources);
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
    public Resources selectOne(Integer id) {
        return resourcesService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            resourcesService.deleteById(id);
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
    public List<Resources> downExcel(){
        Resources resources = new Resources();
        return resourcesService.queryCondition(resources);
    }


}
