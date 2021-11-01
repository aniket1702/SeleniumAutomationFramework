package com.testingframework.pages;

import org.openqa.selenium.By;

import com.testingframework.enums.WaitStrategy;
import com.testingframework.utils.DynamicXpathUtils;

public final class AmazonSubMenuItem extends BasePage{
	
	
	private final String subMenuItem = "//a[contains(text(),'%s')]";
	
	
	public AmazonLaptopPage clickOnSubMenutem(String menuText) {
		String newXpath=DynamicXpathUtils.getXpath(subMenuItem, menuText);
		clickButton(By.xpath(newXpath), WaitStrategy.CLICKABLE, menuText);
		
		if(menuText.contains("Laptops")) {
			return new AmazonLaptopPage();
			
		}
		return null;
		
		
	}

}
