package com.dt.dao.base;

import java.util.List;

import com.dt.response.DataGrid;
public interface BaseDao {
	// 添加一个实体
	public int insert(String sqlId, Object entity);
	
	// 按实体来删除
	public int delete(String sqlId, Object entity);

	// 按实体来更新
	public int update(String sqlId, Object entity);

	// 按实体获取单个实体
	public Object getByParam(String sqlId, Object entity);

	// 按实体来查询多个实体
	public List<?> queryList(String sqlId, Object entity);

	// 分页查询
	public DataGrid queryDataGrid(String sqlId, Object entity);
	public int queryListCount(String sqlId, Object entity);
}
