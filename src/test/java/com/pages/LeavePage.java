package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class LeavePage extends BasePage{

	@FindBy(xpath = "//span[text()='Leave']")
	private WebElement LeaveMenu;

	@FindBy(xpath = "(//input[@placeholder=\"yyyy-dd-mm\"])[1]")
	private WebElement fromDate;








}
