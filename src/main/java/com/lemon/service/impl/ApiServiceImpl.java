package com.lemon.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;

import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.common.ApiListVO;
import com.lemon.common.ApiRunResult;
import com.lemon.common.ApiVO;

import com.lemon.mapper.ApiMapper;
import com.lemon.pojo.Api;
import com.lemon.pojo.ApiRequestParam;
import com.lemon.service.ApiRequestParamService;
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
	
	@Autowired
	private ApiRequestParamService apiRequestParamService;
	
	
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
		Map<String, String> urlString = new HashMap<String, String>();
		for(ApiRequestParam apiReq : apiRequestParam) {
			if(3 == apiReq.getType()) {	                     //3请求头
				headers.add(apiReq.getName(), apiReq.getValue());
			}else if(4 == apiReq.getType() || 2 == apiReq.getType()) { //4或者2为请求体
				bodyParam.add(apiReq.getName(), apiReq.getValue());
			}else if(1 == apiReq.getType()) {
				
				urlString.put(apiReq.getName(), apiReq.getValue());
			}
			
		}
		
		
		ResponseEntity<String> resp = null;
		String method = apiRunVO.getMethod();
		Integer statusCode = null;
		String respBody = null;
		HttpHeaders respHeader = null;
		ApiRunResult apiRunResult = new ApiRunResult();
		try {
			if("get".equalsIgnoreCase(method)) {
				url = url + "?";
				Set<String> keySet= urlString.keySet();
				//集合转数组
				String[] keyArray = keySet.toArray(new String[keySet.size()]);
				Arrays.sort(keyArray);
				StringBuilder sb = new StringBuilder(url);
				for(int i=0; i<keyArray.length; i++) {
					if (i != i+1) {
						sb.append(keyArray[i]).append("=").append(urlString.get(keyArray[i])).append("&");
					}else if(i == i+1){
						sb.append(keyArray[i]).append("=").append(urlString.get(keyArray[i]));
					}
				}
				url = sb.toString();
				HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
//				resp = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
				resp = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
			}else if("post".equalsIgnoreCase(method)) {
				HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<>(bodyParam, headers);
				resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
				
				
			}
			
			statusCode = resp.getStatusCodeValue();
			respBody = resp.getBody();
			respHeader = resp.getHeaders();
			String respHeaderJson = JSON.toJSONString(respHeader);
			apiRunResult.setStatusCode(statusCode);
			apiRunResult.setHeaders(respHeaderJson);
			apiRunResult.setBody(respBody);
			
		} catch (HttpStatusCodeException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();

			//需要此时处理调用异常的情况
			statusCode = e.getRawStatusCode();
			respHeader = e.getResponseHeaders();
			respBody = e.getResponseBodyAsString();
			String respHeaderJson = JSON.toJSONString(respHeader);
			apiRunResult.setStatusCode(statusCode);
			apiRunResult.setHeaders(respHeaderJson);
			apiRunResult.setBody(respBody);
			
		}
		
		return apiRunResult;
		
		
	}
	
	
	
	@Override
	public void apiEdit(ApiVO apiEdit) {
		// TODO Auto-generated method stub
		
		System.out.println(apiEdit);
		this.updateById(apiEdit);
		QueryWrapper<ApiRequestParam> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("api_id", apiEdit.getId());
		apiRequestParamService.remove(queryWrapper);
		apiEdit.getRequestParams().addAll(apiEdit.getQueryParams());
		apiEdit.getRequestParams().addAll(apiEdit.getHeadersParams());
		apiEdit.getRequestParams().addAll(apiEdit.getBodyParams());
		apiEdit.getRequestParams().addAll(apiEdit.getBodyRawParam());
		apiRequestParamService.saveBatch(apiEdit.getRequestParams());
	
//		return new Result("1", "updata the api success");
		
		//方法移动到service层，实现同一事务提交
	}
}



