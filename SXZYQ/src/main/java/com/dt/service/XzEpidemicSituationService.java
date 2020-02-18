package com.dt.service;

import com.dt.entity.XzEpidemicSituation;
import com.dt.service.base.BaseService; 
/**
* XzEpidemicSituation业务操作接口
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  [产品/模块版本]
*/
public interface XzEpidemicSituationService extends BaseService {
	XzEpidemicSituation getXzTotalYq();
	int updateYQ();

}