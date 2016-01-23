package com.tools;

import net.sf.json.JSONObject;
public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
//转化成为json格式
public static String createJsonString(String key,Object value){
	JSONObject jsonObject=new JSONObject();
	jsonObject.put(key, value);
	return jsonObject.toString();
}
}
