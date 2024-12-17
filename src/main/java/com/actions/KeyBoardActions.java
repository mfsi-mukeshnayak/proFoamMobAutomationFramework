package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;
import com.waits.Waits;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class KeyBoardActions extends BaseClass{

	/**
	 * Method to enter text in a Text Box
	 * @param locator
	 * @param text
	 * @param LogMsg
	 */
	public static void enterText(By locator, String text, String LogMsg) throws InterruptedException {
	    try {
	        // Wait for the element to be displayed
	        Waits.waiForAnElement(locator, "Wait for the Element to be displayed");

	        // Find the element and perform actions
	        WebElement element = driver.findElement(locator);
	        element.clear();
	        element.sendKeys(text);

	        // Log success messages
	        logger.info(LogMsg + " with element: " + locator);
	        ExtentReport.getTest().log(Status.INFO, LogMsg + " with element: " + locator);
	    } catch (Exception e) {
	        // Log the error and rethrow if necessary
	        logger.info("Error occurred while entering text: " + e.getMessage());
	        ExtentReport.getTest().log(Status.FAIL, "Failed to enter text in element: " + locator + " - " + e.getMessage());
	        throw e; // Optionally rethrow the exception to handle it further up the call stack
	    }
	}

	

	/**
	 * Method to press enter in a Text Box
	 * @param locator
	 */
	public static void enterUsingKeyboard(By ele) {
	    try {
	        // Find the element and send the ENTER key
	        WebElement textbox = driver.findElement(ele);
	        textbox.sendKeys(Keys.ENTER);

	        // Log success messages
	        logger.info("Pressed ENTER on element: " + ele);
	        ExtentReport.getTest().log(Status.INFO, "Pressed ENTER on element: " + ele);
	    } catch (Exception e) {
	        // Log the error
	        logger.info("Error occurred while pressing ENTER: " + e.getMessage());
	        ExtentReport.getTest().log(Status.FAIL, "Failed to press ENTER on element: " + ele + " - " + e.getMessage());
	        throw e; // Optionally rethrow the exception
	    }
	}
	
	/**
	 * method to hide keyboard
	 */
	// Method to hide the keyboard if it's visible
    public static void hideKeyboardIfVisible() {
        try {
            // Check if the keyboard is displayed, and then hide it
            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
                logger.info("Keyboard hidden successfully.");
            } else {
            	logger.info("Keyboard is not visible.");
            }
        } catch (NoSuchElementException e) {
        	logger.info("No keyboard present to hide.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error occurred while trying to hide the keyboard.");
        }
    }
	
	
	/**
	 * method to go back by Android Native back click
	 */
	public void back() {
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}
	
	public static void clearText(By ele, String LogMsg) {
	    try {
	    	Waits.waiForAnElement(ele, "Wait for the Element to be displayed");
	        WebElement webElement = driver.findElement(ele);
	        webElement.clear();
//	        while (!webElement.getText().isEmpty()) {
//	            webElement.clear();  // Retry clearing if not fully cleared
//	        }
	        logger.info("Cleared text in element: " + ele);
	        ExtentReport.getTest().log(Status.INFO, "Cleared text in element: " + ele);

	    } catch (Exception e) {
	        logger.info("Failed to clear text in element: " + ele + ". Reason: " + e.getMessage());
	        ExtentReport.getTest().log(Status.FAIL, "Failed to clear text in element: " + ele + ". Reason: " + e.getMessage());
	    }	
	      
	    
	}
}
