package com.testingframework.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

	private ExtentReportManager() {

	}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();

	static ExtentTest getExtentTest() {
		return extTest.get();
	}

	static void setExtentTest(ExtentTest extentTest) {
		if (Objects.nonNull(extentTest)) {
			extTest.set(extentTest);
		}

	}

	static void unload() {
		extTest.remove();
	}
}
