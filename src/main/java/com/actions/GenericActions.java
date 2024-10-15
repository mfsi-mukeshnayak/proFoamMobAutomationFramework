package com.actions;

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
	 * method to fetch the text using element 
	 * @param locator
	 * @param LogMsg
	 	 */
	public static String getText(By locator, String message) {
		String text = driver.findElement(locator).getText();
		logger.info(message +" with element :"+ locator);
		ExtentReport.getTest().log(Status.INFO, message +" with element : "+ locator  );
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
	 * method to get List Of Elements
	 * @param locator
	 * @param msg
	 *  */

	public static List<WebElement> getElements(By locator , String message) {
		List<WebElement> elements = driver.findElements(locator);
		logger.info(message +" with element :"+ locator);
//		ExtentReport.getTest().log(Status.INFO, message +" with element : "+ locator  );
		return elements;
	}
	
	/**
	 * method to get Element
	 * @param locator
	 * @param msg
	 *  */
	public static WebElement getElement(By locator , String message) {
		WebElement element = driver.findElement(locator);
		logger.info(message +" with element :"+ locator);
//		ExtentReport.getTest().log(Status.INFO, message +" with element : "+ locator  );
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
		} catch (Exception e) {
			System.out.println("element not present ->" + elementName);
		}
		return elementPresent;
	}
	
	public static String getpageTitle() {
		String title = driver.getTitle();
		return title;	
	}
	
	
	public String getAttribute(By ele, String attribute) {
		waitForVisibility(ele);
		return driver.findElement(ele).getAttribute(attribute);
	}
	
	public void GetTitleofPage() {
		
		String title = driver.getTitle();
		logger.info(" Page Title name is : "+ title );
		ExtentReport.getTest().log(Status.INFO," Page Title name is : "+ title  );
		
	}
	




	
	
}
