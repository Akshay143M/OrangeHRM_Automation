package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.PIMPage;
import com.properties.TestDataLoader;
import com.waits.ExplicitWaitActions;
import com.waits.ImplicitWaitActions;

public class PIMPageTest extends BaseTest {

	private PIMPage PIMpage;
	private ImplicitWaitActions implicitwaitactions;
	private ExplicitWaitActions explicitwaitActions;
	private Logger logger;

	@BeforeMethod
	public void setupPage() {
		PIMpage = new PIMPage();
		implicitwaitactions = new ImplicitWaitActions();
		implicitwaitactions.setImplicitWait();
		logger = LogManager.getLogger(PIMPageTest.class);
	}

	@Test(priority = 10)
	public void SearchEmployee() {
		logger.info("========== START TEST : Search Employee ==========");
		PIMpage.Pim_menu();
		PIMpage.enterEmployeeName(TestDataLoader.getInstance().setPIMEmpName());
		PIMpage.enterEmployeeID(TestDataLoader.getInstance().setPIMEmpID());
		PIMpage.selectEmployeeStatus(TestDataLoader.getInstance().setPIMEmpStatus());
		PIMpage.selectInclude(TestDataLoader.getInstance().setPIMinclude());
		PIMpage.enterSupervisorName(TestDataLoader.getInstance().setPIMSupervisorName());
		PIMpage.selectPIMJobTitle();
		PIMpage.selectPIMSubUnit();
		PIMpage.clickOnSearchButton();
		PIMpage.verifyNoRecordsFoundMessage();
		logger.info("========== END TEST : Search Employee ==========");
	}

	@Test(priority = 11)
	public void AddEmployee() {

		logger.info("========== START TEST : Add Employee ==========");

		PIMpage.addEmployee();

		PIMpage.enterFirstName(TestDataLoader.getInstance().setPIMfirstName());
		PIMpage.enterMiddleName(TestDataLoader.getInstance().setPIMmiddleName());
		PIMpage.enterLastName(TestDataLoader.getInstance().setPIMlastName());

		explicitwaitActions.waitForElementToBePresent(PIMpage.getUploadEmployeeImage(), "Upload Profile Image");

		PIMpage.uploadProfileImage(TestDataLoader.getInstance().setPIMfilepath());

		logger.info("========== END TEST : Add Employee ==========");
	}

}
