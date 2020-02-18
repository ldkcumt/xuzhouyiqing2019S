package com.dt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dt.controller.base.BaseController;
import com.dt.entity.EpidemicSituation;
import com.dt.service.EpidemicSituationService;
/**
* EpidemicSituation 控制器
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  []
*/
@RestController
@RequestMapping("/epidemicSituation")
public class EpidemicSituationController extends BaseController<EpidemicSituation> {

	private final Logger logger = LoggerFactory.getLogger(EpidemicSituationController.class);
	private EpidemicSituationService epidemicSituationService;

	@Autowired
	public EpidemicSituationController(EpidemicSituationService epidemicSituationService){
		this.epidemicSituationService=epidemicSituationService;
		this.baseService=epidemicSituationService;
		this.model="epidemicSituation";
	}
}
