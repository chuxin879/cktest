package com.lemon.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.pojo.Suite;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface SuiteService extends IService<Suite> {
	
	public List<Suite> listSuite(Integer projectId);
}
