package com.money.utils;

import com.money.entities.OriginalNumber;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class ConstructUtil {

	public static Map<String, Integer> getInitCountMap() {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (int i = 0; i < Constants.RED.length; i++) {
			countMap.put("r" + Constants.RED[i], Integer.valueOf(0));
		}
		for (int i = 0; i < Constants.BLUE.length; i++) {
			countMap.put("b" + Constants.BLUE[i], Integer.valueOf(0));
		}
		return countMap;
	}

	public static List<List<String>> constructNumber(List<String> numbers) {
		List<List<String>> result = new ArrayList<List<String>>();
		for (String blue : Constants.BLUE) {
			List<String> newNumbers = new ArrayList<String>(numbers);
			newNumbers.add(blue);
			result.add(newNumbers);
		}
		return result;
	}

	public static OriginalNumber constructOriginalNumber(List<String> numbers) {
		OriginalNumber result = new OriginalNumber();
		for (int i = 0; i < numbers.size(); i++) {
			String field = "r" + (String) numbers.get(i);
			if (i == numbers.size() - 1) {
				field = "b" + (String) numbers.get(i);
			}
			try {
				BeanUtils.setProperty(result, field, numbers.get(i));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}