package com.lemon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.mapper.SuiteMapper;
import com.lemon.pojo.Suite;
import com.lemon.service.SuiteService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@Service
public class SuiteServiceImpl extends ServiceImpl<SuiteMapper, Suite> implements SuiteService {
	
	
	@Autowired
	private SuiteMapper suiteMapper;
	
	@Override
	public List<Suite> listSuite(Integer projectId) {
		// TODO Auto-generated method stub
		return suiteMapper.listSuit(projectId);
	}
	
	
}
