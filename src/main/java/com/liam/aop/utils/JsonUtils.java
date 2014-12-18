package com.liam.aop.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {
	private static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.getSerializationConfig().setDateFormat(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}
	static Logger logger = Logger.getLogger(JsonUtils.class);

	/**
	 * 将对象转换为JSON格式
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	public static String toStr(Object model) {
		if (model == null) {
			return "";
		}
		try {
			return mapper.writeValueAsString(model);
		} catch (Exception ex) {
			logger.error("JsonParseException=" + ex + ",jsonText=" + model);
			return "";
		}
	}
}
