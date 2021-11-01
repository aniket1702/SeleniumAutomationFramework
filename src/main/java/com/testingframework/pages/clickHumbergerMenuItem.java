package com.testingframework.pages;

import org.openqa.selenium.By;

import com.testingframework.enums.WaitStrategy;

public final class clickHumbergerMenuItem extends BasePage {

	
	private final By menutext = By.xpath("//div[contains(text(),'Mobiles, Computers')]");

	

	public AmazonSubMenuItem menuText() {
		clickButton(menutext, WaitStrategy.CLICKABLE, "Menu Text");
		return new AmazonSubMenuItem();
	}
	
	

}
