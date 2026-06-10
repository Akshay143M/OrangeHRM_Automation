package com.base;

import org.openqa.selenium.WebElement;

import com.alert.AlertActions;
import com.iframe.IFrameActions;
import com.javascript.JavaScriptActions;
import com.reports.ExtentFactory;
import com.waits.ExplicitWaitActions;

public class BasePage {

	protected AlertActions alertActions;
	protected IFrameActions iframeActions;
	protected JavaScriptActions javascriptActions;
	protected ExplicitWaitActions explicitwaitActions;

	protected BasePage() {
		alertActions = new AlertActions();
		iframeActions = new IFrameActions();
		javascriptActions = new JavaScriptActions();
		explicitwaitActions = new ExplicitWaitActions();

	}

	public void click(WebElement element, String elementName) {
		explicitwaitActions.waitForElementToBeClickable(element, elementName);
		element.click();
		ExtentFactory.getInstance();
		ExtentFactory.passTest(elementName+ " is clicked");
	}

	public void sendKeys(WebElement element, String elementName, String Value) {
		explicitwaitActions.waitForElementToBePresent(element, elementName);
		element.clear();
		element.sendKeys(Value);
		ExtentFactory.getInstance();
		ExtentFactory.passTest(Value+ " is entered in " +elementName);
	}

	public void sendKeys(WebElement element, String elementName, int value) {
		explicitwaitActions.waitForElementToBePresent(element, elementName);
		element.clear();
		element.sendKeys(String.valueOf(value));
		ExtentFactory.getInstance();
		ExtentFactory.passTest(value+ " is entered in " +elementName);
	}

	public boolean isElementSelected(WebElement element, String elementName) {
		explicitwaitActions.waitForElementToBePresent(element, elementName);
		return element.isSelected();
	}

	public void selectCheckBox(WebElement element, String elementName) {
		if(!this.isElementSelected(element, elementName)) {
			this.click(element, elementName);
		}
		else {
			ExtentFactory.getInstance();
			ExtentFactory.failTest(elementName+ " is already selected");
		}
	}






}
