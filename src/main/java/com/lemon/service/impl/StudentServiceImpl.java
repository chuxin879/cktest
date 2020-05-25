package com.lemon.service.impl;

import com.lemon.pojo.Student;
import com.lemon.mapper.StudentMapper;
import com.lemon.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author can
 * @since 2020-04-26
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
