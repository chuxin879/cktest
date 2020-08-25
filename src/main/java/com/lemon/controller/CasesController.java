package com.lemon.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lemon.common.ApiVO;
import com.lemon.common.Result;
import com.lemon.dto.CaseListDTO;
import com.lemon.pojo.Cases;
import com.lemon.service.CasesService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@RestController
@RequestMapping("/cases")
public class CasesController {
	
	@Autowired
	private CasesService casesService;
	
	
	@PostMapping("/add")
	public Result addCase(Cases caseVO, ApiVO apiVO) {
		
		try {
			casesService.add(caseVO, apiVO);
			return new Result("1", "save success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result("0", "" + e);
		}
	}
	
	@GetMapping("/findCasesUnderProject")
	public Result showCasesUnderProject(Integer projectId){
		
		List<CaseListDTO> caseList = casesService.showCasesUnderProject(projectId);
		return new Result("1", caseList);
		
	}
	
	
	@GetMapping("findCasesUnderSuit")
	public Result showCasesUnderSuit(Integer suitId){
		List<CaseListDTO> casesList = casesService.showCasesUnderSuit(suitId);
		return new Result("1", casesList);
		
	}
	
	
	
	

}
