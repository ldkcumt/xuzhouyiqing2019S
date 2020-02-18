package com.dt.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.service.impl.base.BaseServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.controller.XzEpidemicSituationController;
import com.dt.core.util.UserUtil;
import com.dt.entity.XzEpidemicSituation;
import com.dt.service.XzEpidemicSituationService;

/**
 * XzEpidemicSituation业务操作接口实现
 *
 * @author administrator
 * @version [版本号, ${date}]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class XzEpidemicSituationServiceImpl extends BaseServiceImpl implements XzEpidemicSituationService {
	private final Logger logger = LoggerFactory.getLogger(XzEpidemicSituationServiceImpl.class);
	public XzEpidemicSituationServiceImpl() {
		super();
		this.mapper = "XzEpidemicSituationMapper";
	}

	@Override
	public XzEpidemicSituation getXzTotalYq() {
		// TODO Auto-generated method stub
		XzEpidemicSituation res=(XzEpidemicSituation)this.baseDao.getByParam(this.mapper+".getTotalYq", null);
		return res;
	}
	public JSONObject getXzYqSituation() throws IOException{
		// TODO Auto-generated method stub
//		 Map<String, Object> map=new HashMap<String, Object>();
		 String csdnUrl="https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
			Connection conn = Jsoup.connect(csdnUrl).ignoreContentType(true);// 获取连接 //设置请求头，伪装成浏览器(否则会报403)
			conn.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
				// //设置超时时间，同时Document对象中封装了返回的html文档
				Document doc=conn.timeout(100000).get();
				if(doc==null) {
					return null;
				}
				JSONObject json=JSONObject.parseObject(doc.text());
				if(json==null) {
					return null;
				}
				JSONObject data=JSONObject.parseObject(json.get("data").toString());
				if(data==null) {
					return null;
				}
				JSONArray arr=data.getJSONArray("areaTree");
				JSONArray zhongguo=arr.getJSONObject(0).getJSONArray("children");
				if(zhongguo==null) {
					return null;
				}
				JSONObject js=null;
				for(int i=0;i<zhongguo.size();i++) {
					JSONObject s=zhongguo.getJSONObject(i);
					String name=s.getString("name");
					if(name!=null&&"江苏".equals(name)) {
						js=s;
						break;
					}
					
				}
				JSONObject xz=null;
				if(js!=null) {
					JSONArray jss=js.getJSONArray("children");
					for(int i=0;i<jss.size();i++) {
						JSONObject s=jss.getJSONObject(i);
						String name=s.getString("name");
						if(name!=null&&"徐州".equals(name)) {
							xz=s;
							break;
						}
					}
				}
//				if(xz!=null) {
//				  map.put("total", xz.get("total"));
//				  map.put("today", xz.get("today"));	
//				}
				return xz;
	}
	@Override
	@Transactional
	public int updateYQ(){
		// TODO Auto-generated method stub
		//获取疫情
		try {
		   JSONObject json=getXzYqSituation();
		   if(json!=null) {
			   JSONObject total=json.getJSONObject("total");
			   if(total==null) {
				 return -1;  
			   }
			   int total_confirm=total.getIntValue("confirm");
			   int total_heal=total.getIntValue("heal");
			   int total_dead=total.getIntValue("dead");
			   int total_suspect=total.getIntValue("suspect");
			  XzEpidemicSituation today=(XzEpidemicSituation)this.baseDao.getByParam(this.mapper+".getByDate", UserUtil.getNowStrTime("yyyy-MM-dd"));
			  XzEpidemicSituation yesterday=(XzEpidemicSituation)this.baseDao.getByParam(this.mapper+".getByDate", UserUtil.getYesterday());
			  int yesterday_confirm=yesterday.getConfirm();
			  int yesterday_heal=yesterday.getHeal();
			  int yesterday_dead=yesterday.getDead();
			  int yesterday_suspect=yesterday.getSuspect();
			  //更新
			  if(today!=null) {
				  today.setConfirm(total_confirm);
				  today.setHeal(total_heal);
				  today.setSuspect(total_suspect);
				  today.setDead(total_dead);
				  today.setConfirmAdd(total_confirm-yesterday_confirm);
				  today.setHealAdd(total_heal-yesterday_heal);
				  today.setSuspectAdd(total_suspect-yesterday_suspect);
				  today.setDeadAdd(total_dead-yesterday_dead);
				  today.setUpdateTime(UserUtil.getNowStrTime("yyyy-MM-dd HH:mm:ss"));
				  return this.baseDao.update(this.mapper+".update", today);
			  }else {
				  today=new XzEpidemicSituation();
				  today.setConfirm(total_confirm);
				  today.setHeal(total_heal);
				  today.setSuspect(total_suspect);
				  today.setDead(total_dead);
				  today.setConfirmAdd(total_confirm-yesterday_confirm);
				  today.setHealAdd(total_heal-yesterday_heal);
				  today.setSuspectAdd(total_suspect-yesterday_suspect);
				  today.setDeadAdd(total_dead-yesterday_dead);
				  today.setCreateDate(UserUtil.getNowStrTime("yyyy-MM-dd"));
				  today.setUpdateTime(UserUtil.getNowStrTime("yyyy-MM-dd HH:mm:ss"));
				  today.setArea("徐州");
				  return this.baseDao.insert(this.mapper+".insert", today);
			  }
		   }
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
		return -1;
		
	}
}
