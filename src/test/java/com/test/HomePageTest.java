package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.waits.ImplicitWaitActions;

public class HomePageTest extends BaseTest{
	private HomePage homepage;
	private ImplicitWaitActions implicitWait;
	private Logger logger;

	@BeforeMethod
	public void setupPage() {
		homepage = new HomePage();
		implicitWait = new ImplicitWaitActions();
		implicitWait.setImplicitWait();
		logger = LogManager.getLogger(HomePageTest.class);
	}
	@Test(priority = 1)
	public void LoginPageRedirection() {
		homepage.LoginButtonRedirection();

	}
	@Test(priority = 2)
	public void DashboardTextVisibleOrNot() {

		homepage.DashboardText();

	}

	@Test(priority = 3)
	public void HelplinkVisibilityStatus() {
		homepage.Helplink();
	}

	@Test(priority = 4)
	public void UpgradeButtonStatus() {
		homepage.upgradeButton();
	}

	@Test(priority = 5)
	public void ProfileVisibilityStatus() {
		homepage.profileLink();
	}

	@Test(priority = 6)
	public void MenuButtonVisibilityStatus() {
		homepage.menuButton();
	}

	@Test(priority = 7)
	public void HideTheMenu() {
		homepage.HideMenu();
	}

	@Test(priority = 8)
	public void ShowMenu() {
		homepage.ShowMenu();
	}





}
