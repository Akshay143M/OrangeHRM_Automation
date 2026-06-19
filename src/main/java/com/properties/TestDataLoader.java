package com.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Constants;
import com.reports.ExtentFactory;

public class TestDataLoader {

	private TestDataLoader() {
		String env = Constants.EXECUTION_ENV;

		switch (env) {
		case "test":
			loadFile(Constants.TEST_ENV_DATA_FILE);
			break;

		case "prod":
			loadFile(Constants.PROD_ENV_DATA_FILE);
			break;

		default:
			break;
		}

	}

	private static TestDataLoader instance = new TestDataLoader();

	public static TestDataLoader getInstance() {
		return instance;
	}

	private static Properties prop;

	private static void loadFile(String filepath) {
		FileReader reader = null;
		try {
			reader = new FileReader(filepath);
		} catch (FileNotFoundException e) {
			ExtentFactory.getInstance();
			ExtentFactory.failTest("Exception occured while reading test data file");
		}

		prop = new Properties();

		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

//	LOGIN data


	public String getAppUrl() {
		return this.getPropertyValue("app_url");
	}

	public String getUsername() {
		return this.getPropertyValue("username");
	}

	public String getPassword() {
		return this.getPropertyValue("password");
	}

//	ADMIN data

	public String setUserRole() {
		return this.getPropertyValue("user_role");

	}
	public String getEmpName() {
		return this.getPropertyValue("employee_name");
	}

	public String setStatus() {
		return this.getPropertyValue("status");
	}
	public String getNewUsername() {
		return this.getPropertyValue("new_username");
	}

	public String getNewPassword() {
		return this.getPropertyValue("new_password");
	}

	public String getConfirmPassword() {
		return this.getPropertyValue("confirm_password");
	}

//	PIM data (Search Employee)

	public String setPIMEmpName() {
		return this.getPropertyValue("PIM_empName");
	}

	public String setPIMEmpID() {
		return this.getPropertyValue("PIM_empID");
	}

	public String setPIMEmpStatus() {
		return this.getPropertyValue("PIM_empStatus");
	}

	public String setPIMinclude() {
		return this.getPropertyValue("PIM_include");
	}

	public String setPIMSupervisorName() {
		return this.getPropertyValue("PIM_SupervisorName");
	}

	public String setPIMJobTitle() {
		return this.getPropertyValue("PIM_JobTitle");
	}

	public String setPIMSubUnit() {
		return this.getPropertyValue("PIM_SubUnit");
	}
	
	
//	PIM data (Add employee)
	
	public String setPIMfirstName() {
		return this.getPropertyValue("PIM_firstName");
	}
	
	public String setPIMmiddleName() {
		return this.getPropertyValue("PIM_middleName");
	}
	
	public String setPIMlastName() {
		return this.getPropertyValue("PIM_lastName");
	}
	
	public String setPIMempID() {
		return this.getPropertyValue("PIM_empID");
	}
	
	public String setPIMfilepath() {
		return this.getPropertyValue("PIM_filePath");
	}










}
