package com.lemon.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProjectDTO {
	
	@NotNull(message="名称不能为空")	
    private String name;
	
    private String host;

    private String description;

  

}
