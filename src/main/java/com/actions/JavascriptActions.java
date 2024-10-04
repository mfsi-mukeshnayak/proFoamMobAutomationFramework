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
	public static void clickUsingJS(By locator , String LogMsg ) throws InterruptedException {	
		WebElement element = driver.findElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;		
		jse.executeScript("arguments[0].click();", element);
		
		logger.info(LogMsg +" with element : "+ locator);
		ExtentReport.getTest().log(Status.INFO, LogMsg +" with element : "+ locator );
	}

}
