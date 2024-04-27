package com.mty.organ.controller;

import com.mty.organ.entity.Organ;
import com.mty.organ.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.mty.organ.entity.User;
import com.mty.organ.entity.ParamQuery;
import com.mty.organ.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @description: 用户控制层
 * @author: mty
 */
@RestController
@RequestMapping("user")
public class UserController {

    // 依赖注入
    @Autowired
    private UserService userService;


    /**
     * 分页查询
     */
    @PostMapping("selectAll")
    public PageInfo<User> selectAll(@RequestBody Map<String,String> mp) {
        PageHelper.startPage(Integer.parseInt(mp.get("currentPage").toString()), Integer.parseInt(mp.get("pagesize").toString()));
        List<User> list = userService.queryAllByLimit(mp);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo;
    }

    @PostMapping("selectByCondition")
    public List<User> selectByCondition(@RequestBody Map<String,String> mp) {
        List<User> list = userService.queryAllByLimit(mp);
        return list;
    }

    /**
     * 更新信息
     */
    @RequestMapping("update")
    public Result update(@RequestBody User user) {
        Result result = new Result();
        try {
            User userCon = new User();
            userCon.setUsername(user.getUsername());
            List<User> users = userService.queryCondition(userCon);
            if(users.size()>0 && !users.get(0).getId().equals(user.getId())){
                result.setCode(202);
                return result;
            }
            userService.update(user);
            User user1 = userService.queryById(user.getId());
            result.setCode(200);
            result.setData(user1);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(201);
            return result;
        }
    }


    /**
     * 修改
     */
    @RequestMapping("edit")
    public String edit(@RequestBody User user) {
        try {
            List<User> userList = userService.queryCondition(new User());
            for(int i=0;i<userList.size();i++){
                if(user.getUsername().equals(userList.get(i).getUsername()) && !userList.get(i).getId().equals(user.getId())){
                    return "202";
                }
            }
            userService.update(user);
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
    public String add(@RequestBody User user) {
        try {
            List<User> userList = userService.queryCondition(new User());
            for(int i=0;i<userList.size();i++){
                if(user.getUsername().equals(userList.get(i).getUsername())){
                    return "202";
                }
            }
            user.setType("02");
            Date date = new Date();
            user.setCreateTime(date);
            userService.insert(user);
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
    public User selectOne(Integer id) {
        return userService.queryById(id);
    }


    /**
     * 通过主键删除数据
     */
    @GetMapping("deleteById")
    public String deleteById(Integer id) {
        try {
            userService.deleteById(id);
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
    public List<User> downExcel(){
        User user = new User();
        return userService.queryCondition(user);
    }


}
