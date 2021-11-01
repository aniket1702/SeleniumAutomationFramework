package com.testingframework.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testingframework.constants.FrameworkConstants;
import com.testingframework.enums.CategoryTypes;

public final class ExtentReport {
	private ExtentReport() {
	}

	private static ExtentReports extent;
	public static ExtentTest extentTest;

	public static void initReport() {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Selenium Testing Framework");
			spark.config().setReportName("Selenium Testing Framework");

		}
	}

	public static void createTest(String testcasename) {

		ExtentReportManager.setExtentTest(extent.createTest(testcasename));
	}

	public static void flushReport() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentReportManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// Adding Authors and categories to Extent Report
	public static void addAuthors(String[] authors) {
		for (String temp : authors) {
			ExtentReportManager.getExtentTest().assignAuthor(temp);
		}
	}

	public static void addCategories(CategoryTypes[] categories) {
		for (CategoryTypes temp : categories) {
			ExtentReportManager.getExtentTest().assignCategory(temp.toString());
		}
	}
}
