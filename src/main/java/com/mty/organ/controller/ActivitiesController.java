package com.mty.organ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.entity.Activities;
import com.mty.organ.entity.ParamQuery;
import com.mty.organ.service.ActivitiesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @description: 社团活动控制层
 * @author: mty
 */
@RestController
@RequestMapping("activities")
public class ActivitiesController {

    // 依赖注入
    @Autowired
    private ActivitiesService activitiesService;


    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<Activities> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<Activities> list = activitiesService.queryAllByLimit(mp);
        PageInfo<Activities> pageInfo = new PageInfo<Activities>(list);
        return pageInfo;
    }

    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody Activities activities) {
        try {
            activitiesService.update(activities);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
            return "201";
        }
    }

    /**
     * 新增
     */
    /**
     * 添加活动信息
     *
     * @param activities 接收前端传来的活动信息，是一个Activities对象
     * @return 返回操作结果，成功返回"200"，异常返回"201"
     */
    @RequestMapping("add")
    public String add(@RequestBody Activities activities) {
        try {
            // 设置创建时间为当前时间
            Date date = new Date();
            activities.setCreateTime(date);
            // 设置活动状态为"01"
            activities.setStatus("01");
            // 调用服务层方法，将活动信息插入数据库
            activitiesService.insert(activities);
            return "200";
        }catch (Exception e){
            // 捕获异常，打印堆栈信息
            e.printStackTrace();
            return "201";
        }
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("selectOne")
    public Activities selectOne(Integer id) {
        return activitiesService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            activitiesService.deleteById(id);
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
    public List<Activities> downExcel(){
        Activities activities = new Activities();
        return activitiesService.queryCondition(activities);
    }


}
