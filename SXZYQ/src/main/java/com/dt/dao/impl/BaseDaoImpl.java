package com.dt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.dt.dao.base.BaseDao;
import com.dt.response.DataGrid;

@Service("baseDaoImpl")
public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {
	
	@Override
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int insert(String statement, Object entity) {
		return this.getSqlSession().insert(statement, entity);
	}

	@Override
	public int update(String statement, Object entity) {
		return this.getSqlSession().update(statement, entity);
	}
	
	@Override
	public int delete(String statement, Object entity) {
		return this.getSqlSession().delete(statement, entity);
	}

	@Override
	public Object getByParam(String statement, Object entity) {
		return this.getSqlSession().selectOne(statement, entity);
	}

	@Override
	public List<?> queryList(String statement, Object entity) {
		return this.getSqlSession().selectList(statement, entity);
	}

	@Override
	public DataGrid queryDataGrid(String statement, Object entity) {
//		BaseEntity baseEntity = (BaseEntity) entity;
//		baseEntity.initPage();
		List<?> list = this.getSqlSession().selectList(statement, entity);
		int rowSise = this.getSqlSession().selectOne(statement + "Count", entity);
		DataGrid dg = new DataGrid();
		dg.setRows(list);
		dg.setTotal((long) rowSise);
		return dg;
	}
	@Override
	public int queryListCount(String statement, Object entity) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(statement, entity);
	}
	
}
