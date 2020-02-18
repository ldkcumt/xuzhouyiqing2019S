package com.dt.core.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedisPool {
	private static final Logger logger = LoggerFactory.getLogger(RedisPool.class);
	/*
	 * private static JedisPool pool = null;
	 * 
	 * static { try{ int maxActive =
	 * ConfigManager.getInstance().getIntProperty("redis", "pool.maxActive"); int
	 * maxIdle = ConfigManager.getInstance().getIntProperty("redis",
	 * "pool.maxIdle"); int minIdle =
	 * ConfigManager.getInstance().getIntProperty("redis", "pool.minIdle"); int
	 * maxWait = ConfigManager.getInstance().getIntProperty("redis",
	 * "pool.maxWait"); JedisPoolConfig poolConfig = new JedisPoolConfig();
	 * poolConfig.setMaxTotal(maxActive); poolConfig.setMaxIdle(maxIdle);
	 * poolConfig.setMinIdle(minIdle); poolConfig.setMaxWaitMillis(maxWait);
	 * poolConfig.setTestWhileIdle(true); poolConfig.setTestOnBorrow(true); String
	 * host = ConfigManager.getInstance().getProperty("redis", "host"); int port =
	 * ConfigManager.getInstance().getIntProperty("redis", "port"); pool = new
	 * JedisPool(poolConfig, host, port, 5000, "#$FDfdsf432"); }catch (Exception e)
	 * { logger.error(e.getMessage()); } }
	 * 
	 * public static Jedis getClient(){ return pool.getResource(); }
	 * 
	 * public static void returnClient(Jedis jedis){ pool.returnResource(jedis); }
	 * public static void returnBrokenClient(Jedis jedis){
	 * pool.returnBrokenResource(jedis); }
	 * 
	 * public static void main(String[] args) { Jedis c = getClient(); c.set("test",
	 * "test Ok"); System.out.println(c.get("test")); returnClient(c); }
	 */
}
