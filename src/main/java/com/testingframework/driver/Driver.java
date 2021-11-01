package com.testingframework.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.testingframework.enums.ConfigProperties;
import com.testingframework.exceptions.BrowserInvocationFailedException;
import com.testingframework.factories.DriverFactory;
import com.testingframework.utils.ConfigReader;

/**
 * 
 * 
 * 
 * <p>
 * Driver class is responsible for <b>Initiating</b> and <b>Cosing</b> the
 * browser.
 * </p>
 * 
 * <p>
 * It is also responsible for setting the browser variable and version which
 * handles thread safety for webdriver class.
 * </p>
 * 
 * 
 * 31-Oct-2021
 * 
 * @author ANIKET
 * @version 1.0
 * 
 *
 * @see DriverManager
 * @see com.testingframework.test.BaseTest
 */

public final class Driver {
	/**
	 * 
	 * Private constructor to avoid external Instantiation.
	 */
	private Driver() {

	}

	/**
	 * @param browser value will be passed from
	 *                {@link com.testingframework.test.BaseTest}. Values can be
	 *                firefox and chrome.
	 * 
	 * @param version value will be passed from
	 *                {@link com.testingframework.test.BaseTest}. Values will be
	 *                based on browser version
	 */
	public static void initDriver(String browser, String version) {

		if (Objects.isNull(DriverManager.getDriver())) {

			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser, version));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser invocation failed. Please check the capabilities.");
			}

			DriverManager.getDriver().get(ConfigReader.get(ConfigProperties.URL));

			DriverManager.getDriver().manage().window().maximize();

		}
	}

	/**
	 * quitDriver method to Close, Delete the browser cookies and unload it from
	 * DriverManager Class.
	 * 
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}
}
