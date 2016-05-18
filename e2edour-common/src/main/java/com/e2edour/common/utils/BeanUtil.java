package com.e2edour.common.utils;

import java.util.ArrayList;
import java.util.List;

public class BeanUtil {

	/**
	 * 拷贝对象
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static <T> T copyOne2One(Object source, Class<T> target) {
		T instance = null;
		try {
			instance = target.newInstance();
			org.springframework.beans.BeanUtils.copyProperties(source, instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}

	/**
	 * 拷贝集合
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static <T> List<T> copyList2List(List<?> source, Class<T> target) {
		if (null == source || source.size() == 0)
			return new ArrayList<T>();

		List<T> result = new ArrayList<T>();
		for (Object obj : source) {
			result.add(copyOne2One(obj, target));
		}
		return result;
	}
}
