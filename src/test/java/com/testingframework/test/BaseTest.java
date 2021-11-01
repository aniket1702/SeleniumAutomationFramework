package com.testingframework.test;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.testingframework.driver.Driver;

/**
 * 
 * 31-Oct-2021
 * 
 * @author ANIKET
 * @version 1.0 TODO
 */
public class BaseTest {

	protected BaseTest() {

	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {
		Map<String, String> map = (Map<String, String>) data[0];
		Driver.initDriver(map.get("browser"), map.get("version"));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

	@AfterSuite
	protected void afterSuit() throws IOException {

	}

}
