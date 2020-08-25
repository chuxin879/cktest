package com.lemon.service;

import com.lemon.common.ApiVO;
import com.lemon.dto.CaseListDTO;
import com.lemon.pojo.Cases;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface CasesService extends IService<Cases> {
	
	public void add(Cases caseVO,  ApiVO apiVo);
	
	public List<CaseListDTO> showCasesUnderProject(Integer projectId);
	
	public List<CaseListDTO> showCasesUnderSuit(Integer suitId);
	
	
	

}
