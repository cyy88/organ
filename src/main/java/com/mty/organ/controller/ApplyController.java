package com.mty.organ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.entity.Apply;
import com.mty.organ.entity.ParamQuery;
import com.mty.organ.service.ApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @description: 社团申请控制层
 * @author: mty
 */
@RestController
@RequestMapping("apply")
public class ApplyController {

    // 依赖注入
    @Autowired
    private ApplyService applyService;


    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<Apply> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<Apply> list = applyService.queryAllByLimit(mp);
        PageInfo<Apply> pageInfo = new PageInfo<Apply>(list);
        return pageInfo;
    }

    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody Apply apply) {
        try {
            applyService.update(apply);
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
    public String add(@RequestBody Apply apply) {
        try {
            Map mp = new HashMap();
            mp.put("uid",apply.getUid());
            mp.put("oid",apply.getOid());
            mp.put("pstatus","1");
            List<Apply> applies = applyService.queryAllByLimit(mp);
            if(applies.size()>0){
                return "202";
            }
            apply.setStatus("01");
            Date date = new Date();
            apply.setCreateTime(date);
            applyService.insert(apply);
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
    public Apply selectOne(Integer id) {
        return applyService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            applyService.deleteById(id);
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
    public List<Apply> downExcel(){
        Apply apply = new Apply();
        return applyService.queryCondition(apply);
    }


}
