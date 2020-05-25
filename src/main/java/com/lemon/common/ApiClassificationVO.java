package com.lemon.common;

import java.util.List;

import com.lemon.pojo.ApiClassification;

import io.swagger.annotations.Api;
import lombok.Data;


@Data
public class ApiClassificationVO extends ApiClassification{
	
	private List<Api> apis;

}
