package com.testingframework.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.testingframework.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils() {

	}

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testname = m.getName();

		if (list.isEmpty()) {
			list = ExcelUtils.getDetails(FrameworkConstants.getDatasheet());
		}

		List<Map<String, String>> filteredList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("TestName").equalsIgnoreCase(testname)
					&& (list.get(i).get("Execute").equalsIgnoreCase("Yes"))) {

				filteredList.add(list.get(i));

			}
		}
	//	list.removeAll(filteredList); ----> use only when necessary
		return filteredList.toArray();

	}
}
