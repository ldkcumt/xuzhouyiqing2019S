package com.dt.entity;

import java.io.Serializable;
/**
* EpidemicSituation 实体类
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  []
*/
@SuppressWarnings("serial")
public class EpidemicSituation implements Serializable {

	/**
	* 
	*/
	private Integer id;

	/**
	* 
	*/
	private String type;

	/**
	* 
	*/
	private String details;

	/**
	* 
	*/
	private String extend1;

	/**
	* 
	*/
	private String extend2;

	/**
	* 
	*/
	private String extend4;

	/**
	* 
	*/
	private String extend5;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getExtend4() {
		return extend4;
	}

	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}

	public String getExtend5() {
		return extend5;
	}

	public void setExtend5(String extend5) {
		this.extend5 = extend5;
	}

}
