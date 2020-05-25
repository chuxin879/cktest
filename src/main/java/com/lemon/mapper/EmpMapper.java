package com.lemon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.pojo.Emp;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author can
 * @since 2020-04-26
 */
public interface EmpMapper extends BaseMapper<Emp> {

	public Emp getEmpById_1(int id);
	
}
