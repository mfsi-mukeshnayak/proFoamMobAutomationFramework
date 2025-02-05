package com.waits;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;


public class Waits extends BaseClass {
	
	public static final int timeOut = 40;
	//WebDriverWait wait;
	
	/**
	 * method to wait for the element to get visible
	 * @param targetElement
	 * @param elementName
	 * @throws InterruptedException
	 */
	public static void waiForAnElement(By targetElement, String elementName) throws InterruptedException {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
			logger.info(elementName +" for Webelement : " +targetElement );
			ExtentReport.getTest().log(Status.INFO,elementName +" for Webelement : " +targetElement   );
			
		} catch (TimeoutException e) {
			System.out.println("Element is not visible: " + targetElement);
			throw e;

		}

	}
	/**
	 * method to wait for the page to get load
	 * @throws InterruptedException
	 */
	public static void waitForPageLoad() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		try {
			wait.until(webDriver -> new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wdriver) {
					try {
						return ((JavascriptExecutor) driver).executeScript("return document.readyState")
								.equals("complete");

					} catch (Exception e) {

					}
					return null;
				}
			}.apply(driver));

		} catch (Exception e) {

		}
	}
	
	/**
	 * method to wait for the page or element for specific time
	 * @throws InterruptedException
	 */

	public static void waitForSpecificTime() throws InterruptedException {
		Thread.sleep(6000);
	}
	
	/**
	 * method to wait for the page or element for given time
	 * @throws InterruptedException
	 */
	public static void waitForGivenTime(int timeUnitsInSecs) throws InterruptedException {
		long time = timeUnitsInSecs * 1000;
		Thread.sleep(time);
	}
	/**
	 * method to wait for the page or element to get visible
	 * @throws InterruptedException
	 */
	
	public static void waitUntilElementIsVisible(By locator) {
		ExpectedConditions.visibilityOfElementLocated(locator);

	}

//	public static void waitAndClick(WebDriver driver, By locator, int timeUnit) {
//		new Throwable().getStackTrace()[0].getMethodName();
//		int flag = 0;
//		try {
//			do {
//				try {
//
//					Waits.waitUntilElementIsVisible(locator);
//					Waits.waitForGivenTime(timeUnit);
//					JavascriptActions.clickUsingJS(locator , "clicked locator");
//					flag++;
//
//				} catch (Exception e) {
//					System.out.println(e.getLocalizedMessage());
//				}
//			} while (driver.findElement(locator).isDisplayed() && flag < 2);
//		} catch (Exception e) {
//
//		}
//
//	}
	
	public static boolean WaitTillElementisClickable(By elementLocator, int timeoutInSeconds) {
        try {
        	wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            logger.info("Waiting for Element to be Clickable :" +element );
			ExtentReport.getTest().log(Status.INFO, "Waiting for Element to be Clickable :" +element);
            return element != null;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
	}
	
//	public static boolean isElementVisible(By element, String message) {
//	    try {
//	        return driver.findElement(element).isDisplayed();
//	    } catch (NoSuchElementException e) {
//	        System.out.println(message + ": Element not found.");
//	        return false;
//	        }
//	    }
	
	public static boolean isElementVisible(By locator ,String message) {
	    try {
	        // Wait for the element to be present in the DOM and visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Adjust the timeout as needed
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        
	        // If the element is found and visible, return true
	        return driver.findElement(locator).isDisplayed();
	        //logger.info("Waiting for Element to be Clickable :" +locator );
	        
	    } catch (TimeoutException | NoSuchElementException e) {
	        // Log that the element was not found or is not visible and return false
	        logger.info("Element not visible: " + locator + ". Error: " + e.getMessage());
	        return false;
	    }
	}
	
	/**
	 * method to wait for an element to be visible
	 *
	 * @param targetElement element to be visible
	 * @return true if element is visible else throws TimeoutException
	 */
	public static boolean waitForVisibility(By targetElement) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
			logger.info("Webelement : " +targetElement + " - is Displayed");
			ExtentReport.getTest().log(Status.INFO,"Webelement : " +targetElement + " - is Displayed" );
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is not visible: " + targetElement);
			throw e;

		}
	}

	/**
	 * method to wait for an element until it is invisible
	 *
	 * @param targetElement element to be invisible
	 * @return true if element gets invisible else throws TimeoutException
	 */
	public boolean waitForInvisibility(By targetElement) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
			logger.info("Webelement : " +targetElement + " - is Displayed");
			ExtentReport.getTest().log(Status.INFO,"Webelement : " +targetElement + " - is Displayed" );
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is still visible: " + targetElement);
			System.out.println(e.getMessage());
			throw e;

		}
	}

	
	
}
