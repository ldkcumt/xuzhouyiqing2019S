package com.dt.core.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.dt.response.Result;

/**
 * Created by lsx on 15/5/13.
 */
public class DefaultExceptionHandler extends AbstractHandlerExceptionResolver {
	@Override
	protected ModelAndView doResolveException(HttpServletRequest httpServletRequest,
			HttpServletResponse response, Object o, Exception e) {
		Result result = Result.create();
		result.setSuccess(false);
		if (!(e instanceof HHuavException)) {
			e.printStackTrace();
			e = new HHuavException(ErrorStatus.UNKOWN, "调用失败");
		}
		HHuavException ex1 = (HHuavException) e;
		// 设置错误编码
		result.setCode(ex1.getErrorStatus().getCode());
		// 设置错误描述
		result.setMessage(ex1.getLocalMessage());
		// 设置错误信息
		result.setError(ex1.getErrorStatus().getMessage());
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSON.toJSONString(result));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return new ModelAndView();
	}
}
