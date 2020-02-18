package com.dt.core.util;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//http://api.inews.qq.com/newsqa/v1/query/pubished/daily/list?province=%E6%B1%9F%E8%8B%8F&city=%E5%BE%90%E5%B7%9E

public class PyUtil {
	public static void main(String[] args) {
		String csdnUrl="https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
		Connection conn = Jsoup.connect(csdnUrl).ignoreContentType(true);// 获取连接 //设置请求头，伪装成浏览器(否则会报403)
		conn.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
		try
		{
			// //设置超时时间，同时Document对象中封装了返回的html文档
			Document doc=conn.timeout(100000).get();
			JSONObject json=JSONObject.parseObject(doc.text());
			JSONObject data=JSONObject.parseObject(json.get("data").toString());
			JSONArray arr=data.getJSONArray("areaTree");
			JSONArray zhongguo=arr.getJSONObject(0).getJSONArray("children");
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
			System.out.println(xz);

		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static JSONObject getXuZhouYiQing() throws IOException{
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
			return xz;

	}

}
