package com.testingframework.pages;

import org.openqa.selenium.By;

import com.testingframework.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {

	private final By txtWelcome = By.xpath("//a[@id='welcome']");
	private final By clickLogout = By.xpath("//a[contains(text(),'Logout')]");

	public OrangeHRMHomePage clickWelcome() {
		
		clickButton(txtWelcome, WaitStrategy.PRESENCE, "Welcome link");

		return this;
	}

	public OrangeHRMLoginPage clickLogoutButton() {

		clickButton(clickLogout, WaitStrategy.CLICKABLE, "Logout link");
		return new OrangeHRMLoginPage();
	}

}
