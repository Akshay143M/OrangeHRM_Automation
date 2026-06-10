package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.properties.TestDataLoader;

public class LoginTest extends BaseTest {

	@Test(priority = 0)
	public void loginWithValidUsernameAndValidPassowrd() {

		LoginPage loginpage = new LoginPage();

		loginpage.LoginToApplication(TestDataLoader.getInstance().getUsername(),
				TestDataLoader.getInstance().getPassword());

	}

}
