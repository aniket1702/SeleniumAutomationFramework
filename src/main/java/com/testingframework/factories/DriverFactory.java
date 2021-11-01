package com.testingframework.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testingframework.enums.ConfigProperties;
import com.testingframework.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser, String version) throws MalformedURLException {

		WebDriver driver = null;

		String runmode = ConfigReader.get(ConfigProperties.RUNMODE);
		if (browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// FrameworkConstants.getChromeDriverPath());

			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setAcceptInsecureCerts(true);
				cap.setBrowserName(BrowserType.CHROME);
				// cap.setVersion(version);
				driver = new RemoteWebDriver(new URL(ConfigReader.get(ConfigProperties.SELENIUMGRIDURL)), cap);

			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		} else if (browser.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.gecko.driver",
			// FrameworkConstants.getFirefoxDriverPath());

			WebDriverManager.firefoxdriver().setup();

			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL(ConfigReader.get(ConfigProperties.SELENIUMGRIDURL)), cap);

			} else {
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}

}
