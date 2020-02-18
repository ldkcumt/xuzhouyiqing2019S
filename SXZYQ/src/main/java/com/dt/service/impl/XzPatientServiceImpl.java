package com.dt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.service.impl.base.BaseServiceImpl;
import com.dt.core.util.UserUtil;
import com.dt.entity.XzPatient;
import com.dt.service.XzPatientService;

/**
 * XzPatient业务操作接口实现
 *
 * @author administrator
 * @version [版本号, ${date}]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class XzPatientServiceImpl extends BaseServiceImpl implements XzPatientService {

	public XzPatientServiceImpl() {
		super();
		this.mapper = "XzPatientMapper";
	}

	@Override
	@Transactional
	public int update(Object entity) throws Exception {
		// TODO Auto-generated method stub
		XzPatient model = (XzPatient) entity;
		model.setUpdateTime(UserUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
		return this.baseDao.update(this.mapper+".update", entity);
	}
}
