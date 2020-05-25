package com.lemon.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.pojo.Student;

/**
 * <p>
 * 学生表 Mapper 接口
 * </p>
 *
 * @author can
 * @since 2020-04-26
 */
public interface StudentMapper extends BaseMapper<Student> {
	
	
	/*
	 * 根据用户的输入信息进行检索
	 * 当用户只输入用户名时使用用户名检索
	 * 当用户输入性别时使用性别检索
	 * 当用户同时输入用户名和性别事使用用户名和性别检索
	 */
	public List<Student> selectByStudentSelective(Student student);
}
