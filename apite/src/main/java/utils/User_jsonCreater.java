package utils;

import java.io.FileNotFoundException;

import net.minidev.json.JSONObject;

public class User_jsonCreater {
	public static JSONObject Object_creater(String value1,String Value2) throws FileNotFoundException {
		JSONObject request = new JSONObject();
		request.put(value1, Yamlreader.getValue(value1));
		request.put(Value2, Yamlreader.getValue(Value2));
		return request;
	}

	public static JSONObject Object_creater(String value1) throws FileNotFoundException {
		JSONObject request = new JSONObject();
		request.put(value1, Yamlreader.getValue(value1));
		return request;
	}
	
}
