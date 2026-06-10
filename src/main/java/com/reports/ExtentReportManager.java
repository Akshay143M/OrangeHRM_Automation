package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.constants.Constants;

//Class used to configure and create Extent Report
public class ExtentReportManager {

	// Method used to setup and return ExtentReports object
	public static ExtentReports setupExtentReport() {

		// Create Spark Reporter object with report file path
		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.EXECUTION_REPORT_PATH);

		// Create ExtentReports main object
		ExtentReports extent = new ExtentReports();

		// Attach Spark Reporter to ExtentReports
		extent.attachReporter(reporter);

		// Return configured ExtentReports object
		return extent;
	}
}