package com.alert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.driver.DriverFactory;
import com.reports.ExtentFactory;

public class AlertActions {

	private Logger logger = LogManager.getLogger(AlertActions.class);

	private Alert alert;

	public void switchToAlert() {
		try {
		DriverFactory.getInstance().getDriver().switchTo().alert();
		logger.info("Switched to alert");
		ExtentFactory.getInstance();
		ExtentFactory.passTest("Switched to alert");
		} catch (NoAlertPresentException e) {
			logger.error("Exception occured while switching to the alert");
			ExtentFactory.getInstance();
			ExtentFactory.failTest("Exception occured while switching to the alert");
		}
	}

	public void acceptAlert() {

		try {
		this.alert.accept();
		logger.info("Alert is accepted");
		ExtentFactory.getInstance();
		ExtentFactory.passTest("Alert is accepted");
		} catch (Exception e) {
			logger.error("Exception occured while accepting the alert");
			ExtentFactory.getInstance();
			ExtentFactory.failTest("Exception occured while accepting the alert");
		}
	}

	public void cancelAlert() {
		try {
		this.alert.dismiss();
		logger.info("Alert is dismissed");
		ExtentFactory.getInstance();
		ExtentFactory.passTest("Alert is dismissed");
		} catch (Exception e) {
			logger.error("Exception occured while dismissing the alert");
			ExtentFactory.getInstance();
			ExtentFactory.failTest("Exception occured while dismissing the alert");
		}
	}

}
