package com.lemon.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.common.ApiListVO;
import com.lemon.common.ApiRunResult;
import com.lemon.common.ApiVO;
import com.lemon.mapper.ApiMapper;
import com.lemon.pojo.Api;
import com.lemon.pojo.ApiRequestParam;
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
	
	
	@Override
	public List<ApiListVO> showApiListByProject(Integer projectId){
		return apiMapper.showApiListByProject(projectId);
	}
	
	@Override
	public List<ApiListVO> showApiListByClassificationId(Integer apiClassificationId){
		return apiMapper.showApiLiarByClassifiacationId(apiClassificationId);
		
	}
	
	@Override
	public ApiVO findApiVO(Integer apiId) {
		// TODO Auto-generated method stub
		return apiMapper.findApiVO(apiId);
	}
	
	
	@Override
	public ApiRunResult run(ApiVO apiRunVO) {
		
		String url = apiRunVO.getHost() + apiRunVO.getUrl();
		RestTemplate restTemplate = new RestTemplate();
		List<ApiRequestParam> apiRequestParam = apiRunVO.getRequestParams();
		LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		LinkedMultiValueMap<String, String> bodyParam = new LinkedMultiValueMap<>();
		Map<String, Object> urlParams = new HashMap<>();
		for(ApiRequestParam apiReq : apiRequestParam) {
			if(3 == apiReq.getType()) {	
				headers.add(apiReq.getName(), apiReq.getValue());
			}else if(4 == apiReq.getType() || 2 == apiReq.getType()) {
				bodyParam.add(apiReq.getName(), apiReq.getValue());
			}else if(1 == apiReq.getType()) {
				urlParams.put(apiReq.getName(), apiReq.getValue());
			}
		}
		ResponseEntity<String> resp = null;
		String method = apiRunVO.getMethod();
		
		if("get".equalsIgnoreCase(method)) {
			HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
			resp = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class, urlParams);
		}else if("post".equalsIgnoreCase(method)) {
			HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<>(bodyParam, headers);
			resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		}
		
		Integer statusCode = resp.getStatusCodeValue();
		String respBody = resp.getBody();
		HttpHeaders respHeader = resp.getHeaders();
		String respHeaderJson = JSON.toJSONString(respHeader);
		ApiRunResult apiRunResult = new ApiRunResult(statusCode, respHeaderJson, respBody);
		return apiRunResult;
		
	}
}

