package com.iframe;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.reports.ExtentFactory;

public class IFrameActions {

	private Logger logger = LogManager.getLogger(IFrameActions.class);

	public void waitForIframeAndSwitch(String IdOrName) {

		try {

			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdOrName));
			logger.info("Switched to the iframe");
			ExtentFactory.getInstance();
			ExtentFactory.passTest("Switched to the iframe");
		} catch (Exception e) {
			logger.error("Error occured while swithcing to the iframe");
			ExtentFactory.getInstance();
			ExtentFactory.failTest("Error occured while swithcing to the iframe");
		}

	}

	public void waitForIframeAndSwitch(int index) {

		try {

			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
			logger.info("Switched to the iframe");
			ExtentFactory.getInstance();
			ExtentFactory.passTest("Switched to the iframe");
		} catch (Exception e) {
			logger.error("Error occured while swithcing to the iframe");
			ExtentFactory.getInstance();
			ExtentFactory.failTest("Error occured while swithcing to the iframe");
		}

	}

	public void switchBackToDefaultContent() {

		try {
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		logger.info("Switched back to default content");
		ExtentFactory.getInstance();
		ExtentFactory.failTest("Switched back to default content");
		} catch (Exception e) {
			logger.error("Error occured while switching back to the default content");
			ExtentFactory.getInstance();
			ExtentFactory.failTest("Error occured while switching back to the default content");
		}
	}

}
