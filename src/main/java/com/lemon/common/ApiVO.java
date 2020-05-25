package com.lemon.common;

import java.util.ArrayList;
import java.util.List;

import com.lemon.pojo.Api;
import com.lemon.pojo.ApiRequestParam;
import lombok.Data;


@Data
public class ApiVO  extends Api{
	
	
	private String createUsername;
	private String host;
	
	private List<ApiRequestParam> requestParams = new ArrayList<>();
	private List<ApiRequestParam> headersParams = new ArrayList<>();
	private List<ApiRequestParam> bodyParams = new ArrayList<>();
	private List<ApiRequestParam> queryParams = new ArrayList<>();
	private List<ApiRequestParam> bodyRawParam = new ArrayList<>();
}
