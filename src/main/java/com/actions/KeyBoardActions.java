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
	 * method to enterText in a Text Box
	 * @param locator
	 * @param text
	 * @param LogMsg
	 	 */
	public static void enterText(By locator, String text , String LogMsg) throws InterruptedException {
		Waits.waiForAnElement(locator, "Wait for the Element to be displayed");
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
		logger.info(LogMsg +" with element : "+ locator);
		ExtentReport.getTest().log(Status.INFO, LogMsg +" with element : "+ locator );
	}
	

	/**
	 * method to press enter in a Text Box
	 * @param locator
	
	 	 */
	public static void enterUsingKeyboard(By args) {
		WebElement textbox = driver.findElement(args);
		textbox.sendKeys(Keys.ENTER);
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
	
	public void clearText(By ele, String LogMsg) {
	    try {
	        waitForVisibility(ele);
	        WebElement webElement = driver.findElement(ele);
	        webElement.clear();
	        while (!webElement.getText().isEmpty()) {
	            webElement.clear();  // Retry clearing if not fully cleared
	        }
	        logger.info("Cleared text in element: " + ele);
	        ExtentReport.getTest().log(Status.INFO, "Cleared text in element: " + ele);

	    } catch (Exception e) {
	        logger.info("Failed to clear text in element: " + ele + ". Reason: " + e.getMessage());
	        ExtentReport.getTest().log(Status.FAIL, "Failed to clear text in element: " + ele + ". Reason: " + e.getMessage());
	    }	
	      
	    
	}
}
