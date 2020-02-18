package com.dt.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dt.controller.base.BaseController;
import com.dt.core.exception.ErrorStatus;
import com.dt.core.exception.HHuavException;
import com.dt.entity.XzPatient;
import com.dt.response.Result;
import com.dt.service.XzPatientService;
/**
* XzPatient 控制器
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  []
*/
@RestController
@RequestMapping("/xzPatient")
public class XzPatientController extends BaseController<XzPatient> {

	private final Logger logger = LoggerFactory.getLogger(XzPatientController.class);
	private XzPatientService xzPatientService;

	@Autowired
	public XzPatientController(XzPatientService xzPatientService){
		this.xzPatientService=xzPatientService;
		this.baseService=xzPatientService;
		this.model="xzPatient";
	}
	@RequestMapping(value = "deleteById")
	public Result deleteById(HttpServletRequest request,Integer id) {
		 if(id==null) {
			throw new HHuavException(ErrorStatus.BAD_PARAM); 
		 }
		 XzPatient model=new XzPatient();
		 model.setId(id);
		  try {
			  xzPatientService.delete(model);
		  }catch(Exception e) {
			 throw new HHuavException(e.getMessage());
		  }
		return Result.create();
	}
}
