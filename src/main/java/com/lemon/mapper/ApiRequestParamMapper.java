package com.lemon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.pojo.ApiRequestParam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface ApiRequestParamMapper extends BaseMapper<ApiRequestParam> {
	
//	@Select("SELECT * FROM api_request_param WHERE api_id = #{apiId}")
	public List<ApiRequestParam> findAll(Integer apiId); 
}
