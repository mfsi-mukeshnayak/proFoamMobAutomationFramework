package com.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;



public class GenericActions extends BaseClass{
	
	/**
	 * Method to fetch the text using element
	 * @param locator Locator for the element
	 * @param message Log message
	 * @return The text of the element, or null if an exception occurs
	 */
	public static String getText(By locator, String message) {
	    String text = null;
	    try {
	        // Attempt to find the element and fetch its text
	        text = driver.findElement(locator).getText();
	        logger.info(message + " with element: " + locator);
	       
	        ExtentReport.getTest().log(Status.INFO, message + " with element: " + locator);
	    } catch (Exception e) {
	       
	        logger.info("Failed to fetch text for element: " + locator);
	        ExtentReport.getTest().log(Status.FAIL, 
	            "Failed to fetch text for element: " + locator + ". Exception: " + e.getMessage());
	    }
	    return text;
	}

	
	/**
	 * method to fetch the text using element in different OS
	 * @param locator
	 * @param paltformName
	 * @param msg
	 	 */
	public String getTextByOS(By ele,String paltformName , String msg) {
		String txt = null;
		switch(paltformName) {
		case "Android":
			txt = getAttribute(ele, "text");
			break;
		case "iOS":
			txt = getAttribute(ele, "label");
			break;
		}
		logger.info(msg +" with element :"+ ele);
		ExtentReport.getTest().log(Status.INFO, msg +" with element : "+ ele  );
		return txt;
	}
	
	/**
	 * Method to get a list of elements
	 * @param locator Locator for the elements
	 * @param message Log message
	 * @return A list of WebElements, or an empty list if an exception occurs
	 */
	public static List<WebElement> getElements(By locator, String message) {
	    List<WebElement> elements = new ArrayList<>(); // Initialize with an empty list
	    try {
	        // Attempt to find the elements
	        elements = driver.findElements(locator);
	        logger.info(message + " with element: " + locator);
	       // ExtentReport.getTest().log(Status.INFO, message + " with element: " + locator);
	    } catch (Exception e) {
	        // Log the exception details to the logger and ExtentReports
	        logger.info("Failed to fetch elements for locator: " + locator);
	     //   ExtentReport.getTest().log(Status.FAIL,
	     //       "Failed to fetch elements for locator: " + locator + ". Exception: " + e.getMessage());
	    }
	    return elements;
	}

	
	/**
	 * Method to get a single WebElement
	 * @param locator Locator for the element
	 * @param message Log message
	 * @return The WebElement if found, or null if an exception occurs
	 */
	public static WebElement getElement(By locator, String message) {
	    WebElement element = null; // Initialize element as null
	    try {
	        // Attempt to find the element
	        element = driver.findElement(locator);
	        logger.info(message + " with element: " + locator);
	        ExtentReport.getTest().log(Status.INFO, message + " with element: " + locator);
	    } catch (Exception e) {
	        // Log the exception details to the logger and ExtentReports
	        logger.info("Failed to fetch element for locator: " + locator);
	        ExtentReport.getTest().log(Status.FAIL, 
	            "Failed to fetch element for locator: " + locator + ". Exception: " + e.getMessage());
	    }
	    return element;
	}

	
	/**
	 * method to check elememt present or not
	 * @param driver
	 * @param locator
	 * @param elementName
	 *  */
	public static boolean checkElementPresent(WebDriver driver, By locator, String elementName) {
		boolean elementPresent = false;
		try {
			driver.findElement(locator).isDisplayed();
			elementPresent = true;
			logger.info("element present ->" + elementName);
		} catch (Exception e) {
			logger.info("element not present ->" + elementName);
		}
		return elementPresent;
	}
	
	/**
	 * Method to get the page title
	 * @return The page title as a String, or null if an exception occurs
	 */
	public static String getPageTitle() {
	    String title = null; // Initialize title as null
	    try {
	        // Attempt to get the page title
	        title = driver.getTitle();
	        logger.info("Successfully fetched the page title: " + title);
	        ExtentReport.getTest().log(Status.INFO, "Page title fetched: " + title);
	    } catch (Exception e) {
	        // Log the exception details to the logger and ExtentReports
	        logger.info("Failed to fetch the page title.");
	        ExtentReport.getTest().log(Status.FAIL, "Failed to fetch the page title. Exception: " + e.getMessage());
	    }
	    return title;
	}

	/**
	 * Method to get the attribute value of an element
	 * @param ele Locator for the element
	 * @param attribute Attribute name to fetch
	 * @return The attribute value as a String, or null if an exception occurs
	 */
	public String getAttribute(By ele, String attribute) {
	    String attributeValue = null; // Initialize as null
	    try {
	        // Wait for the element to be visible
	        waitForVisibility(ele);
	        
	        // Fetch the attribute value
	        attributeValue = driver.findElement(ele).getAttribute(attribute);
	        logger.info("Successfully fetched attribute '" + attribute + "' with value: " + attributeValue 
	                    + " for element: " + ele);
	        ExtentReport.getTest().log(Status.INFO, "Attribute '" + attribute + "' fetched with value: " 
	                    + attributeValue + " for element: " + ele);
	    } catch (Exception e) {
	        // Log the exception details to the logger and ExtentReports
	        logger.error("Failed to fetch attribute '" + attribute + "' for element: " + ele, e);
	        ExtentReport.getTest().log(Status.FAIL, 
	            "Failed to fetch attribute '" + attribute + "' for element: " + ele + ". Exception: " + e.getMessage());
	    }
	    return attributeValue;
	}

	
	/**
	 * Method to get and log the title of the current page
	 */
	public void GetTitleofPage() {
	    try {
	        // Attempt to get the page title
	        String title = driver.getTitle();
	        logger.info("Page Title name is: " + title);
	        ExtentReport.getTest().log(Status.INFO, "Page Title name is: " + title);
	    } catch (Exception e) {
	        // Log the exception details to the logger and ExtentReports
	        logger.info("Failed to fetch the page title.");
	        ExtentReport.getTest().log(Status.FAIL, 
	            "Failed to fetch the page title. Exception: " + e.getMessage());
	    }
	}





	
	
}
