package com.dt.service;

import java.util.List;

import com.dt.entity.XzRegionEpidemicSituation;
import com.dt.service.base.BaseService; 
/**
* XzRegionEpidemicSituation业务操作接口
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  [产品/模块版本]
*/
public interface XzRegionEpidemicSituationService extends BaseService {
	List<XzRegionEpidemicSituation> listToday();

}