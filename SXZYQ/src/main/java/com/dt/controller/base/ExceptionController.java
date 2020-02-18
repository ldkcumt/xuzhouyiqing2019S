package com.dt.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dt.core.exception.ErrorStatus;
import com.dt.core.exception.HHuavException;
import com.dt.response.Result;

/**
 * 统一异常处理
 * @author administrator
 * @date ${date}
 */
@RestControllerAdvice
public class ExceptionController {
	private Logger log = LoggerFactory.getLogger(ExceptionController.class);
	@ExceptionHandler
	public Result handleException(Exception e){
		log.info(e.getMessage());
		if (!(e instanceof HHuavException)) {
			e = new HHuavException(ErrorStatus.UNKOWN, e.getMessage());
		}
		HHuavException ex1 = (HHuavException) e;
		
		return Result.create().fail(ex1.getErrorStatus().getMessage(),ex1.getErrorStatus().getCode(),ex1.getLocalMessage());
	}

}