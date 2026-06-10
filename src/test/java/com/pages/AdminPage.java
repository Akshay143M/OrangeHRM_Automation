package com.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;
import com.driver.DriverFactory;

public class AdminPage extends BasePage {

	private Logger logger = LogManager.getLogger(AdminPage.class);

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement AdminLink;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement AddBtn;

	@FindBy(xpath = "//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
	private WebElement userRoleDropdown;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> userRoleOptions;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement EmpName;

	@FindBy(xpath = "//div[@role='listbox']//span")
	private List<WebElement> employeeSuggestions;

	@FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
	private WebElement statusDropdown;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> statusOptions;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement usrname;

	@FindBy(xpath = "(//input[@type=\"password\"])[1]")
	private WebElement pwd;

	@FindBy(xpath = "(//input[@type=\"password\"])[2]")
	private WebElement confirmPwd;

	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement saveBtn;

	public AdminPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public void ClickOnAdminLink() {
		try {
			logger.info("Scenario: Verify Admin link is clickable or not");
			click(AdminLink, "Admin link");
			logger.info("User clicked on Admin");
			logger.info("And redirected to the Add user form");
		} catch (Exception e) {
			logger.error("Admin link is not clickable" + e.getMessage());
		}
	}

	public void ClickOnAddButton() {
		try {
			logger.info("Scenario: Verify if the user is able to click on Add button");
			click(AddBtn, "Add Button");
			logger.info("Then- User has clicked on Add button");
			logger.info("And redirected to the add user form");
		} catch (Exception e) {
			logger.error("Admin link is not clickable " + e.getMessage());
	        Assert.fail("Admin link is not clickable: " + e.getMessage());
		}
	}

	public void SelectUserRole(String role) {

		try {
			boolean roleSelected = false;
			logger.info("Scenario: Verify if the user is able to select the user role");
			click(userRoleDropdown, "Select user role");
			for (WebElement option : userRoleOptions) {
				String actualText = option.getText();
				if (actualText.equals(role)) {
					click(option, role + "option");
					roleSelected = true;
					logger.info("User has selected the " + role);
					break;
				}
			}
			Assert.assertTrue(roleSelected, role +" role was not selected");


		} catch (Exception e) {
			logger.error("User role is not selected" + e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


	public void EnterEmpName(String employeeName) {
		try {
			sendKeys(EmpName, "Employee Name", employeeName);

		    explicitwaitActions.waitForElementToBePresent(
		            employeeSuggestions.get(0),
		            "First Employee Suggestion");

		    explicitwaitActions.waitForElementToBeClickable(
		            employeeSuggestions.get(0),
		            "First Employee Suggestion");

		    employeeSuggestions.get(0).click();

	    } catch (Exception e) {

	        logger.error("Employee name not selected: " + e.getMessage());

	        Assert.fail(e.getMessage());

	    }
	}
	public void SelectStatus(String status) {
		try {
			boolean statusSelected = false;
			logger.info("Scenario: Verify if the user is able to select the status");
			click(statusDropdown, "Select status");
			for (WebElement option : statusOptions) {
				String actualText = option.getText();
				if (actualText.equals(status)) {
					click(option, status + "option");
					statusSelected = true;
					logger.info("User has selected the " + status);
					break;
				}
			}
			Assert.assertTrue(statusSelected, status + " status was not selected");
		} catch (Exception e) {
			logger.error("Status is not selected " + e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	public void EnterUsername(String username) {
		try {
			logger.info("Scenario: Verify if the user is able to enter the username");
	        sendKeys(usrname, "User Name", username);

	        logger.info("Username entered successfully: " + username);
		}catch (Exception e) {
			logger.error("User is not able to enter the username " + e.getMessage());
		    Assert.fail("User is not able to enter the username: " + e.getMessage());
		}
	}

	public void EnterPassword(String Password) {
		try {
		logger.info("Scenario: Verify if the user is able to enter the password");
		click(pwd, "Password");
		sendKeys(pwd, "Password", Password);
		logger.info("Password value is entered");
		}catch (Exception e) {
			logger.error("Password not entered in the textbox " +e.getMessage());
		}
	}

	public void ConfirmPassword(String ConfPassword) {
		try {
		logger.info("Scenario: Verify if the user is able to re-enter the password");
		click(confirmPwd, "Confirm Password");
		sendKeys(confirmPwd, "Confirm Password", ConfPassword);
		logger.info("Password is confirmed");
		}catch (Exception e) {
			logger.error("Password not re-entered in the textbox " +e.getMessage());
		}
	}

	public void ClickOnSaveButton() {
		try {
		logger.info("Scenario: Verify if the user is able to click the save button");
		click(saveBtn, "Save Button");
		}catch (Exception e) {
			logger.error("User is not added " + e.getMessage());
		    Assert.fail("User is not added: " + e.getMessage());
		}
	}

}
