package com.mty.organ.controller;

import com.mty.organ.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.entity.Admin;
import com.mty.organ.entity.ParamQuery;
import com.mty.organ.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @description: 管理员控制层
 * @author: mty
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    // 依赖注入
    @Autowired
    private AdminService adminService;


    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<Admin> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<Admin> list = adminService.queryAllByLimit(mp);
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(list);
        return pageInfo;
    }

    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody Admin admin) {
        try {
            List<Admin> adminList = adminService.queryCondition(new Admin());
            for(int i=0;i<adminList.size();i++){
                if(admin.getUsername().equals(adminList.get(i).getUsername()) && !adminList.get(i).getId().equals(admin.getId())){
                    return "202";
                }
            }
            adminService.update(admin);
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
    public String add(@RequestBody Admin admin) {
        try {
            List<Admin> adminList = adminService.queryCondition(new Admin());
            for(int i=0;i<adminList.size();i++){
                if(admin.getUsername().equals(adminList.get(i).getUsername())){
                    return "202";
                }
            }
            Date date = new Date();
            admin.setCreateTime(date);
            adminService.insert(admin);
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
    public Admin selectOne(Integer id) {
        return adminService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            adminService.deleteById(id);
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
    public List<Admin> downExcel(){
        Admin admin = new Admin();
        return adminService.queryCondition(admin);
    }


}
