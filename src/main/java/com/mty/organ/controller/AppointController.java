package com.mty.organ.controller;

import com.mty.organ.entity.*;
import com.mty.organ.service.ActivitiesService;
import com.mty.organ.service.ApplyService;
import com.mty.organ.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.service.AppointService;
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
@RequestMapping("appoint")
public class AppointController {

    // 依赖注入
    @Autowired
    private AppointService appointService;
    @Autowired
    private OrganService organService;
    @Autowired
    private ActivitiesService activitiesService;
    @Autowired
    private ApplyService applyService;

    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<Appoint> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<Appoint> list = appointService.queryAllByLimit(mp);
        PageInfo<Appoint> pageInfo = new PageInfo<Appoint>(list);
        return pageInfo;
    }

    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody Appoint appoint) {
        try {
            appointService.update(appoint);
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
    public String add(@RequestBody Appoint appoint) {
        try {
            //用户比如加入该社团才能申请参加该社团活动
            Map applys = new HashMap();
            applys.put("uid",appoint.getUid());
            applys.put("status","02");
            List<Apply> applyList = applyService.queryAllByLimit(applys);
            Activities activities = activitiesService.queryById(Integer.parseInt(appoint.getAid()));
            boolean flag = false;
            for(int i=0;i<applyList.size();i++){
                if(applyList.get(i).getOid().equals(activities.getOid())){
                    flag=true;
                }
            }
            if(!flag){
                return "202";
            }
            Map mp = new HashMap();
            mp.put("uid",appoint.getUid());
            mp.put("aid",appoint.getAid());
            List<Appoint> appoints = appointService.queryAllByLimit(mp);
            if(appoints.size()>0){
                return "203";
            }
            Date date = new Date();
            appoint.setCreateTime(date);
            appointService.insert(appoint);
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
    public Appoint selectOne(Integer id) {
        return appointService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            appointService.deleteById(id);
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
    public List<Appoint> downExcel(){
        Appoint appoint = new Appoint();
        return appointService.queryCondition(appoint);
    }


}
