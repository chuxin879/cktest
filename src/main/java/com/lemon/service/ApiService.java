package com.lemon.service;

import com.lemon.common.ApiListVO;
import com.lemon.common.ApiRunResult;
import com.lemon.common.ApiVO;
import com.lemon.pojo.Api;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface ApiService extends IService<Api> {

	public List<ApiListVO> showApiListByProject(Integer projectId);
	
	public List<ApiListVO> showApiListByClassificationId(Integer apiClassificationId);
	
	public ApiVO findApiVO(Integer apiId);
	
	public ApiRunResult run(ApiVO apiRunVO);
	
	public void apiEdit(ApiVO apiEdit);
}

