package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	public void hideKeyboard() {
		((AndroidDriver) driver).hideKeyboard();
		logger.info("Keyboard is hidden");
		ExtentReport.getTest().log(Status.INFO, "Keyboard is hidden now" );
	}
	
	/**
	 * method to go back by Android Native back click
	 */
	public void back() {
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}
	
	public void clearText(By ele) {
		waitForVisibility(ele);
		driver.findElement(ele).clear();
	}
	
}
