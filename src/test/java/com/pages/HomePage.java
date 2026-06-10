package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;
import com.driver.DriverFactory;

public class HomePage extends BasePage{

	private Logger logger = LogManager.getLogger(HomePage.class);

	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement Dashboard;

	@FindBy(xpath = "//button[@type='button' and @title='Help']")
	WebElement HelpLink;

	@FindBy(className = "orangehrm-upgrade-button")
	WebElement UpgradeButton;

	@FindBy(className = "oxd-userdropdown-name")
	WebElement ProfileLink;

	@FindBy(className = "oxd-main-menu-button")
	WebElement MenuButton;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement SearchBar;

	@FindBy(xpath = "//p[text()='Time at Work']")
	WebElement TimeAtWorkGraph;

	@FindBy(xpath = "//p[text()='My Actions']")
	WebElement MyActions;

	@FindBy(xpath = "//p[text()='Quick Launch']")
	WebElement QuickLaunchMenu;

	@FindBy(xpath = "//p[text()='Buzz Latest Posts']")
	WebElement BuzzLatestPosts;

	@FindBy(xpath = "//p[text()='Employees on Leave Today']")
	WebElement EmployeeOnLeaveList;

	@FindBy(xpath = "//p[text()='Employee Distribution by Sub Unit']")
	WebElement EmpDistBySubUnitChart;

	@FindBy(xpath = "//p[text()='Employee Distribution by Location']")
	WebElement EmpDistByLocationChart;

	public HomePage() {

		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);

	}

	public void LoginButtonRedirection() {

		String current_url = DriverFactory.getInstance().getDriver().getCurrentUrl();
		String expected_url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(current_url, expected_url);

		if (current_url.equals(expected_url)) {
			logger.info("Current_url is same as expected and the value is: " + current_url);
		}
		else {
			logger.error("Current url is not same as expected url");
		}

	}

	public void DashboardText() {

		boolean DashboardStatus = Dashboard.isDisplayed();
		Assert.assertTrue(DashboardStatus);
		if (DashboardStatus) {
			logger.info("Dashboard text is visible");
		}
		else {
			logger.error("Dashboard text is not visible");
		}
	}

	public void Helplink() {
		boolean helplinkvisibleStatus = HelpLink.isDisplayed();
		Assert.assertTrue(helplinkvisibleStatus);
		if (helplinkvisibleStatus) {
			logger.info("Help Link is visible on the homepage");
		} else {
			logger.error("Help Link is not visible on the homepage");
		}
	}

	public void upgradeButton() {
		boolean upgradeButtonVisibleStatus = UpgradeButton.isDisplayed();
		Assert.assertTrue(upgradeButtonVisibleStatus);
		if (upgradeButtonVisibleStatus) {
			logger.info("Upgrade button is visible on the homepage");
		} else {
			logger.error("Upgrade button is not visible on the homepage");
		}
	}


	public void profileLink() {
		boolean profileLinkVisibleStatus = ProfileLink.isEnabled();
		Assert.assertTrue(profileLinkVisibleStatus);
		if (profileLinkVisibleStatus) {
			logger.info("Profile link is enabled");
		} else {
			logger.error("Profile link is not enabled");
		}
	}

	public void menuButton() {

		logger.info("Scenario: Verify Menu Button is enabled on Home Page");

		logger.info("Given User is logged into the OrangeHRM application");

		logger.info("When User navigates to the Home Page");

		boolean menuBtnVisibleStatus = MenuButton.isEnabled();

		Assert.assertTrue(menuBtnVisibleStatus);

		if (menuBtnVisibleStatus) {

			logger.info("Then Menu button is enabled");

			logger.info("And User is able to interact with the Menu button");

		}
		else {

			logger.error("Then Menu button is not enabled");

		}

	}

	public void HideMenu() {
		MenuButton.click();
		logger.info("Menu is hidden");
	}

	public void ShowMenu() {
		MenuButton.click();
		logger.info("Menu is visible");
	}



}
