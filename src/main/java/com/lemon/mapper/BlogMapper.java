package com.lemon.mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.pojo.Blog;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author can
 * @since 2020-04-26
 */
public interface BlogMapper extends BaseMapper<Blog> {
	
	@Select({
		"<>"
		
	})
	public Blog get();

}
