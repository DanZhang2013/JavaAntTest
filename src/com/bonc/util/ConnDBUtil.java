package com.bonc.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnDBUtil {
	private static final Log logger = LogFactory.getLog(ConnDBUtil.class);
	private static Properties JDBCPOP = new PropertiesUtil().getProperties("jdbc.properties");
	private static ComboPooledDataSource cpds;
	static{
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(JDBCPOP.getProperty("driverName"));
			cpds.setJdbcUrl(JDBCPOP.getProperty("url"));
			cpds.setUser(JDBCPOP.getProperty("user"));
			cpds.setPassword(JDBCPOP.getProperty("drowssap"));
			cpds.setAcquireIncrement(Integer.parseInt(JDBCPOP.getProperty("acquireIncrement")));
			cpds.setInitialPoolSize(Integer.parseInt(JDBCPOP.getProperty("initialPoolSize")));
			cpds.setMinPoolSize(Integer.parseInt(JDBCPOP.getProperty("minPoolSize")));
			cpds.setMaxPoolSize(Integer.parseInt(JDBCPOP.getProperty("maxPoolSize")));
			cpds.setIdleConnectionTestPeriod(Integer.parseInt(JDBCPOP
					.getProperty("idleConnectionTestPeriod")));
		} catch (PropertyVetoException e) {
			logger.error("c3p0连接异常："+e.getMessage(),e);
		}
	}
	/**
	 * 获得c3p0连接
	 * @return Connection
	 */
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn= cpds.getConnection();
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		}
		return conn;
	}
	
}	
