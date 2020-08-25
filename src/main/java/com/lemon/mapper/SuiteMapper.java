package com.lemon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.lemon.pojo.Suite;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface SuiteMapper extends BaseMapper<Suite> {
	
	
	@Select("SELECT * FROM  suite WHERE project_id = #{projectId}")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="cases", column="id", many=@Many(select="com.lemon.mapper.CasesMapper.listCases"))
	})
	public List<Suite> listSuit(Integer projectId);
}
