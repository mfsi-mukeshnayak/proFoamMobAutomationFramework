package com.assertions;

import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;
import com.waits.Waits;

import io.appium.java_client.android.AndroidDriver;



public class MobWebAssertion extends BaseClass{
	
	/**
	 * method to check element is displayed or not
	 * @param locator
	 * @param message
	 *  */
	public static void elementDisplayed(By locator, String message) {
		Assert.assertTrue(driver.findElement(locator).isDisplayed(), message);
		//LogMsg +" with element :"+ locator
		logger.info(message +" with element :"+ locator);
		ExtentReport.getTest().log(Status.INFO, message +" with element : "+ locator  );
	}
	
	/**
	 * method to check expected and actual value equal or not
	 * @param actual
	 * @param expected
	 *  */
	public static void assertEquals(String actual, String expected) {
		try {
		Assert.assertEquals(actual, expected);
		logger.info(actual +" matched with expected text :"+ expected);
		ExtentReport.getTest().log(Status.INFO, actual +" matched with expected text :"+ expected);
	 } catch (AssertionError e) {
	        // Log actual and expected values if assertion fails
	    	logger.info("Assertion failed. Actual: '" + actual + "', Expected: '" + expected + "'");
	        ExtentReport.getTest().log(Status.INFO, "Assertion failed. Actual: '" + actual + "', Expected: '" + expected + "'");
	        
	        // Rethrow the exception to fail the test
	        throw e;
	    }
	}
	
	/**
	 * method to check expected and actual value contains or not
	 * @param actual
	 * @param expected
	 *  */
	public static void assertContains(String actual, String expected) {
		 try {
		        // Perform the assertion
		        Assert.assertTrue(actual.contains(expected));
		        
		        // Log success if assertion passes
		        logger.info(actual + " contains expected text: " + expected);
		        ExtentReport.getTest().log(Status.INFO, actual + " matched with expected text: " + expected);
		    } catch (AssertionError e) {
		        // Log actual and expected values if assertion fails
		    	logger.info("Assertion failed. Actual: '" + actual + "', Expected: '" + expected + "'");
		        ExtentReport.getTest().log(Status.INFO, "Assertion failed. Actual: '" + actual + "', Expected: '" + expected + "'");
		        
		        // Rethrow the exception to fail the test
		        throw e;
		    }
	}
	
	/**
	 * method to check expected and actual value contains or not From  List<String>
	 * @param actualStrings
	 * @param expectedStrings
	 *  */
	public static boolean validateStrings(List<String> actualStrings, List<String> expectedStrings) {
	      for (String expectedString : expectedStrings) {
	            boolean found = false;
	            

	            for (String actualString : actualStrings) {
	                if (actualString.contains(expectedString)) {
	                	assertContains(actualString, expectedString);
	                    found = true;
	                    break; // Found a match, no need to continue searching
	                }
	            }

	            if (!found) {
	        		logger.info(actualStrings +" not matched with expected text : \n ExpectedListofString is: "+ expectedStrings);
	        		ExtentReport.getTest().log(Status.INFO, actualStrings +" not matched with expected text : \n ExpectedListofString is:   "+ expectedStrings);
	        		assertFalse(found = true);
	                return false; // Expected string not found in actual strings
	            }
	        }

	        return true; // All expected strings found in actual strings
	    }
	
	/**
	 * Method to check if expected and actual value are true
	 * @param value
	 */
	public static void assertTrue(boolean value) {
	    try {
	        Assert.assertTrue(value);
	        logger.info("Value is present: " + value);
	        ExtentReport.getTest().log(Status.INFO, "Value is present: " + value);
	    } catch (AssertionError e) {
	        logger.info("Assertion failed. Expected value to be true but was false: " + value);
	        ExtentReport.getTest().log(Status.FAIL, "Assertion failed. Expected value to be true but was false: " + value);
	        throw e; // Optionally rethrow the assertion error
	    }
	}
		
	/**
	 * Method to check if the fetched element is clickable or not
	 * @param locator
	 * @param timeout
	 */
	public static void IsElementClickable(By locator, int timeout) {
	    try {
	        boolean clickable = Waits.WaitTillElementisClickable(locator, timeout);

	        if (clickable) {
	            // Log success
	            logger.info("Element is clickable: " + locator);
	            ExtentReport.getTest().log(Status.INFO, "Element is clickable: " + locator);
	        } else {
	            // Log failure
	            logger.info("Element is not clickable: " + locator);
	            ExtentReport.getTest().log(Status.WARNING, "Element is not clickable: " + locator);
	        }
	    } catch (Exception e) {
	        // Log error and rethrow exception
	        logger.info("Error occurred while checking element clickability: " + e.getMessage());
	        ExtentReport.getTest().log(Status.FAIL, "Failed to check element clickability for: " + locator + " - " + e.getMessage());
	        throw e; // Optionally rethrow the exception
	    }
	}


	       
	

}
