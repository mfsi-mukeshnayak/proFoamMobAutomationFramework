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
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;

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
	
//	public void scrollSideMenuToElement( String elementText) {
//	    Dimension size = driver.manage().window().getSize();
//	    
//	    int startX = (int) (size.width * 0.9); // Start swipe near the right edge
//	    int endX = (int) (size.width * 0.1);   // End swipe near the left edge
//	    int y = size.height / 2;               // Swipe at mid-height of the screen
//	    
//	    // Number of swipe attempts
//	    int maxSwipes = 5;
//
//	    for (int i = 0; i < maxSwipes; i++) {
//	        try {
//	            // Try to find the element in the currently visible side menu
//	            WebElement element = driver.findElement(By.xpath("//*[contains(@text, '" + elementText + "')]"));
//	            if (element.isDisplayed()) {
//	                System.out.println("Element found: " + elementText);
//	                return;
//	            }
//	        } catch (Exception e) {
//	            System.out.println("Element not found. Performing swipe: " + (i + 1));
//	        }
//	        
//	        // Perform horizontal swipe (right to left)
//	        new TouchAction<>(driver)
//	            .press(PointOption.point(startX, y))
//	            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//	            .moveTo(PointOption.point(endX, y))
//	            .release()
//	            .perform();
//	    }
//	    
//	    System.out.println("Element not found after " + maxSwipes + " swipes.");
//	}
	
	public static void scrollSideMenuToElement(String elementText) {
	    Dimension size = driver.manage().window().getSize();
	    
	    int x = size.width / 2;               // Swipe at the mid-width of the screen (center horizontally)
	    int startY = (int) (size.height * 0.8); // Start swipe near the bottom edge (80% of screen height)
	    int endY = (int) (size.height * 0.2);   // End swipe near the top edge (20% of screen height)
	    
	    // Number of swipe attempts
	    int maxSwipes = 5;

	    for (int i = 0; i < maxSwipes; i++) {
	        try {
	            // Try to find the element in the currently visible side menu
	            WebElement element = driver.findElement(By.xpath("//*[contains(@text, '" + elementText + "')]"));
	            if (element.isDisplayed()) {
	            	logger.info("Element found: " + elementText);
	                return;
	            }
	        } catch (Exception e) {
	        	logger.info("Element not found. Performing swipe: " + (i + 1));
	        }

	        // Use the W3C Actions to perform vertical swipe action
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 1);
	        
	        // Start swipe at the bottom (startY) and move towards the top (endY)
	        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, endY));
	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        driver.perform(Arrays.asList(swipe));
	    }

	    logger.info("Element not found after " + maxSwipes + " swipes.");
	    
	}




}
