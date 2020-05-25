package com.lemon.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.ApiClassificationVO;
import com.lemon.common.Result;
import com.lemon.pojo.ApiClassification;
import com.lemon.service.ApiClassificationService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@RestController
@RequestMapping("/apiClassification")
public class ApiClassificationController {
	
	@Autowired 
	private ApiClassificationService apiClassificationService;
	
	@GetMapping("/toIndex")
	public Result getWithApi(Integer projectId, Integer tab) {
		Result result = null;
		
		if(tab == 1 ) {
			//接口列表
			List<ApiClassificationVO> list = apiClassificationService.getWithApi(projectId);
			result = new Result("1", list, "select the classifiy and api");
		}else {
			
			//测试集合
		}
		return result;		
	}	
	
	
	//根据projectId 查表中的分类信息
	@GetMapping("/findAll")
	public Result findAll(Integer projectId) {
		Result result = null;
		QueryWrapper<ApiClassification>  queryWrapper = new QueryWrapper<>(); 
		queryWrapper.eq("project_id", projectId);
		List<ApiClassification> list = apiClassificationService.list(queryWrapper);
		result = new Result("1", list);
		return result;
	}

}
