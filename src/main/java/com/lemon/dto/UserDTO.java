package com.lemon.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDTO {
	
	
	@NotNull(message="用户名不能为空")	
	private String username;
	
	@NotNull(message="密码不能为空")	
	private String password;
}
