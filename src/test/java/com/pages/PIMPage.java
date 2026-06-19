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

public class PIMPage extends BasePage {

	private Logger logger = LogManager.getLogger(PIMPage.class);

//	=======================Webelements locators of searching the employee information===================

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement PIMmenu;

	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	private WebElement employeeName;

	@FindBy(xpath = "//div[@role='listbox']")
	private List<WebElement> nameSuggestions;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement empId;

	@FindBy(xpath = "//label[text()='Employment Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
	private WebElement employmentStatusdropdown;

	@FindBy(xpath = "//div[@role='option']//span")
	private List<WebElement> employmentStatusSuggestions;

	@FindBy(xpath = "//label[text()='Include']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--after')]")
	private WebElement includeDropdown;

	@FindBy(xpath = "//div[@role='listbox']//span")
	private List<WebElement> includeDropdownList;

	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
	private WebElement SupervisorName;

	@FindBy(xpath = "//div[@role='listbox']//span")
	private List<WebElement> supervisorSuggestions;

	@FindBy(xpath = "//label[text()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--after')]")
	private WebElement jobTitledropdown;

	@FindBy(xpath = "//div[@role='listbox']")
	private List<WebElement> jobTitleList;

	@FindBy(xpath = "//label[text()='Sub Unit']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--after')]")
	private WebElement subUnitDropdown;

	@FindBy(xpath = "//div[@role='listbox']")
	private List<WebElement> subUnitList;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[normalize-space()='No Records Found']")
	private WebElement noRecordFoundMessage;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement resetButton;

//	=======================Webelements locators of Adding the employee information===================

	@FindBy(xpath = "//button[@type='button' and text()=' Add ']")
	private WebElement AddButton;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstNametextBox;

	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement middleNametextBox;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastNametextBox;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement employeeIDtextBox;

	@FindBy(className = "employee-image")
	private WebElement uploadEmployeeImage;
	
	public WebElement getUploadEmployeeImage() {
	    return uploadEmployeeImage;
	}

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement createLoginDetailsToggle;

	@FindBy(xpath = "(//input[@autocomplete='off'])[1]")
	private WebElement userName;

	@FindBy(xpath = "(//input[@autocomplete='off'])[2]")
	private WebElement password;

	@FindBy(xpath = "(//input[@autocomplete='off'])[3]")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[@type='button' and text()=' Cancel ']")
	private WebElement cancelButton;

	public PIMPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	public void Pim_menu() {

		click(PIMmenu, "PIM menu");

	}

	public void enterEmployeeName(String name) {

		try {

			logger.info("Step: Enter Employee Name - " + name);

			sendKeys(employeeName, "Employee Name", name);

			Assert.assertFalse(nameSuggestions.isEmpty(), "No employee suggestions displayed");

			explicitwaitActions.waitForElementToBePresent(nameSuggestions.get(0), "First Employee Suggestion");

			explicitwaitActions.waitForElementToBeClickable(nameSuggestions.get(0), "First Employee Suggestion");

			nameSuggestions.get(0).click();

			logger.info("Employee name selected successfully");

		} catch (Exception e) {

			logger.error("Failed to enter employee name: " + e.getMessage());

			Assert.fail("Failed to enter employee name: " + e.getMessage());
		}
	}

	public void enterEmployeeID(String id) {

		try {

			logger.info("Step: Enter Employee ID - " + id);

			sendKeys(empId, "Employee ID", id);

			logger.info("Employee ID entered successfully");

		} catch (Exception e) {

			logger.error("Failed to enter Employee ID: " + e.getMessage());

			Assert.fail("Failed to enter Employee ID: " + e.getMessage());
		}
	}

	public void selectEmployeeStatus(String status) {

		try {

			logger.info("Step: Select Employee Status - " + status);

			boolean statusSelected = false;

			click(employmentStatusdropdown, "Employment Status");

			for (WebElement option : employmentStatusSuggestions) {

				String actualText = option.getText();

				logger.info("Available Status: " + actualText);

				if (actualText.equalsIgnoreCase(status)) {

					click(option, actualText);

					statusSelected = true;

					break;
				}
			}

			Assert.assertTrue(statusSelected, "Employee Status not found: " + status);

			logger.info("Employee Status selected successfully");

		} catch (Exception e) {

			logger.error("Failed to select Employee Status: " + e.getMessage());

			Assert.fail("Failed to select Employee Status: " + e.getMessage());
		}
	}

	public void selectInclude(String value) {

		try {

			logger.info("Step: Select Include Option - " + value);

			boolean valueSelected = false;

			click(includeDropdown, "Include Dropdown");

			for (WebElement option : includeDropdownList) {

				String actualText = option.getText().trim();

				logger.info("Available Option: " + actualText);

				if (actualText.equalsIgnoreCase(value.trim())) {

					click(option, actualText);

					valueSelected = true;

					break;
				}
			}

			Assert.assertTrue(valueSelected, "Include option not found: " + value);

			logger.info("Include option selected successfully");

		} catch (Exception e) {

			logger.error("Failed to select Include option: " + e.getMessage());

			Assert.fail("Failed to select Include option: " + e.getMessage());
		}
	}

	public void enterSupervisorName(String name) {

		try {

			logger.info("Step: Enter Supervisor Name - " + name);

			sendKeys(SupervisorName, "Supervisor Name", name);

			Assert.assertFalse(supervisorSuggestions.isEmpty(), "No supervisor suggestions displayed");

			explicitwaitActions.waitForElementToBePresent(supervisorSuggestions.get(0), "First Supervisor Suggestion");

			explicitwaitActions.waitForElementToBeClickable(supervisorSuggestions.get(0),
					"First Supervisor Suggestion");

			supervisorSuggestions.get(0).click();

			logger.info("Supervisor selected successfully");

		} catch (Exception e) {

			logger.error("Failed to enter Supervisor Name: " + e.getMessage());

			Assert.fail("Failed to enter Supervisor Name: " + e.getMessage());
		}
	}

	public void selectPIMJobTitle() {

		try {

			logger.info("Step: Select First Job Title");

			click(jobTitledropdown, "Job Title");

			Assert.assertFalse(jobTitleList.isEmpty(), "No Job Titles found");

			String selectedJobTitle = jobTitleList.get(0).getText().trim();

			click(jobTitleList.get(0), selectedJobTitle);

			logger.info("Job Title selected successfully: " + selectedJobTitle);

		} catch (Exception e) {

			logger.error("Failed to select Job Title: " + e.getMessage());

			Assert.fail("Failed to select Job Title: " + e.getMessage());
		}
	}

	public void selectPIMSubUnit() {

		try {

			logger.info("Step: Select First Sub Unit");

			click(subUnitDropdown, "Sub Unit");

			Assert.assertFalse(subUnitList.isEmpty(), "No Sub Unit options available");

			WebElement firstOption = subUnitList.get(0);

			String selectedSubUnit = firstOption.getText().trim();

			click(firstOption, selectedSubUnit);

			logger.info("Sub Unit selected successfully: " + selectedSubUnit);

		} catch (Exception e) {

			logger.error("Failed to select Sub Unit: " + e.getMessage());

			Assert.fail("Failed to select Sub Unit: " + e.getMessage());
		}
	}

	public void clickOnSearchButton() {

		try {

			logger.info("Step: Click Search Button");

			click(searchButton, "Search Button");

			logger.info("Search button clicked successfully");

		} catch (Exception e) {

			logger.error("Failed to click Search Button: " + e.getMessage());

			Assert.fail("Failed to click Search Button: " + e.getMessage());
		}
	}

	public void verifyNoRecordsFoundMessage() {

		try {

			explicitwaitActions.waitForElementToBePresent(noRecordFoundMessage, "No Records Found Message");

			Assert.assertTrue(noRecordFoundMessage.isDisplayed(), "'No Records Found' message is not displayed");

			logger.info("'No Records Found' message is displayed");

		} catch (Exception e) {

			logger.error("No Records Found message verification failed: " + e.getMessage());

			Assert.fail("No Records Found message verification failed: " + e.getMessage());
		}
	}

//	=========================== Add Employee =================================

	public void addEmployee() {
		try {
			logger.info("Step: Click on Add button");
			click(AddButton, "Add Button");
			logger.info("Add button clicked successfully");
		} catch (Exception e) {
			logger.error("Failed to click on Add button" + e.getMessage());
			Assert.fail("Failed to click on Add button" + e.getMessage());
		}
	}

	public void enterFirstName(String firstName) {
		try {
			logger.info("Step: Enter First Name");
			sendKeys(firstNametextBox, "First Name textbox", firstName);
			logger.info("First name entered in the textbox");
		} catch (Exception e) {
			logger.error("Failed to enter the first name" + e.getMessage());
			Assert.fail("Failed to enter the first name" + e.getMessage());
		}
	}

	public void enterMiddleName(String middleName) {
		try {
			logger.info("Step: Enter Middle Name");
			sendKeys(middleNametextBox, "Middle Name textbox", middleName);
			logger.info("Middle name entered in the textbox");
		} catch (Exception e) {
			logger.error("Failed to enter the middle name" + e.getMessage());
			Assert.fail("Failed to enter the middle name" + e.getMessage());
		}
	}

	public void enterLastName(String lastName) {
		try {
			logger.info("Step: Enter last name");
			sendKeys(lastNametextBox, "Last Name textbox", lastName);
			logger.info("Last name entered in the textbox");
		} catch (Exception e) {
			logger.error("Failed to enter the last name" + e.getMessage());
			Assert.fail("Failed to enter the last name" + e.getMessage());
		}
	}

	public void inputEmployeeID(String empID) {
		try {
			logger.info("Step: Enter employee ID in the inputbox");
			employeeIDtextBox.clear();
			sendKeys(employeeIDtextBox, "Employee ID inputbox", empID);
			logger.info("User has input the employee ID");
		} catch (Exception e) {
			logger.error("Failed to enter the employee ID" + e.getMessage());
			Assert.fail("Failed to enter the employee ID" + e.getMessage());
		}
	}

//	public void uploadprofileImage(String filePath) {
//		try {
//		logger.info("Step: Upload employee profile image");
//		sendKeys(uploadEmployeeImage, "upload profile image", filePath);
//		logger.info("Profile image uploaded successfully");
//		}catch (Exception e) {
//			logger.error("Failed to upload the profile image" + e.getMessage());
//			Assert.fail("Failed to upload the profile image" + e.getMessage());
//		}
//	}

	public void uploadProfileImage(String imagePath) {

		try {

			String absolutePath = System.getProperty("user.dir") + "/" + imagePath;

			logger.info("Uploading image : " + absolutePath);

			uploadFile(uploadEmployeeImage, "Profile Image", absolutePath);

			logger.info("Profile image uploaded successfully");

		} catch (Exception e) {

			logger.error("Failed to upload profile image : " + e.getMessage());

			throw e;
		}
	}

}
