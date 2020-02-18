package com.dt.service.impl.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dao.base.BaseDao;
import com.dt.response.DataGrid;
import com.dt.service.base.BaseService;

@Service
public class BaseServiceImpl implements BaseService {
	
	public String mapper="";
	@Autowired
	@Qualifier("baseDaoImpl")
	public BaseDao baseDao;

	@Override
	@Transactional
	public int insert(Object entity) throws Exception {
		return this.baseDao.insert(mapper+".insert", entity);
	}
	
	@Override
	@Transactional
	public int delete(Object entity) throws Exception {
		return this.baseDao.delete(mapper+".delete", entity);
	}
	
	@Override
	@Transactional
	public int update(Object entity) throws Exception {
		return this.baseDao.update(mapper+".update", entity);
	}

	@Override
	public Object getByParam(Object entity) {
		return this.baseDao.getByParam(mapper+".getByParam", entity);
	}

	@Override
	public List<?> queryList(Object entity) {
		return this.baseDao.queryList(mapper+".queryList", entity);
	}

	@Override
	public DataGrid queryDataGrid(Object entity) {
		return this.baseDao.queryDataGrid(mapper+".queryDataGrid", entity);
	}
	@Override
	public int queryListCount(Object entity) {
		// TODO Auto-generated method stub
		return this.baseDao.queryListCount(mapper+".queryListCount", entity);
	}

}
