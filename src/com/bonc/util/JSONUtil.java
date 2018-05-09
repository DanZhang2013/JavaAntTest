package com.bonc.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class JSONUtil {
	/**
	 * json字符串转化为Map
	 * @param jsonString
	 * @return
	 * @author zydev293
	 * @date 20171016
	 */
	public  Map<String,String> jsonToMap(String jsonString){
		
		Map<String,String> jsonMap=new HashMap<>();
		
		JSONObject jsonObject=JSONObject.fromObject(jsonString);
		
		for(Object o:jsonObject.keySet()){
			Object obj=jsonObject.get(o);
			jsonMap.put(o.toString(), obj.toString());
		}
		
		return jsonMap;
	}

	/**
	 *  将对象转换为JSON
	 * @param obj
	 * @return
	 */
	public  String objToJson(Object obj) {
	
		return new Gson().toJson(obj);
	
	}
	
	/**
	 * 将json串转换为对象
	 * @param json
	 * @return
	 */
	public  Object jsonToObj(String json,Object obj){
		
		return new Gson().fromJson(json, obj.getClass());
		
	}

	
}
