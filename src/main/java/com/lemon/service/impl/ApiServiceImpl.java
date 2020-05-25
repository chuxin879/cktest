package com.lemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.common.ApiListVO;
import com.lemon.common.ApiVO;
import com.lemon.mapper.ApiMapper;
import com.lemon.pojo.Api;
import com.lemon.service.ApiService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService {
	
	@Autowired
	private ApiMapper apiMapper;
	
	public List<ApiListVO> showApiListByProject(Integer projectId){
		return apiMapper.showApiListByProject(projectId);
	}
	
	
	public List<ApiListVO> showApiListByClassificationId(Integer apiClassificationId){
		return apiMapper.showApiLiarByClassifiacationId(apiClassificationId);
		
	}
	
	@Override
	public ApiVO findApiVO(Integer apiId) {
		// TODO Auto-generated method stub
		return apiMapper.findApiVO(apiId);
	}
}

