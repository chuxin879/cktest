package com.lemon.service.impl;

import com.lemon.pojo.Emp;
import com.lemon.mapper.EmpMapper;
import com.lemon.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author can
 * @since 2020-04-26
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
