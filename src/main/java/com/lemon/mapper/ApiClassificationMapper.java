package com.lemon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.common.ApiClassificationVO;
import com.lemon.pojo.ApiClassification;



/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface ApiClassificationMapper extends BaseMapper<ApiClassification> {
	
	
//	//两表延迟加载  先查询分类信息，（List<api>） 按需加载
//	@Select("SELECT * FROM api_classification WHERE project_id = #{projectId}")
//	@Results({
//		@Result(property="apisapissp", column="id", many=@Many(select="com.lemon.mapper.ApiMapper.findApi")),
//		@Result(property="id", column="id")
//	})
//	public List<ApiClassificationVO> getWithApi(Integer projectId);
	
	
	@Select("SELECT * FROM  api_classification WHERE project_id = #{projectId}")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="apis", column="id", many=@Many(select="com.lemon.mapper.ApiMapper.findApi"))
	
	})
	public List<ApiClassificationVO> getWithApi(Integer projectId);
	
}
