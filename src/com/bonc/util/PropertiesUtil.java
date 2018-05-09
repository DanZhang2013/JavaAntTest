package com.bonc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertiesUtil {
	private static Log logger = LogFactory.getLog(PropertiesUtil.class);
	public Properties getProperties(String path) {
		InputStream in = null;
		Properties prop = new Properties();
		try {
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
			prop.load(in);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} finally {
			try {
				if(in!=null){
					in.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
		return prop;
	}
}
