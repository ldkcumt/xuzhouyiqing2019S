package com.dt.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dt.controller.base.BaseController;
import com.dt.core.exception.HHuavException;
import com.dt.entity.XzEpidemicSituation;
import com.dt.response.Result;
import com.dt.service.XzEpidemicSituationService;
/**
* XzEpidemicSituation 控制器
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  []
*/
@RestController
@RequestMapping("/xzEpidemicSituation")
public class XzEpidemicSituationController extends BaseController<XzEpidemicSituation> {

	private final Logger logger = LoggerFactory.getLogger(XzEpidemicSituationController.class);
	private XzEpidemicSituationService xzEpidemicSituationService;

	@Autowired
	public XzEpidemicSituationController(XzEpidemicSituationService xzEpidemicSituationService){
		this.xzEpidemicSituationService=xzEpidemicSituationService;
		this.baseService=xzEpidemicSituationService;
		this.model="xzEpidemicSituation";
	}
	@RequestMapping(value = "/getXzYq")
	public Result getXzYq(HttpServletRequest request) {
		  XzEpidemicSituation res=null;
		  try {
			  res=xzEpidemicSituationService.getXzTotalYq();
		  }catch(Exception e) {
			 throw new HHuavException(e.getMessage());
		  }
		return Result.create().add("total",res);
	}
	
}
