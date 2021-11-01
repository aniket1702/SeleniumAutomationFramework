package com.testingframework.pages;

import org.openqa.selenium.By;

import com.testingframework.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {

	private final By inputUsername = By.xpath("//input[@id='txtUsername']");
	private final By inputPassword = By.xpath("//input[@id='txtPassword']");

	private final By clickLogin = By.xpath("//input[@id='btnLogin']");

	public OrangeHRMLoginPage enterUsername(String username) {
		sendKeys(inputUsername, username, WaitStrategy.PRESENCE, "Username");

		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(inputPassword, password, WaitStrategy.PRESENCE, "Password");

		return this;
	}

	public OrangeHRMHomePage clickLoginButton() {
		clickButton(clickLogin, WaitStrategy.CLICKABLE, "Login Button");

		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();

	}

}
