package com.bonc.main;

import java.util.concurrent.Executors;

import org.apache.commons.logging.LogFactory;
import org.elasticsearch.client.transport.TransportClient;

import com.bonc.util.ElasticSearchUtil;

/**
 * socket服务端
 * @author zydev293
 *
 */
public class SocketMain {
	
	//ES client
		public static TransportClient client=null;
		
		
		static{
			//ES客户端
			client=new ElasticSearchUtil().getClient();
			//线程池
			
		}
	/**
	 * 主程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	

	

}
