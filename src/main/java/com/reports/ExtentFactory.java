package com.reports;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.driver.DriverFactory;

//Factory class used to manage ExtentTest objects
public class ExtentFactory {

	// ThreadLocal stores separate ExtentTest object for each thread
	ThreadLocal<ExtentTest> extent = new ThreadLocal<>();

	// Private constructor prevents external object creation
	private ExtentFactory() {

	}

	// Create single object of ExtentFactory class
	private static ExtentFactory instance = new ExtentFactory();

	// Method used to return single shared instance
	public static ExtentFactory getInstance() {

		// Return existing ExtentFactory object
		return instance;
	}

	// Method used to store ExtentTest object inside ThreadLocal
	public void setExtent(ExtentTest obj) {

		// Store ExtentTest object for current thread
		extent.set(obj);
	}

	// Method used to get ExtentTest object from ThreadLocal
	public ExtentTest getExtentTest() {

		// Return current thread ExtentTest object
		return extent.get();
	}

	// Method used to remove ExtentTest object from ThreadLocal memory
	public void removeTest() {

		// Remove current thread ExtentTest object
		extent.remove();
	}

	// Method used to capture application screenshot and return Base64 string
	public static String captureApplicationScreenshot() {

		// Convert WebDriver object into TakesScreenshot interface
		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getInstance().getDriver();

		// Capture screenshot and store it as File
		File file = screenshot.getScreenshotAs(OutputType.FILE);

		// Create byte array variable to store file content
		byte[] filecontent = null;

		try {

			// Convert screenshot file into byte array
			filecontent = FileUtils.readFileToByteArray(file);

		} catch (IOException e) {

			// Print exception details if error occurs
			e.printStackTrace();
		}

		// Convert byte array into Base64 string and return it
		return Base64.getEncoder().encodeToString(filecontent);
	}

	// Method used to log successful click action in Extent Report
	public static void clickPass(String btnName) {

		// Add PASS log when button click is successful
		getInstance().getExtentTest().pass(btnName + " button is clicked.");
	}

	// Method used to log failed click action in Extent Report
	public static void clickFail(String btnName) {

		// Add FAIL log when button click fails
		getInstance().getExtentTest().fail("Error occured while clicking on " + btnName);
	}

	// Method used to log successful text entry action
	public static void sendKeysPass(String value, String elementName) {

		// Add PASS log when value is entered successfully
		getInstance().getExtentTest().pass(value + " entered in the " + elementName);
	}

	// Method used to log failed text entry action
	public static void sendKeysFail(String value, String elementName) {

		// Add FAIL log when entering value fails
		getInstance().getExtentTest().fail("Error occured while entering the " + value + " in textbox " + elementName);
	}

	// Method used to mark entire test as PASS with colored message
	public static void passTest(String message) {

		// Add green colored PASS label in report
		getInstance().getExtentTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	// Method used to mark entire test as FAIL with screenshot
	public static void failTest(String message) {

		// Add FAIL log with screenshot attached in report
		getInstance().getExtentTest().fail(message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(captureApplicationScreenshot()).build());
	}
}
