package com.lemon.controller;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.Result;
import com.lemon.dto.ProjectDTO;
import com.lemon.pojo.Project;
import com.lemon.pojo.User;
import com.lemon.service.ProjectService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private  ProjectService projectService;
	
//	@GetMapping("/toList")
//	public Result toList(Integer userId) {
//		Result result = null;
//		QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
//		queryWrapper.eq("create_user", userId);
//		List<Project> list = projectService.list(queryWrapper);
//		result = new Result("1", list, "project list");
//		return result;
//	}
	
	
	@GetMapping("/toList")
	public Result Tolist(Integer userId) {
		Result result = null;
		QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("create_user", userId);
		List<Project> list = projectService.list(queryWrapper);
		result = new Result("1", list, "project list");
		return result;	
	}
	
	
	
	
//	@PostMapping("/add")
//	public Result add(Project project) {
//		Result result = null;
//		User user = (User) SecurityUtils.getSubject().getPrincipal();
//		project.setCreateUser(user.getId());
//		
//		try {
//			projectService.save(project);
//			result = new Result("1", "save project success");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			result = new Result("1", "save project fail");
//		}
//		return result;	
//	}
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody @Validated  ProjectDTO projectDTO) {
		Result result = null;
		Project project = new Project();
		project.setName(projectDTO.getName());
		project.setHost(projectDTO.getHost());
		project.setDescription(projectDTO.getDescription());
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		project.setCreateUser(user.getId());
		projectService.save(project);
		result = new Result("1", "save project success");
		return result;
		
		
	}
	
	
	@GetMapping("/{projectId}")
	public Result getById(@PathVariable("projectId") Integer projectId) {
		Result result = null;
		Project project = projectService.getById(projectId);
		result = new Result("1", project, "select the project");
		return result;
		
	}
	
	@PutMapping("/{projectId}")
	public Result update(@PathVariable("projectId") Integer projectId,Project project) {
		Result result = null;
		project.setId(projectId);
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		project.setCreateUser(user.getId());
		
		projectService.updateById(project);
		result = new Result("1", project, "update project");
		return result;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
