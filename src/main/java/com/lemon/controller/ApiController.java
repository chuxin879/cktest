package com.lemon.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.ApiListVO;
import com.lemon.common.ApiRunResult;
import com.lemon.common.ApiVO;
import com.lemon.common.Result;
import com.lemon.pojo.ApiRequestParam;
import com.lemon.service.ApiRequestParamService;
import com.lemon.service.ApiService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private ApiRequestParamService apiRequestParamService;
	
	@GetMapping("/showApiUnderProject")
	public Result showApiListByProjectId(Integer projectId) {
		Result result = null;
		
//		QueryWrapper<ApiListVO> queryWrapper = new QueryWrapper<>();
//		QueryWrapper.
		
		List<ApiListVO> list = apiService.showApiListByProject(projectId);
		result = new Result("1", list, "get the apiList by projectId");
		return result;
	}
	
	
	@GetMapping("/showApiUnderApiClassification")
	public Result showApiListByClassificationId(Integer apiClassificationId){
		Result result = null;
		List<ApiListVO> list = apiService.showApiListByClassificationId(apiClassificationId);
		result = new Result("1", list, "get the apilist by apiClassificationId");
		return result;
	}
	
	@GetMapping("/toApiView")
	public Result findapiVO(Integer apiId) {
		Result result = null;
		ApiVO apiVo = apiService.findApiVO(apiId);
		result = new Result("1", apiVo, "get apiVo");
		return result;
	}
	
	@PostMapping("/apiEdit")
	public Result apiEdit(ApiVO apiEdit) {
		apiService.apiEdit(apiEdit);
		return new Result("1", "updata the api success");
		
	}
	
	@PostMapping("/run")
	public Result run(ApiVO apiRunVO) {
		
		ApiRunResult apiRunresult = apiService.run(apiRunVO);
		Result result = new Result("1",apiRunresult);
		return result;                                                                                       
	}
	
	
	

}
