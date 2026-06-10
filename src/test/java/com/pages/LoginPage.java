package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.driver.DriverFactory;

public class LoginPage extends BasePage{

	@FindBy(name = "username")
	private WebElement usernameTextBox;

	@FindBy(name = "password")
	private WebElement passwordTestBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;


	public LoginPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public void LoginToApplication(String userNameValue, String passwordValue) {
		super.sendKeys(usernameTextBox, "username textbox", userNameValue);
		super.sendKeys(passwordTestBox, "password textbox", passwordValue);
		super.click(loginButton, "Login button");
	}

}
