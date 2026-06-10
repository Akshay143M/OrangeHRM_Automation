package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Factory class used to create browser objects
public class BrowserFactory {

	// Method to create and return browser instance based on browser name
	public static WebDriver createBrowserInstance(String browserName) {

		// Declare WebDriver reference and initialize with null
		WebDriver driver = null;

		// Check if browser name is Chrome
		if (browserName.equalsIgnoreCase("Chrome")) {

			// Create Chrome browser instance
			driver = new ChromeDriver();
		}

		// Check if browser name is Firefox
		if (browserName.equalsIgnoreCase("Firefox")) {

			// Create Firefox browser instance
			driver = new FirefoxDriver();
		}

		// Return the created browser driver object
		return driver;
	}
}