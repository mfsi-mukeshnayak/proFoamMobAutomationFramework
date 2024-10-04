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
		Assert.assertEquals(actual, expected);
		logger.info(actual +" matched with expected text :"+ expected);
		ExtentReport.getTest().log(Status.INFO, actual +" matched with expected text :"+ expected);
	}
	
	/**
	 * method to check expected and actual value contains or not
	 * @param actual
	 * @param expected
	 *  */
	public static void assertContains(String actual, String expected) {
		Assert.assertTrue(actual.contains(expected));
		logger.info(actual +" contains expected text :"+ expected);
		ExtentReport.getTest().log(Status.INFO, actual +" matched with expected text :"+ expected);
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
	 * method to check expected and actual value true or not
	 * @param value
	 
	 */
	public static void assertTrue(boolean value) {
		Assert.assertTrue(value);
		logger.info("Value is present :" +value );
		ExtentReport.getTest().log(Status.INFO, "Value is present :" +value);
	}
		
	/**
	 * method to check fetched element clickale or not
	 * @param locator
	 * @param timout
	 *  */
	public static void IsElementClickable(By locator , int timout) {
		boolean clickable = Waits.WaitTillElementisClickable(locator, timout);
		
		if (clickable) {
			logger.info("Element is clickable :" +locator );
			ExtentReport.getTest().log(Status.INFO, "Element is clickable :" +locator);
        } else {
			logger.info("Element is not clickable :" +locator );
			ExtentReport.getTest().log(Status.INFO, "Element is not clickable :" +locator);
        }
	}
	

	       
	

}
