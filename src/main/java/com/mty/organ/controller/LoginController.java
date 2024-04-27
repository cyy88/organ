package com.mty.organ.controller;


import com.mty.organ.entity.Admin;
import com.mty.organ.entity.User;
import com.mty.organ.service.AdminService;
import com.mty.organ.service.UserService;
import com.mty.organ.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 系统操作控制器
 */
@RestController
public class LoginController {

	// 依赖注入
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;


	/**
	 * 管理员登录
	 */
	@RequestMapping(value = "/")
	public String gologin() {
		return "login";
	}


	/**
	 * 登录
	 */
	@PostMapping("login")
	public Result login(@RequestBody HashMap<String, String> map, HttpSession session) {
		String type = map.get("type");
		if(type!=null && type.equals("")){
			return Result.error("请选择用户类型！");
		}
		if(type.equals("01")){
			List<Admin> admins = adminService.queryAllByLimit(map);
			if (admins != null && admins.size()>0) {
				User user = new User();
				user.setId(admins.get(0).getId());
				user.setUsername(admins.get(0).getUsername());
				user.setPassword(admins.get(0).getPassword());
				user.setType(map.get("type"));
				session.setAttribute("userInfo", user);
				session.setAttribute("type", map.get("type"));
				return Result.success("登录成功", user);
			}else{
				return Result.error("用户名或密码错误");
			}
		}else{
			User user = new User();
			user.setUsername(map.get("username"));
			user.setPassword(map.get("password"));
			String typeTemp = map.get("type");
			if(typeTemp.equals("02")){
				user.setType("01");
			}else{
				user.setType("02");
			}
			List<User> users = userService.queryCondition(user);
			if (users != null && users.size()>0) {
				session.setAttribute("userInfo", users.get(0));
				session.setAttribute("type", users.get(0).getType());
				return Result.success("登录成功", users.get(0));
			}else{
				return Result.error("用户名或密码错误");
			}
		}
	}

	/**
	 * 注册
	 */
	@PostMapping("register")
	public Result register(@RequestBody HashMap<String, String> map) {
		if (!map.get("password").equals(map.get("repassword")))
			return Result.error("请输入两次相同密码");
		User user = new User();
		String username = map.get("username");
		String password = map.get("password");
		user.setUsername(username);
		user.setPassword(password);
		user.setType("02");
		List<User> villagers = userService.queryCondition(new User());
		for(int i=0;i<villagers.size();i++){
			if(user.getUsername().equals(villagers.get(i).getUsername())){
				return Result.error("用户名已注册，请重试！");
			}
		}
		Date date = new Date();
		user.setCreateTime(date);
		userService.insert(user);
		return Result.success("注册成功");
	}


}
