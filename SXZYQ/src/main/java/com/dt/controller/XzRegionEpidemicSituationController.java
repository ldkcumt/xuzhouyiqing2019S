package com.dt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dt.controller.base.BaseController;
import com.dt.entity.XzRegionEpidemicSituation;
import com.dt.service.XzRegionEpidemicSituationService;
/**
* XzRegionEpidemicSituation 控制器
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  []
*/
@RestController
@RequestMapping("/xzRegionEpidemicSituation")
public class XzRegionEpidemicSituationController extends BaseController<XzRegionEpidemicSituation> {

	private final Logger logger = LoggerFactory.getLogger(XzRegionEpidemicSituationController.class);
	private XzRegionEpidemicSituationService xzRegionEpidemicSituationService;

	@Autowired
	public XzRegionEpidemicSituationController(XzRegionEpidemicSituationService xzRegionEpidemicSituationService){
		this.xzRegionEpidemicSituationService=xzRegionEpidemicSituationService;
		this.baseService=xzRegionEpidemicSituationService;
		this.model="xzRegionEpidemicSituation";
	}
}
