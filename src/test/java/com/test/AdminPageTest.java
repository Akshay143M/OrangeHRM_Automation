package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.AdminPage;
import com.properties.TestDataLoader;
import com.waits.ImplicitWaitActions;

public class AdminPageTest extends BaseTest {

	private AdminPage adminpage;
	private ImplicitWaitActions implicitwaitActions;
	private Logger logger;

	@BeforeMethod
	public void setupPage() {
		adminpage = new AdminPage();
		implicitwaitActions = new ImplicitWaitActions();
		implicitwaitActions.setImplicitWait();
		logger = LogManager.getLogger(AdminPageTest.class);
	}
	@Test(priority = 9)
	public void addUserFlow() {
		logger.info("========== START TEST : Add User ==========");
		adminpage.ClickOnAdminLink();
		adminpage.ClickOnAddButton();
		adminpage.SelectUserRole(TestDataLoader.getInstance().setUserRole());
		adminpage.EnterEmpName(TestDataLoader.getInstance().getEmpName());
		adminpage.SelectStatus(TestDataLoader.getInstance().setStatus());
		adminpage.EnterUsername(TestDataLoader.getInstance().getNewUsername());
		adminpage.EnterPassword(TestDataLoader.getInstance().getNewPassword());
		adminpage.ConfirmPassword(TestDataLoader.getInstance().getConfirmPassword());
		adminpage.ClickOnSaveButton();
		logger.info("========== END TEST : Add User ==========");
	}


}
