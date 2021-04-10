//package com.spring.decorate.utilities;
//
//import com.spring.decorate.annotations.JsonField;
//
//import java.lang.reflect.Field;
//import java.util.HashMap;
//import java.util.Map;
//
//import static java.util.Objects.requireNonNull;
//
//public class JsonSerializer {
//
//	public String serialize(Object obj) {
//
//		Class<?> objClass = requireNonNull(obj).getClass();
//
//		Map<String,String> jsonElements = new HashMap<>();
//
//		for(Field field : objClass.getDeclaredFields()) {
//			field.setAccessible(true);
//
//			if (field.isAnnotationPresent(JsonField.class)) {
//				String key = getSerializedkey(field);
//
//			}
//		}
//	}
//
//	private String getSerializedkey(Field field) {
//		String annotationValue = field.getAnnotation(JsonField.class).value();
//		if (annotationValue.isEmpty()) {
//			return field.getName();
//		} else return annotationValue;
//	}
//}
