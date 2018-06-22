package com.library.util;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class JSONUtil {

	private static final Logger LOGGER = Logger.getLogger(JSONUtil.class);
	
	private Gson gson;
	
	public JSONUtil() {
		this.gson = new Gson();
	}
	
	public String getJSONForObject(Object obj) {
		LOGGER.info("JSONUtil + getJSONForObject");
		return gson.toJson(obj);
	}
	
	public <T> T getObjectForJson(String jsonString, Class<T> classs) {
		LOGGER.info("JSONUtil + getObjectForJSON");
		return gson.fromJson(jsonString, classs);
	}
}
