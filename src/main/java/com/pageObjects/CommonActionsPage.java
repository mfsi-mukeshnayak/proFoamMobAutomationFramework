package com.pageObjects;

import org.openqa.selenium.By;

import com.actions.TouchActions;
import com.utills.BaseClass;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;

public class CommonActionsPage extends BaseClass {
	
	
	private static final By BackBtn = AppiumBy.xpath("//com.horcrux.svg.d0");
	private static final By SelectCategoryInSidemenu(String productName) { return AppiumBy.accessibilityId(productName);}
	
	
	public  void navigatetoBackPage() throws InterruptedException {
		Waits.waitForGivenTime(3);
		Waits.waitUntilElementIsVisible(BackBtn);
		TouchActions.clickElement(BackBtn, "Back Button is clicked");
	}
	
	public static void selectCategoryInSideMenu(String productName) throws InterruptedException {
		Waits.waitForGivenTime(3);
		Waits.waitUntilElementIsVisible(SelectCategoryInSidemenu(productName));
		TouchActions.clickElement(SelectCategoryInSidemenu(productName), ""+productName+" Button is clicked");
	}

}
