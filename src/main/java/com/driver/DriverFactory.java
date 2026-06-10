package com.driver;

import org.openqa.selenium.WebDriver;

//DriverFactory class used to manage driver objects
public class DriverFactory {

	// ThreadLocal stores separate driver object for each thread
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// Private constructor to prevent external object creation
	private DriverFactory() {

	}

	// Create single object of DriverFactory class
	private static DriverFactory instance = new DriverFactory();

	// Method to return single DriverFactory object
	public static DriverFactory getInstance() {

		// Return existing DriverFactory instance
		return instance;
	}

	// Method to store driver object inside ThreadLocal
	public void setDriver(WebDriver driverObj) {

		// Set driver object for current thread
		driver.set(driverObj);
	}

	// Method to get driver object from ThreadLocal
	public WebDriver getDriver() {

		// Return current thread driver object
		return driver.get();
	}
}