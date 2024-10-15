package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;



public class JavascriptActions extends BaseClass {
	
	
	/**
	 * method to click an element using JavaScript
	 * @param locator
	 * @param LogMsg
	 	 */
	public static void clickUsingJS(By locator, String logMsg) throws InterruptedException {
	    try {
	        WebElement element = driver.findElement(locator);
	        
	        JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("arguments[0].click();", element);
	        logger.info(logMsg + " - Clicked on element: " + locator);
	        ExtentReport.getTest().log(Status.INFO, logMsg + " - Clicked on element: " + locator);

	    } catch (Exception e) {
	        // Log error message if click fails
	        logger.info("Failed to click using JS on element: " + locator + " - Error: " + e.getMessage());
	        ExtentReport.getTest().log(Status.FAIL, "Failed to click using JS on element: " + locator + " - Error: " + e.getMessage());
	        throw e;
	    }
	}


}
