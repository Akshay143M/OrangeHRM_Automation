package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.properties.TestDataLoader;

public class LoginTest extends BaseTest {
	private Logger logger = LogManager.getLogger(LoginTest.class);

	@Test(priority = 0)
	public void loginWithValidUsernameAndValidPassowrd() {
		logger.info("========== START TEST : Login OrangeHRM ==========");

		LoginPage loginpage = new LoginPage();

		loginpage.LoginToApplication(TestDataLoader.getInstance().getUsername(),
				TestDataLoader.getInstance().getPassword());
		logger.info("========== END TEST : Login OrangeHRM ==========");

	}

}
