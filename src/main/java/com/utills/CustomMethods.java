package com.utills;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.actions.KeyBoardActions;
import com.actions.TouchActions;
import com.aventstack.extentreports.Status;
import com.pageObjects.ProductPage;
import com.reports.ExtentReport;
import com.waits.Waits;

public class CustomMethods extends BaseClass {
	Properties props = new Properties();
	
	
	
	/**
	 * method to login to the ProFoam application .
	 * @author mukeshnayak 
	 */
	public void LoginToProFoamApplication(By emailIdElement , By passwordElement) throws InterruptedException {
		
		//KeyBoardActions.enterText(emailIdElement, getPropertyValue("emailId") , "EmailId is entered");
		//KeyBoardActions.enterText(passwordElement, getPropertyValue("password"), "Password is entered");
		driver.findElement(emailIdElement).sendKeys(getPropertyValue("emailId"));
		driver.findElement(passwordElement).sendKeys(getPropertyValue("password"));
		
		
	}
	
//	/**
//	 * method to wait for the Upgrade Pop Up to be displayed and click on later/decline
//	 * @author mukeshnayak 
//	 */
//	
//	public static void AcceptDisplayedAppUpgradeMsg() {
//		
//		try {
//			Waits.waitForGivenTime(2);
//			if (driver.findElement(ProductPage.UpgradePopUpHeader).isDisplayed());
//			MouseActions.clickElement(ProductPage.UpgradePopUpDecline, "UpgradePopUpDecline Button is Clicked");
//			
//		} catch (TimeoutException | InterruptedException | NoSuchElementException  e) {
//			logger.info("TimeoutException occurred: The AppUpgrade Icon and element was not found within the specified timeout.");
//		}
//		
//	}
	
	/**
	 * method to wait for the Ad Pop Up T be Dispalyed and to close it
	 * @author mukeshnayak 
	 */
	
//	public static void CloseDisplayedAdPopUp()  {
//		
//		try {
//			Waits.waitForGivenTime(2);
//			Waits.waiForAnElement(ProductPage.closeIcon, "Waiting for Close Icon to be Displayed");
//			if (driver.findElement(ProductPage.closeIcon).isDisplayed());
//			MouseActions.clickElement(ProductPage.closeIcon, "closeIcon Button is Clicked");
//			
//	     	
//	     	
//		} catch (TimeoutException | InterruptedException | NoSuchElementException e) {
//			logger.info("TimeoutException occurred: The Ad Icon and element was not found within the specified timeout.");
//		}
//		
//	}

}
