package com.lemon.controller;





import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.Result;
import com.lemon.dto.UserDTO;
import com.lemon.pojo.User;
import com.lemon.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@RestController //
@RequestMapping("/user")
@Api("用户模块")
//@CrossOrigin
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	//注册方法Post
	
	@PostMapping("/register")
	@ApiOperation(value="注册方法", httpMethod="POST")
	public Result register(User user) {
		//调用业务层方法，插入到DB,统一处理异常
		
		userService.save(user);
		Result result = new Result("1", "注册成功");
		return result;
	}
	
	//账号验重
	@GetMapping("/find")
	@ApiOperation(value="账号验重", httpMethod="GET")
	public Result find(String username) {
		Result result = null;
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);
		User user = userService.getOne(queryWrapper);
	
		if(user == null) {
			result = new Result("1", "the username is not exist");
		}else {
			result = new Result("0", "the username is already exist");
		}
		return result;
	}
		
		
	//登录方法	
	@PostMapping("/login")
	@ApiOperation(value="登录", httpMethod="POST")
	public Result login(@RequestBody UserDTO user) {
		
		//shiro
		Result result = null;
		try {
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			Subject subject = SecurityUtils.getSubject();
			subject.login(usernamePasswordToken);
			//将sessionid 返回回去
//			String sessionId = (String) subject.getSession().getId();
			String sessionId = (String) SecurityUtils.getSubject().getSession().getId();
			User loginUser = (User) subject.getPrincipal();
			result = new Result("1", loginUser.getId(), sessionId);
//			System.out.print("________________________________________");
		} catch (AuthenticationException e) {
			
			// TODO Auto-generated catch block
			if(e instanceof UnknownAccountException) {
				result =  new Result("0", "username is not exists");
			}else {
				result = new Result("0", "password error");
			}
		
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	@GetMapping("/logout")
	@ApiOperation(value="退出", httpMethod="GET")
	public Result logout(User user) {
		Result result = null;
		//
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		result = new Result("1", "account is not login");
		return result;
	}
	
	@GetMapping("/unauth")
	@ApiOperation(value="未授权", httpMethod="GET")
	public Result unauth() {
		Result result = null;
		result = new Result("1", "account is not login");
		return result;	
	}
	
	
	
}
