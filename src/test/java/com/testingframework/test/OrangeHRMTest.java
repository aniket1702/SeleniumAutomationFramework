package com.testingframework.test;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.testingframework.pages.OrangeHRMLoginPage;

public final class OrangeHRMTest extends BaseTest {

	private OrangeHRMTest() {

	}

	@Test
	public void loginLogoutTest(Map<String,String> data) {

		String title = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
				.clickWelcome().clickLogoutButton().getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");

	}

	@Test
	public void newTest(Map<String,String> data) {

		String title = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
				.clickWelcome().clickLogoutButton().getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");

	}
	
	
}
