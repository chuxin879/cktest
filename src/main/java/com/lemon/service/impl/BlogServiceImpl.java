package com.lemon.service.impl;

import com.lemon.pojo.Blog;
import com.lemon.mapper.BlogMapper;
import com.lemon.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author can
 * @since 2020-04-26
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
