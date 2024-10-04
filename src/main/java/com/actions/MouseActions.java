package com.actions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;
import com.reports.ExtentReport;
import com.utills.BaseClass;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class MouseActions extends BaseClass{
	
	
	/**
	 * method to Click an Element
	 * @param locator
	 * @param LogMsg
	 */
	public static void clickElement(By locator , String LogMsg) throws InterruptedException {
		Waits.waiForAnElement(locator, "Wait for the Element to be displayed");
		driver.findElement(locator).click();
		logger.info(LogMsg +" with element : "+ locator);
		ExtentReport.getTest().log(Status.INFO, LogMsg +" with element : "+ locator);
	}
	/**
	 * method to Select a value from dropDown using visbleText for Webversion
	 * @param locator
	 * @param visibleText
	 * @param LogMsg
	 */
	public static void selectDropdownByText(By locator, String text , String LogMsg) throws InterruptedException {
		Waits.waiForAnElement(locator, "Wait for the Element to be displayed");
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);	
		logger.info(LogMsg +" with element : "+ locator);
		ExtentReport.getTest().log(Status.INFO, LogMsg +" with element : "+ locator);
	}
	
	/**
	 * method to ScrollAndMoveToElemet for WebVersion
	 * @param locator
	 * @param LogMsg
	 */
	
	public static void ScrollAndMoveDown(By locator , String LogMsg) {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(locator);
		action.moveToElement(ele).perform();
		logger.info(LogMsg +" with element : "+ locator);
		ExtentReport.getTest().log(Status.INFO, LogMsg +" with element : "+ locator);
	}
	
	public static void scrollDown(String scroll) throws InterruptedException {
		
		int height = scroll.isEmpty() ? 100 : Integer.parseInt(scroll);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		;
		jse.executeScript("window.scrollBy(0," + height + ")", "");
	
	}
	
	/**
	 * 
	 * @param element:
	 *            check box is ticked
	 * @throws TwfException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void checkBoxEnabled(By params) throws InterruptedException {
	//	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		WebElement e = driver.findElement(params);

		boolean isSelected = e.isSelected();

		if (isSelected == false) {
//			Waits.waitForGivenTime(2);
			e.click();
		}
	}
	
	/**
	 * method to tap on the screen on provided coordinates
	 *
	 * @param xPosition x coordinate to be tapped
	 * @param yPosition y coordinate to be tapped
	 */
	public void tap(double xPosition, double yPosition) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> tapObject = new HashMap<String, Double>();
		tapObject.put("startX", xPosition);
		tapObject.put("startY", yPosition);
		js.executeScript("mobile: tap", tapObject);
	}
	
	/**
	 * method to long press on specific element by passing locator
	 *
	 * @param locator element to be long pressed
	 */
//	public void longPress(By locator) {
//		try {
//			WebElement element = driver.findElement(locator);
//
//			TouchAction touch = new TouchAction((AndroidDriver) driver);
//			LongPressOptions longPressOptions = new LongPressOptions();
//			longPressOptions.withElement(ElementOption.element(element));
//			touch.longPress(longPressOptions).release().perform();
//			//            Log.info("Long press successful on element: " + element);
//			
//
//		} catch (NoSuchElementException e) {
//			//            Log.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
//			throw e;
//		}

	
	/**
	 * method to Scroll to n element using Text in Android Mobile
	 * @param text
	 	 */
	public static void ScrollUsingUiAutomator(String text) {
	 
		
		 // Create a UiScrollable object for scrolling
        WebElement parentElement = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"));

        // Specify the element to scroll to based on its text content
        WebElement targetElement = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

        // Scroll to the target element
        if (targetElement != null) {
        	logger.info("Element found: " + text);
        	
        } else {
            
        	logger.info("Element not found: " + text); 
        }
	}
	
//	public static void ScrollUsingUiAutomatorTwo(String text) {
//		 
//		
//		 // Create a UiScrollable object for scrolling
//       WebElement parentElement = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"));
//
//       // Specify the element to scroll to based on its text content
//       WebElement targetElement = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+text+"\"));"));
//
//       // Scroll to the target element
//       if (targetElement != null) {
//         //  targetElement.click();
//       } else {
//           
//       	logger.info("Element not found: " + text); 
//       }
//	}
//	
	/**
	 * method to Scroll to the botoom in Android Mobile
	 * @param text
	 	 */
	public static void ScrollToBottom() {
		boolean canScrollMore;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
		}
		while(canScrollMore); 
	//	logger.info("Page Scrolled to the bottom"); 
		

	}
	



}
