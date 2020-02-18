package com.dt.service.impl;

import org.springframework.stereotype.Service;
import com.dt.service.impl.base.BaseServiceImpl; 
import com.dt.service.EpidemicSituationService; 

/**
* EpidemicSituation业务操作接口实现
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  [产品/模块版本]
*/
@Service
public class EpidemicSituationServiceImpl extends BaseServiceImpl implements EpidemicSituationService {

	public EpidemicSituationServiceImpl() {
		super();
		this.mapper="EpidemicSituationMapper";
	}
}
