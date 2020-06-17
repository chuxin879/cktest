package com.lemon.common;

import lombok.Data;



@Data
public class ApiRunResult {
	
	
	private Integer statusCode;
	private String headers;
	private String body;
	
	public ApiRunResult(Integer statusCode, String headers, String body) {
		super();
		this.statusCode = statusCode;
		this.headers = headers;
		this.body = body;
	}
	
	
	
	
}
