package com.testingframework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.testingframework.enums.ConfigProperties;
import com.testingframework.utils.ConfigReader;

public class RetryFailedTest implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;

		if (ConfigReader.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value = count < retries;
			count++;
		}

		return value;
	}

}
