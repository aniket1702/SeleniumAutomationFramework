package com.testingframework.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.testingframework.enums.ConfigProperties;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ELKUtils {

	private ELKUtils() {
	}

	public static void sendDataToELK(String testname, String status) {

		if (ConfigReader.get(ConfigProperties.SENDRESULTTOELK).equalsIgnoreCase("yes")) {

			Map<String, String> map = new HashMap<>();
			map.put("testname", testname);
			map.put("status", status);
			map.put("executionTime", LocalDateTime.now().toString());

			Response response = RestAssured.given().header("Content-Type", "application/json").body(map)
					.post(ConfigReader.get(ConfigProperties.ELASTICSEARCHURL));

			Assert.assertEquals(response.statusCode(), 201);
			response.prettyPrint();
		}

	}

}
