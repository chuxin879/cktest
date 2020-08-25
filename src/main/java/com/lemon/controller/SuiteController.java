package com.lemon.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.Result;
import com.lemon.pojo.Suite;
import com.lemon.service.SuiteService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@RestController
@RequestMapping("/suite")
public class SuiteController {
	
	@Autowired
	private SuiteService suiteService;
	
	
	
	@GetMapping("/listAll")
	public Result findAll(Integer projectId) {
		
		QueryWrapper<Suite> queryWrapper = new QueryWrapper<Suite>();
		queryWrapper.eq("project_id", projectId);
		List<Suite> list = suiteService.list(queryWrapper);
		return new Result("1", list);
		
	}
	
	@GetMapping("index2")
	public Result index2(Integer projectId) {
		List<Suite> suites = suiteService.listSuite(projectId);
		return new Result("1", suites, "get suite success");
	}
}
