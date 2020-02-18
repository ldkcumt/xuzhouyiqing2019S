package com.dt.core.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class ConfigManager {
	private static ConfigManager instance;
	private Map<String, Properties> ptMap = new HashMap<String, Properties>();
	
	public static ConfigManager getInstance(){
		if(instance == null){
			synchronized (ConfigManager.class) {
				if(instance == null){
					instance = new ConfigManager();
				}
			}
		}
		return instance;
	}
	
	public String getProperty(String filePrefix, String key) throws FileNotFoundException{
		if(filePrefix == null || key == null || "".equals(filePrefix.trim())){
			throw new IllegalArgumentException();
		}
		Properties p = ptMap.get(filePrefix);
		if(p == null){
			synchronized (ConfigManager.class + filePrefix) {
				if( p == null){
					p = loadProperties(filePrefix);
				}
			}
		}
		return p.getProperty(key);
	}
	
	public int getIntProperty(String filePrefix, String key) throws FileNotFoundException, NullPointerException{
		String value = getProperty(filePrefix, key);
		if(value== null || "".equals(value.trim())){
			throw new NullPointerException();
		}
		return Integer.parseInt(value);
	}

	public Properties loadProperties(String filePrefix){
		String filePath = "/" + filePrefix + ".properties";
		InputStream is = getClass().getResourceAsStream(filePath);
		Properties p = new Properties();
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ptMap.put(filePrefix, p);
		return p;
	}

	
}
