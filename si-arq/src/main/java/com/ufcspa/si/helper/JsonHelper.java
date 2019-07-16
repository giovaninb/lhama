package com.ufcspa.si.helper;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Map;

@Component
public class JsonHelper {
	
	public Map<String, Object> toMap(Object object) {
		String json = toJson(object).toString();
		
		Type type = new TypeToken<Map<String, Object>>(){}.getType();
		Map<String, Object> myMap = getGson().fromJson(json, type);
		return myMap;
	}
	
	public <T> T fromJson(String json, Class<T> classOfT) {
		return this.getGson().fromJson(json, classOfT);
	}
	
	public String toJson(Object object){
		return configureGson().toJson(object);
	}
	
	public String addToJson(Object object, String value){
		JsonObject jobj = new JsonObject();
		jobj.add("key", configureGson().toJsonTree(object));
		return jobj.toString();
	}
	
	public Gson getGson(){
		return configureGson();
	}
	
	public Gson configureGson() {
		Gson gson = new GsonBuilder()
			    .registerTypeAdapter(DateTime.class, new JsonSerializer<DateTime>(){
		            @Override
		            public JsonElement serialize(DateTime json, Type typeOfSrc, JsonSerializationContext context) {
		                return new JsonPrimitive(ISODateTimeFormat.dateTime().print(json));
		            }
		        })
			    .serializeNulls()
			    .create();
		return gson;
	}

}
