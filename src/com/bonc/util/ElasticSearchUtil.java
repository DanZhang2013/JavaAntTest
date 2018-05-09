package com.bonc.util;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.bonc.constant.Constants;



public class ElasticSearchUtil {
	private static Log logger=LogFactory.getLog(ElasticSearchUtil.class);
	private static ConfigUtil configUtil = new ConfigUtil();
	
	/**
	 * 获取客户端操作对象, properties配置文件包含 cluster.name ,cluster.ip
	 * ,client.transport.ping_timeout
	 * 
	 * @return
	 * @throws UnknownHostException 
	 * @throws Exception
	 * 
	 */
	public TransportClient getClient() {
	
		String[] ipArr = configUtil.getValue("ESIP").split(",");

		Settings settings = Settings.builder().put("thread_pool.generic.core",5)
				.put("thread_pool.generic.max", 10)
				.put("processors", 5)
				.put(Constants.ESCLUSTERNAME,configUtil.getValue("clusterName")).build();
		
		TransportClient client = new PreBuiltTransportClient(settings);
		for (String ip : ipArr) {
			TransportAddress address = new InetSocketTransportAddress
					(InetAddresses.forString(ip),9300);
			client.addTransportAddresses(address);
		}
		
		return client;
	}

	/**
	 * es中添加索引
	 * 
	 */
	public void addIndex(Client client,String systemType,String batchNo,String versionNo,
			String batchDate,String batchDefined,String uploadPerson,StringBuffer fileInfo){

		try {
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
					.field("systemType",systemType)
					.field("batchNo",batchNo)
					.field("batchDate",batchDate)
					.field("batchDefined",batchDefined)
					.field("uploadPerson",uploadPerson)
					.field("versionNo",versionNo)
					.field("fileInfo",fileInfo)
					.endObject();
			String json = builder.string();
			
			IndexResponse response = client.prepareIndex("batch","batchInfo",systemType+batchNo)
					.setSource(json).get();
			
			if(response.getIndex() != null){
//				logger.info("创建索引成功");
			}

		} catch (IOException e) {
			logger.error("ElasticsearchUtil创建索引失败"+e.getMessage(),e);
		}

		
	}
	
	
	
	
	
	/**
	 * ES更新索引
	 * @param client
	 * @param systemType
	 * @param batchNo
	 * @param versionNo
	 * @param batchDate
	 * @param userDefined
	 * @param uploadPerson
	 * @param fileName
	 */
	public void updateIndex(Client client,String systemType,String batchNo,String versionNo,
			String batchDate,String batchDefined,String uploadPerson,StringBuffer fileInfo){
		
		try{
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
					.field("systemType",systemType)
					.field("batchNo",batchNo)
					.field("batchDate",batchDate)
					.field("batchDefined",batchDefined)
					.field("uploadPerson",uploadPerson)
					.field("versionNo",versionNo)
					.field("fileInfo",fileInfo)
					.endObject();

			UpdateRequest request = new UpdateRequest();
			request.index("batch");
			request.type("batchInfo");
			request.id(systemType+batchNo);
			request.doc(builder);
			
			UpdateResponse response = client.update(request).get();
			
			if(response.getIndex() != null){
//				logger.info("索引更新成功");
			}
				
		}catch(IOException e){
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (InterruptedException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (ExecutionException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}
	}
	/**
	 * 重载 属性更新使用 
	 * @param client
	 * @param systemType
	 * @param batchNo
	 * @param versionNo
	 * @param batchDate
	 * @param batchDefined
	 * @param uploadPerson
	 * @param fileInfo
	 */
	public boolean updateIndex(Client client,String systemType,String batchNo,String versionNo,
			String batchDate,String batchDefined,String uploadPerson,String fileInfo){
		
		boolean flag=false;
		try{
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
					.field("systemType",systemType)
					.field("batchNo",batchNo)
					.field("batchDate",batchDate)
					.field("batchDefined",batchDefined)
					.field("uploadPerson",uploadPerson)
					.field("versionNo",versionNo)
					.field("fileInfo",fileInfo)
					.endObject();
			
			UpdateRequest request = new UpdateRequest();
			request.index("batch");
			request.type("batchInfo");
			request.id(systemType+batchNo);
			request.doc(builder);
			
			UpdateResponse response = client.update(request).get();
			
			if(response.getIndex() != null){
				flag=true;
			}
			
		}catch(IOException e){
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (InterruptedException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (ExecutionException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}
		return flag;
	}
	
	/**
	 * 删除后更新索引,报错的方法
	 * @param client
	 * @param systemType
	 * @param batchNo
	 * @param versionNo
	 * @param batchDate
	 * @param batchDefined
	 * @param uploadPerson
	 * @param fileInfo
	 * @author zydev290
	 */
	/*public void updateIndex(Client client,String systemType,String batchNo,String versionNo,
			StringBuffer fileInfo){
		
		try{
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
					.field("systemType",systemType)
					.field("batchNo",batchNo)
					.field("versionNo",versionNo)
					.field("fileInfo",fileInfo)
					.endObject();

			UpdateRequest request = new UpdateRequest();
			request.index("batch");
			request.type("batchInfo");
			request.id(systemType+batchNo);
			request.doc(builder);
			
			UpdateResponse response = client.update(request).get();
			
			if(response.getIndex() != null){
//				logger.info("索引更新成功");
			}
				
		}catch(IOException e){
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (InterruptedException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (ExecutionException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}
	}*/
	
	
	public void updateIndexForDelete(Client client,String systemType,String batchNo,String batchDate,String batchDefined,String uploadPerson,String versionNo,
			StringBuffer fileInfo){

		try {
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
					.field("systemType",systemType)
					.field("batchNo",batchNo)
					.field("batchDate",batchDate)
					.field("batchDefined",batchDefined)
					.field("uploadPerson",uploadPerson)
					.field("versionNo",versionNo)
					.field("fileInfo",fileInfo)
					.endObject();
			String json = builder.string();
			
			IndexResponse response = client.prepareIndex("batch","batchInfo",systemType+batchNo)
					.setSource(json).get();
			
			if(response.getIndex() != null){
//				logger.info("创建索引成功");
			}

		} catch (IOException e) {
			logger.error("ElasticsearchUtil创建索引失败"+e.getMessage(),e);
		}

		
	}
	
	
	
	
	
	
	
	/**
	 * 按版本删除，不报错
	 * @param client
	 * @param systemType
	 * @param batchNo
	 * @param versionNo
	 * @param fileInfo
	 * @param ID
	 */
	public void updateIndex(Client client,String systemType,String batchNo,String batchDate,String batchDefined,
			String uploadPerson,String versionNo,String fileInfo,String ID){
		
		try{
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
					.field("systemType",systemType)
					.field("batchNo",batchNo)
					.field("batchDate",batchDate)
					.field("batchDefined",batchDefined)
					.field("uploadPerson",uploadPerson)
					.field("versionNo",versionNo)
					.field("fileInfo",fileInfo)
					.endObject();
			
			UpdateRequest request = new UpdateRequest();
			request.index("batch");
			request.type("batchInfo");
			request.id(ID);
			request.doc(builder);
			
			UpdateResponse response = client.update(request).get();
			
			if(response.getIndex() != null){
//				logger.info("索引更新成功");
			}
			
		}catch(IOException e){
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (InterruptedException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (ExecutionException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}
	}
	
	/**
	 * 删除
	 * @param client
	 * @param systemType
	 * @param batchNo
	 * @param fileInfo
	 * @param ID
	 */
	public void updateIndex(Client client,String systemType,String batchNo,
			String fileInfo,String ID){
		
		try{
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
					.field("systemType",systemType)
					.field("batchNo",batchNo)
					.field("fileInfo",fileInfo)
					.endObject();
			
			UpdateRequest request = new UpdateRequest();
			request.index("batch");
			request.type("batchInfo");
			request.id(ID);
			request.doc(builder);
			
			UpdateResponse response = client.update(request).get();
			
			if(response.getIndex() != null){
//				logger.info("索引更新成功");
			}
			
		}catch(IOException e){
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (InterruptedException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}catch (ExecutionException e) {
			logger.error("ElasticsearchUtil创建更新失败"+e.getMessage(),e);
		}
	}
	
	
	
/**
 * 根据条件查询ES索引信息
 * @param systemType
 * @param batchNo
 * @return
 */
	public String findPreIndex(Client client,String systemType, String batchNo) {

		
//		TransportClient client = new ElasticSearchUtil().getClient();
		
		String fileInfo="";
		if(client != null){

			BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
			
			boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("systemType", systemType));
			boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("batchNo", batchNo));
			
									
			SearchResponse response = client.prepareSearch("batch")	
									.setTypes("batchInfo")
									.setQuery(boolQueryBuilder)
									.execute().actionGet();

			SearchHits searchHits = response.getHits();
			SearchHit[] hits = searchHits.getHits();
			
			if(hits != null && hits.length>0){
				for (SearchHit hit : hits) { 
					Map<String,Object> reSource = hit.getSource();
					fileInfo=(String)reSource.get("fileInfo");
				}
			}
		}
			return fileInfo;
		
	}
	
	

public Map<String,String> findPreIndexMap(Client client,String systemType, String batchNo) {
	
	
//		TransportClient client = new ElasticSearchUtil().getClient();
	Map<String, String> map = new HashMap<String, String>();
	String fileInfo="";
	String batchDate="";
	String uploadPerson="";
	String batchDefined="";
	String versionNo="";
	if(client != null){
		
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		
		boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("systemType", systemType));
		boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("batchNo", batchNo));
		
		
		SearchResponse response = client.prepareSearch("batch")	
				.setTypes("batchInfo")
				.setQuery(boolQueryBuilder)
				.execute().actionGet();
		
		SearchHits searchHits = response.getHits();
		SearchHit[] hits = searchHits.getHits();
		
		if(hits != null && hits.length>0){
			for (SearchHit hit : hits) { 
				Map<String,Object> reSource = hit.getSource();
				fileInfo=(String)reSource.get("fileInfo");
				batchDate=(String)reSource.get("batchDate");
				uploadPerson=(String)reSource.get("uploadPerson");
				batchDefined=(String)reSource.get("batchDefined");
				versionNo=(String)reSource.get("versionNo");
				
				map.put("fileInfo", fileInfo);
				map.put("batchDate", batchDate);
				map.put("uploadPerson", uploadPerson);
				map.put("batchDefined", batchDefined);
				map.put("versionNo", versionNo);
			}
		}
	}
	return map;
	
}

	
	
}
