package com.dt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.dt.service.impl.base.BaseServiceImpl;
import com.dt.core.util.UserUtil;
import com.dt.entity.XzRegionEpidemicSituation;
import com.dt.service.XzRegionEpidemicSituationService;

/**
 * XzRegionEpidemicSituation业务操作接口实现
 *
 * @author administrator
 * @version [版本号, ${date}]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class XzRegionEpidemicSituationServiceImpl extends BaseServiceImpl implements XzRegionEpidemicSituationService {

	public XzRegionEpidemicSituationServiceImpl() {
		super();
		this.mapper = "XzRegionEpidemicSituationMapper";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<XzRegionEpidemicSituation> listToday() {
		// TODO Auto-generated method stub
		return (List<XzRegionEpidemicSituation>) this.baseDao.queryList(this.mapper + ".listToday", null);
	}
	@Override
	public int update(Object entity) throws Exception {
		// TODO Auto-generated method stub
		XzRegionEpidemicSituation model=(XzRegionEpidemicSituation)entity;
		model.setUpdateTime(UserUtil.getNowStrTime("yyyy-MM-dd HH:mm:ss"));
		return this.baseDao.update(this.mapper+".update", model);
	}
	
}
