package com.dt.entity;

import java.io.Serializable;
/**
* XzEpidemicSituation 实体类
*
* @author  administrator
* @version  [版本号, ${date}]
* @see  [相关类/方法]
* @since  []
*/
@SuppressWarnings("serial")
public class XzEpidemicSituation implements Serializable {

	/**
	* 
	*/
	private Integer id;

	/**
	* 区域
	*/
	private String area;

	/**
	* 创建日期
	*/
	private String createDate;

	/**
	* 确诊
	*/
	private Integer confirm;

	/**
	* 死亡
	*/
	private Integer dead;

	/**
	* 治愈
	*/
	private Integer heal;

	/**
	* 疑似
	*/
	private Integer suspect;

	/**
	* 
	*/
	private Integer confirmAdd;

	/**
	* 
	*/
	private Integer deadAdd;

	/**
	* 
	*/
	private Integer healAdd;

	/**
	* 
	*/
	private Integer suspectAdd;

	/**
	* 
	*/
	private String updateTime;

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
	private String extend3;

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getConfirm() {
		return confirm;
	}

	public void setConfirm(Integer confirm) {
		this.confirm = confirm;
	}

	public Integer getDead() {
		return dead;
	}

	public void setDead(Integer dead) {
		this.dead = dead;
	}

	public Integer getHeal() {
		return heal;
	}

	public void setHeal(Integer heal) {
		this.heal = heal;
	}

	public Integer getSuspect() {
		return suspect;
	}

	public void setSuspect(Integer suspect) {
		this.suspect = suspect;
	}

	public Integer getConfirmAdd() {
		return confirmAdd;
	}

	public void setConfirmAdd(Integer confirmAdd) {
		this.confirmAdd = confirmAdd;
	}

	public Integer getDeadAdd() {
		return deadAdd;
	}

	public void setDeadAdd(Integer deadAdd) {
		this.deadAdd = deadAdd;
	}

	public Integer getHealAdd() {
		return healAdd;
	}

	public void setHealAdd(Integer healAdd) {
		this.healAdd = healAdd;
	}

	public Integer getSuspectAdd() {
		return suspectAdd;
	}

	public void setSuspectAdd(Integer suspectAdd) {
		this.suspectAdd = suspectAdd;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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

	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
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
