package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.driver.BrowserFactory;
import com.driver.DriverFactory;

//BaseTest class used for common setup and teardown
public class BaseTest {

	// Run before every test method
	@BeforeMethod
	public void setUp() {

		// Create BrowserFactory object
		BrowserFactory browserFactory = new BrowserFactory();

		// Create browser instance
		WebDriver driver = BrowserFactory.createBrowserInstance("Chrome");

		// Store driver inside DriverFactory
		DriverFactory.getInstance().setDriver(driver);

		// Maximize browser window
		DriverFactory.getInstance().getDriver().manage().window().maximize();

		// Open application URL
		DriverFactory.getInstance().getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}

	// Run after every test method
	@AfterMethod
	public void tearDown() {

		// Close browser
		DriverFactory.getInstance().getDriver().quit();
	}
}
