package com.lemon.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.common.ApiClassificationVO;
import com.lemon.pojo.ApiClassification;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface ApiClassificationService extends IService<ApiClassification> {
	public List<ApiClassificationVO> getWithApi(Integer projectId);

}
