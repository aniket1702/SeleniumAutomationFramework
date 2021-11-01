package com.testingframework.pages;

import org.openqa.selenium.By;

import com.testingframework.enums.WaitStrategy;

public final class AmazonHumburgerMenuPage extends BasePage {

	private final By humbergerMenu = By.xpath("//a[@id='nav-hamburger-menu']");

	public clickHumbergerMenuItem clickHumbergerMenu() {
		clickButton(humbergerMenu, WaitStrategy.CLICKABLE, "Humberger Menu");

		return new clickHumbergerMenuItem();
	}

}
