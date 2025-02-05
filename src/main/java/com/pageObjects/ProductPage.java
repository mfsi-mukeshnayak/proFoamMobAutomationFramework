package com.pageObjects;

import org.openqa.selenium.By;

import com.actions.GenericActions;
import com.actions.TouchActions;
import com.assertions.MobWebAssertion;
import com.aventstack.extentreports.Status;
import com.reports.ExtentReport;
import com.utills.BaseClass;
import com.utills.CustomMethods;
import com.utills.GenericMethods;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage extends BaseClass {

	//	public LoginPage(AndroidDriver  driver) {
	//		this.driver=driver;
	//	}
	GenericMethods generic = new GenericMethods();
	CustomMethods custom = new CustomMethods();

	private static final By SideMenu = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Search for Products | Events']/preceding-sibling::android.view.ViewGroup)[1]");
	private static final By cartBtn = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Search for Products | Events']/preceding-sibling::android.view.ViewGroup)[2]");
	private static final By ProductTabTextGrab = AppiumBy.xpath("//android.view.View[@content-desc='Products']/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
	private static final By EventsTabTextGrab = AppiumBy.xpath("//android.view.View[@content-desc='Events']/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
	private static final By ProductsTab = AppiumBy.accessibilityId("Products");
	private static final By Eventstab = AppiumBy.accessibilityId("Events");
	private static final By SelectProduct(String productName) { return AppiumBy.accessibilityId(productName);}
	private static By ProductTextGrab(String productName) {
	    return AppiumBy.xpath("//android.view.ViewGroup[@content-desc='" + productName + "']/android.widget.TextView");
	}
	private static final By SearchTab = AppiumBy.accessibilityId("Search for Products | Events");
	
	public void LandedOnProductPageAndAbleToSeeSideMenu() throws InterruptedException {
		Waits.waitForGivenTime(4);
		Waits.waitUntilElementIsVisible(SideMenu);
		MobWebAssertion.elementDisplayed(SideMenu, "SideMenu is Displayed");
		
	}
	
	public void SideMenubarIsDisplayed() throws InterruptedException {
		Waits.waitForGivenTime(4);
		Waits.waitUntilElementIsVisible(SideMenu);
		MobWebAssertion.elementDisplayed(SideMenu, "SideMenu is Displayed");
		
	}
	public void cartMenuIsDisplayed() throws InterruptedException {
		Waits.waitUntilElementIsVisible(cartBtn);
		MobWebAssertion.elementDisplayed(cartBtn, "cartBtn is Displayed");
		
	}
	public void ProdctTabTextdisplayed() {
		String actualfootertext = GenericActions.getElements(ProductTabTextGrab, "Getting the text value of Products Tab").get(0).getText();
		String expectedText ="Products";
		MobWebAssertion.assertEquals(actualfootertext, expectedText);
		
	}
	
	public void productsTabIsDisplayed() throws InterruptedException {
		Waits.waitUntilElementIsVisible(ProductsTab);
		MobWebAssertion.elementDisplayed(ProductsTab, "ProductsTab is Displayed");

	}
	
	public void EventsTabTextdisplayed() {
		String actualfootertext = GenericActions.getElements(EventsTabTextGrab, "Getting the text value of Events Tab").get(0).getText();
		String expectedText ="Events";
		MobWebAssertion.assertEquals(actualfootertext, expectedText);
		
	}
	
	public void eventsTabIsDisplayed() throws InterruptedException {
		Waits.waitUntilElementIsVisible(Eventstab);
		MobWebAssertion.elementDisplayed(Eventstab, "Eventstab is Displayed");
		
	}
	public void SearchBoxIsDisplayed() throws InterruptedException {
		Waits.waitUntilElementIsVisible(SearchTab);
		MobWebAssertion.elementDisplayed(SearchTab, "SearchTab is Displayed");
		
	}
	
	public void ClickOnSideMenubar() throws InterruptedException {
		Waits.waitForGivenTime(4);
		Waits.waitUntilElementIsVisible(SideMenu);
		TouchActions.clickElement(SideMenu, "SideMenu Button is clicked");
		
	}
	
	
//	public void AddressTest() throws InterruptedException {
//		String ZipCode = generic.generateRandomAlaskaZipCode(); 
//		String Address = generic.generateRandomAddress();
//		String Number = generic.generateRandomMobileNumber();
//		
//	}
}
