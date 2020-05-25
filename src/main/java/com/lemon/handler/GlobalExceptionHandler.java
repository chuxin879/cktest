package com.lemon.handler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lemon.common.Result;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(value=DuplicateKeyException.class)
	public Result duplicateKeyExceptionHander(HttpServletResponse response,DuplicateKeyException ex) {
		Result result = null;
		result  = new Result("0", "数据重复,请检查后提交");
		return result;
		
	}
	
	@ResponseBody
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public Result methodArgumentNotValidExceptionHandler(HttpServletResponse response, MethodArgumentNotValidException ex) {
		return new Result("99999", ex.getBindingResult().getFieldError().getDefaultMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
       
        return new Result("1", e.getMessage());
    }
	
	
}
