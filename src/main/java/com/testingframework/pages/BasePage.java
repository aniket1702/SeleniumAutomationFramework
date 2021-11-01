package com.testingframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testingframework.driver.DriverManager;
import com.testingframework.enums.WaitStrategy;
import com.testingframework.factories.ExplicitWaitFactory;
import com.testingframework.reports.ExtentLoggers;

public class BasePage {

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy,String elementname) {

		WebElement element = ExplicitWaitFactory.performExplicitStaticWait(waitStrategy, by);
		element.sendKeys(value);
		try {
			ExtentLoggers.pass(value +" is entered successfully in "+elementname+" field...",true);
		} catch (Exception e) {
	
			e.printStackTrace();
		}

	}

	protected void clickButton(By by, WaitStrategy waitStrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitStaticWait(waitStrategy, by);
		element.click();
		try {
			ExtentLoggers.pass(elementname+" is Clicked...",true);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}



}
