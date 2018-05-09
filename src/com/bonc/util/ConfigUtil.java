package com.bonc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ConfigUtil {
	private static Log logger=LogFactory.getLog(ConfigUtil.class);
	/**
	 * 根据key获取config.properties文件的value
	 * @param key
	 * @return
	 * @throws Exception
	 * @author zydev293
	 * @date 20171010
	 */
	public String getValue(String key){
		
		Properties p = new Properties();
		
		try {
			//加载资源
			InputStream inStream = ConfigUtil.class.getResourceAsStream("/config.properties");
			p.load(inStream);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
			e.fillInStackTrace();
		}
		
		return p.getProperty(key);
		
	}
		
}
