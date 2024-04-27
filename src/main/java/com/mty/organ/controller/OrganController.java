package com.mty.organ.controller;

import com.mty.organ.entity.User;
import com.mty.organ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.entity.Organ;
import com.mty.organ.entity.ParamQuery;
import com.mty.organ.service.OrganService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @description: 社团信息控制层
 * @author: mty
 */
@RestController
@RequestMapping("organ")
public class OrganController {

    // 依赖注入
    @Autowired
    private OrganService organService;
    @Autowired
    private UserService userService;

    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<Organ> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<Organ> list = organService.queryAllByLimit(mp);
        PageInfo<Organ> pageInfo = new PageInfo<Organ>(list);
        return pageInfo;
    }



    @PostMapping("selectByCondition")
    public List<Organ> selectByCondition(@RequestBody Map<String,String> mp) {
        List<Organ> list = organService.queryAllByLimit(mp);
        return list;
    }

    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody Organ organ) {
        try {
            organService.update(organ);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
            return "201";
        }
    }


    /**
     * 审批
     */
    @RequestMapping("shenpi")
    public String shenpi(@RequestBody Organ organ) {
        try {
            organService.update(organ);
            if(organ.getStatus().equals("02")){
                User user = new User();
                user.setId(Integer.parseInt(organ.getUid()));
                user.setType("01");
                userService.update(user);
            }
            if(organ.getStatus().equals("03")){
                Map mp = new HashMap();
                mp.put("uid",organ.getUid());
                mp.put("status","02");
                List<Organ> organs = organService.queryAllByLimit(mp);
                if(organs.size()==0){
                    User user = new User();
                    user.setId(Integer.parseInt(organ.getUid()));
                    user.setType("02");
                    userService.update(user);
                }
            }
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
    public String add(@RequestBody Organ organ) {
        try {
            organ.setStatus("01");
            Date date = new Date();
            organ.setCreateTime(date);
            organService.insert(organ);
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
    public Organ selectOne(Integer id) {
        return organService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            organService.deleteById(id);
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
    public List<Organ> downExcel(){
        Organ organ = new Organ();
        return organService.queryCondition(organ);
    }


}
