package com.lemon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.dto.CaseListDTO;
import com.lemon.pojo.Cases;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
public interface CasesMapper extends BaseMapper<Cases> {

	@Select("SELECT * FROM cases where suite_id = #{suitId}")
	public List<Cases> listCases(Integer suitId);
	
	@Select("SELECT DISTINCT\r\n" + 
			"	t1.*,\r\n" + 
			"	t6.id as apiId, \r\n" + 
			"	t6.name as apiName, \r\n" +
			"	t6.create_time as apiCreateTime, \r\n" +
			"	t6.url \r\n " +
			"FROM\r\n" + 
			"	cases t1\r\n" + 
			"	LEFT JOIN suite t2 ON t1.suite_id = t2.id\r\n" + 
			"	LEFT JOIN project t3 ON t2.project_id = t3.id\r\n" + 
			"	LEFT JOIN case_param_value t4 ON t1.id = t4.case_id\r\n" + 
			"	LEFT JOIN api_request_param t5 ON t4.api_request_param_id = t5.id\r\n" + 
			"	LEFT JOIN api t6 ON t5.api_id = t6.id \r\n" + 
			"WHERE\r\n" + 
			"	t3.id = #{projectId}")
	public List<CaseListDTO> showCasesUnderProject(Integer projectId);
	
	
	
	
	@Select("SELECT DISTINCT\r\n" + 
			"	t1.*,\r\n" + 
			"	t6.id as api_id \r\n" + 
			"FROM\r\n" + 
			"	cases t1\r\n" + 
			"	LEFT JOIN suite t2 ON t1.suite_id = t2.id\r\n" + 
			"	LEFT JOIN case_param_value t4 ON t1.id = t4.case_id\r\n" + 
			"	LEFT JOIN api_request_param t5 ON t4.api_request_param_id = t5.id\r\n" + 
			"	LEFT JOIN api t6 ON t5.api_id = t6.id \r\n" + 
			"WHERE\r\n" + 
			"	t1.suite_id = #{suitId}")
	public List<CaseListDTO> showCasesUnderSuit(Integer suitId);
}



