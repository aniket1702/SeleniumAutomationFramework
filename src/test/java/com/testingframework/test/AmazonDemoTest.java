package com.testingframework.test;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.testingframework.annotations.FrameworkAnnotation;
import com.testingframework.enums.CategoryTypes;
import com.testingframework.pages.AmazonHumburgerMenuPage;

public final class AmazonDemoTest extends BaseTest {
	
	private AmazonDemoTest() {}
	
	@FrameworkAnnotation(author= {"Aniket Maurya","John Doe"},category= {CategoryTypes.REGRESSION,CategoryTypes.SMOKE})
	@Test
	public void amazonMenuTest(Map<String,String> data) {
		
		String title=new AmazonHumburgerMenuPage()
						.clickHumbergerMenu()
						.menuText()
						.clickOnSubMenutem(data.get("menuItem"))
						.getTitle();
	
		Assertions.assertThat(title).isNotNull().isNotBlank();
	}

}
