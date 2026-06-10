package com.tests;

import org.testng.annotations.Test;

import com.driver.DriverFactory;

//Sample test class
public class SampleTest extends BaseTest {



 // Test method
 @Test
 public void verifyTitle() {

     // Get page title
     String actualTitle = DriverFactory.getInstance().getDriver().getTitle();

     // Print page title in console
     System.out.println("Page Title is : " + actualTitle);

 }
}
