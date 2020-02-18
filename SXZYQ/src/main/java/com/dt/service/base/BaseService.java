package com.dt.service.base;

import java.util.List;

import com.dt.response.DataGrid;

public interface BaseService {

	/**
	 * @description 插入 
	 * @param entity
	 * @throws Exception
	 */
	int insert(Object entity) throws Exception;
	
	/**
	 * @description 根据id删除
	 * @param id
	 * @throws Exception
	 */
	int delete(Object entity) throws Exception;
	
	/**
	 * @description 更新
	 * @param entity
	 * @throws Exception
	 */
	int update(Object entity) throws Exception;
	
	/**
	 * @description 根据多个条件获取单个实例
	 * @param sqlId
	 * @param entity
	 * @return
	 */
	Object getByParam(Object entity);
	
	/**
	 * @description 根据条件获取多个实例
	 * @param sqlId
	 * @param entity
	 * @return
	 */
	List<?> queryList(Object entity);
	
	/**
	 * @description 分页查询
	 * @param sqlId
	 * @param entity
	 * @return
	 */
	DataGrid queryDataGrid(Object entity);
	int queryListCount(Object entity);
	
}
