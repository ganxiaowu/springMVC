package com.springMvc.test.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParse {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	public static String ObjToJson(Object object)throws Exception{
		return objectMapper.writeValueAsString(object);
	}

	public static Map<String, Object> JsonToMap(String jsonStr) {
			try {
				return objectMapper.readValue(jsonStr, Map.class);
			}catch (Exception e){
				return null;
			}
	}
	public static ObjectMapper getInstance() {

		return objectMapper;
	}

	/**
	 * javaBean,list,array convert to json string
	 */
	public static String obj2json(Object obj) throws Exception {
		return objectMapper.writeValueAsString(obj);
	}

	/**
	 * json string convert to javaBean
	 */
	public static <T> T json2pojo(String jsonStr, Class<T> clazz)
			throws Exception {
		return objectMapper.readValue(jsonStr, clazz);
	}

	/**
	 * json string convert to map
	 */
	public static <T> Map<String, Object> json2map(String jsonStr)
			throws Exception {
		return objectMapper.readValue(jsonStr, Map.class);
	}

	/**
	 * json string convert to map with javaBean
	 */
	public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
			throws Exception {
		Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr,
				new TypeReference<Map<String, T>>() {
				});
		Map<String, T> result = new HashMap<String, T>();
		for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
			result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
		}
		return result;
	}

	/**
	 * json array string convert to list with javaBean
	 */
	public static <T>  List<Map<String, String>> json2list(String jsonArrayStr)
			throws Exception {
		List<Map<String, String>> list = objectMapper.readValue(jsonArrayStr,
				new TypeReference<List<T>>() {
				});
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (Map<String, String> map : list) {
			result.add(map);
		}
		return result;
	}

	/**
	 * map convert to javaBean
	 */
	public static <T> T map2pojo(Map map, Class<T> clazz) {
		return objectMapper.convertValue(map, clazz);
	}
}
