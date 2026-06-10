package com.javascript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.driver.DriverFactory;
import com.reports.ExtentFactory;

public class JavaScriptActions {

	private Logger logger = LogManager.getLogger(JavaScriptActions.class);

	public void click(WebElement element) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

			js.executeScript("arguments[0].click()", element);
			logger.info(element + "is clicked using javascript");
			ExtentFactory.getInstance();
			ExtentFactory.passTest(element + "is clicked using javascript");
		} catch (Exception e) {
			logger.error("Error occured while clicking on " + element + "using javascript" + e.getMessage());
			ExtentFactory.getInstance();
			ExtentFactory
					.failTest("Error occured while clicking on " + element + "using javascript" + e.getMessage());
		}

	}

	public void sendKeys(WebElement element, String value) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

			js.executeScript("arguments[0].value=" + "'" + value + "'", element);
			logger.info(value + "is entered using javascript in " + element);
			ExtentFactory.getInstance();
			ExtentFactory.passTest(value + "is entered using javascript in " + element);
		} catch (Exception e) {
			logger.error(
					"Error occured while entering the " + value + "in" + element + "using javascript" + e.getMessage());
			ExtentFactory.getInstance();
			ExtentFactory.failTest(
					"Error occured while entering the " + value + "in" + element + "using javascript" + e.getMessage());
		}

	}

	public void ScrollPageToViewElement(WebElement element) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

			js.executeScript("arguments[0].ScrollIntoView(true)", element);
			logger.info("Element is visible on the screen");
			ExtentFactory.getInstance();
			ExtentFactory.passTest("Element is visible on the screen");
		} catch (Exception e) {
			logger.error(
					"Error occured while scrolling the page" + e.getMessage());
			ExtentFactory.getInstance();
			ExtentFactory.failTest(
					"Error occured while scrolling the page" + e.getMessage());
		}

	}

	public void ScrollTillEndOfPage() {

		try {

			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			logger.info("Page is scrolled till the end");
			ExtentFactory.getInstance();
			ExtentFactory.passTest("Page is scrolled till the end");
		} catch (Exception e) {
			logger.error(
					"Error occured while scrolling the page till end" + e.getMessage());
			ExtentFactory.getInstance();
			ExtentFactory.failTest(
					"Error occured while scrolling the page till end" + e.getMessage());
		}

	}

}
