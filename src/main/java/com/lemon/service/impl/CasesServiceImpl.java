package com.lemon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.common.ApiVO;
import com.lemon.dto.CaseListDTO;
import com.lemon.mapper.CasesMapper;
import com.lemon.pojo.ApiRequestParam;
import com.lemon.pojo.CaseParamValue;
import com.lemon.pojo.Cases;
import com.lemon.service.CaseParamValueService;
import com.lemon.service.CasesService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@Service
public class CasesServiceImpl extends ServiceImpl<CasesMapper, Cases> implements CasesService {
	
	
	@Autowired
	private  CaseParamValueService caseParamValueService;
	
	@Autowired
	private CasesMapper casesMapper;
	
	
	
	//添加case
	public void add(Cases caseVO,  ApiVO apiVO) {
		this.save(caseVO);
		List<CaseParamValue> list = new ArrayList<CaseParamValue>();
		for(ApiRequestParam apiRequestParam: apiVO.getRequestParams()) {
			CaseParamValue caseParmValue = new CaseParamValue();
			caseParmValue.setCaseId(caseVO.getId());
			caseParmValue.setApiRequestParamId(apiRequestParam.getId());
			caseParmValue.setApiRequestParamValue(apiRequestParam.getValue());
			list.add(caseParmValue);
		}
		
		caseParamValueService.saveBatch(list);
	};
	
	
	@Override
	public List<CaseListDTO> showCasesUnderProject(Integer projectId) {
		// TODO Auto-generated method stub
		return casesMapper.showCasesUnderProject(projectId);
	}
	
	
	
	@Override
	public List<CaseListDTO> showCasesUnderSuit(Integer suitId) {
		// TODO Auto-generated method stub
		return casesMapper.showCasesUnderSuit(suitId);
	}
	
 
	
	
	
	

}
