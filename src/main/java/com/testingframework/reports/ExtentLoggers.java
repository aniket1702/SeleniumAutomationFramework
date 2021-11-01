package com.testingframework.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.testingframework.enums.ConfigProperties;
import com.testingframework.utils.ConfigReader;
import com.testingframework.utils.ScreenshotUtils;

public final class ExtentLoggers {
	private ExtentLoggers() {
		
	}
	
	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message);
	}
	
	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message);
	}
	
	public static void skip(String message) {
		ExtentReportManager.getExtentTest().skip(message);
	}
	
	/*
	 * 
	 * Override methods For Screenshots
	 */
	public static void pass(String message, boolean isScreenshotNeeded) {
		if(ConfigReader.get(ConfigProperties.PASSEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
		
	}
	
	public static void fail(String message, boolean isScreenshotNeeded)  {
		if(ConfigReader.get(ConfigProperties.FAILEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
		
	}
	
	public static void skip(String message, boolean isScreenshotNeeded)  {
		if(ConfigReader.get(ConfigProperties.SKIPPEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
		
	}
	


}
