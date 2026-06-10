package com.waits;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.reports.ExtentFactory;

public class ExplicitWaitActions {

	private Logger logger = LogManager.getLogger(ExplicitWaitActions.class);

	public void waitForElementToBePresent(WebElement element, String elementName) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.visibilityOf(element));

			logger.info(elementName + " is available on the screen");
		} catch (Exception e) {
			logger.error("Error occured while waiting for the element to be visible" + e.getMessage());
			ExtentFactory.getInstance();
			ExtentFactory
					.failTest("Error occured while waiting for the element to be visible" + e.getMessage());
		}
	}

	public void waitForElementToBeClickable(WebElement element, String elementName) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),
					Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			logger.info(elementName + " is clickable");
		} catch (Exception e) {
			logger.error("Error occured while waiting for the element to be clickable" + e.getMessage());
			ExtentFactory.getInstance();
			ExtentFactory
					.failTest("Error occured while waiting for the element to be clickable" + e.getMessage());
		}
	}

	public void waitForElementsToBeVisible(List<WebElement> elements, String elementName) {

	    try {
	        WebDriverWait wait = new WebDriverWait(
	                DriverFactory.getInstance().getDriver(),
	                Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

	        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	        logger.info(elementName + " are visible");
	    } catch (Exception e) {
	        logger.error("Error occured while waiting for elements to be visible " + e.getMessage());
	        ExtentFactory.getInstance();
			ExtentFactory
	                .failTest("Error occured while waiting for elements to be visible " + e.getMessage());
	    }
	}




}
