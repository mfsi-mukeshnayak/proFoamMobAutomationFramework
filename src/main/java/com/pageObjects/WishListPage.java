package com.pageObjects;

import org.openqa.selenium.By;

import com.actions.GenericActions;
import com.actions.MouseActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;

public class WishListPage extends BaseClass {
	
	//Locators
	private static final By headerWishList = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Wishlist')]");
	private static final By myWishlistText = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Wishlist')]//following-sibling::android.view.ViewGroup//android.widget.TextView)[1]");
	private static final By sharedWishlistText = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Wishlist')]//following-sibling::android.view.ViewGroup//android.widget.TextView)[2]");
	private static final By myWishlist = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'My Wishlist')]");
	private static final By sharedWishlist = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Shared Wishlist')]");
//MyWishListPage	
	private static final By selectBtnInWishlist = AppiumBy.accessibilityId("Select");
	private static final By SharedBtn = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"Select\"]/preceding-sibling::android.view.ViewGroup)[2]");
	private static final By WishListedItemText(String product) {return AppiumBy.xpath("//android.view.ViewGroup[@content-desc='"+product+"']/android.widget.TextView[1]");}
	private static final By WishListedItemChekedBox(String product) {return AppiumBy.xpath("//android.view.ViewGroup[@content-desc='"+product+"']/android.view.ViewGroup[1]");}
	private static final By AddtoCartBtnInWishlistPage = AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'selected item to cart')]");
	private static final By CancelBtnInWishlist = AppiumBy.accessibilityId("Cancel");
	
//sharedWishListPage
	private static final By sharedWishlistPageHeader = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Shared Wishlist')]");
	private static final By sharedWishListedDetailsText(int index) {return AppiumBy.xpath("((//android.view.ViewGroup[@content-desc='View Items'])["+index+"]//preceding-sibling::android.widget.TextView)[1]");}
	private static final By sharedWishlistedViewItemsBtn(int index) {return AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='View Items'])["+index+"]");}
	private static final By sharedWishlistedDeleteItemsBtn(int index) {return AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Delete'])["+index+"]");}
	private static final By sharedWishlistedSharedAgainItemsBtn(int index) {return AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Share again'])["+index+"]");}
	
	private static final By alertHeader = AppiumBy.id("android:id/alertTitle");
	private static final By alertMessage = AppiumBy.id("android:id/message");
	private static final By YesBtnForalertMessage = AppiumBy.id("android:id/button2");
	private static final By NoBtnForalertMessage = AppiumBy.id("android:id/button1");
	private static final By Ok_BtnForalertMessage = AppiumBy.id("android:id/button1");
	
	//Methods
	
	public  void ValidatingWishListPageHeader() throws InterruptedException {
	Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(headerWishList);
	MobWebAssertion.elementDisplayed(headerWishList, "headerWishList is Displayed");

	}
	
	public void ValidateMyWishlistText() throws InterruptedException {
		Waits.waitForGivenTime(3);
		String actualtext = GenericActions.getElements(myWishlistText, "Getting the text value").get(0).getText();
		String expectedText ="My Wishlist";
		MobWebAssertion.assertEquals(actualtext, expectedText);
	}
	
	public void ValidateSharedWishlistText() throws InterruptedException {
		Waits.waitForGivenTime(3);
		String actualtext = GenericActions.getElements(sharedWishlistText, "Getting the text value").get(0).getText();
		String expectedText ="Shared Wishlist";
		MobWebAssertion.assertEquals(actualtext, expectedText);
	}
	
	
	public void confirmDeletingAddress() throws InterruptedException {
		
		Waits.waitUntilElementIsVisible(YesBtnForalertMessage);
		MouseActions.clickElement(YesBtnForalertMessage, "YesBtnForalertMessage Button is clicked");
		
	} 
	
	public void AddressDeletedConfirmationToastmsg() throws InterruptedException {
		
		Waits.waitUntilElementIsVisible(YesBtnForalertMessage);
		MouseActions.clickElement(Ok_BtnForalertMessage, "Ok_BtnForalertMessage Button is clicked");
	}
	
	public void ValidateDeletedAlertMessage() throws InterruptedException {
		Waits.waitForGivenTime(3);
		String actualtext = GenericActions.getElements(alertMessage, "Getting the text value").get(0).getText();
		String expectedText ="Do you really want to delete shared wishlist? It will remove Wishlist's items for other user as well.";
		MobWebAssertion.assertContains(actualtext, expectedText);
	}
	public void ValidateDeletedAlertHeader() throws InterruptedException {
		Waits.waitForGivenTime(3);
		String actualtext = GenericActions.getElements(alertHeader, "Getting the text value").get(0).getText();
		String expectedText ="Delete Shared Wishlist";
		MobWebAssertion.assertContains(actualtext, expectedText);
	}

}
