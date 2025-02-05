package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.actions.GenericActions;
import com.actions.TouchActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;

public class WishListPage extends BaseClass {
	
	CommonActionsPage commonAct = new CommonActionsPage();
	SearchPage searchPage = new SearchPage();
	
	
	//Locators
	private static final By headerWishList = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Wishlist')]");
	private static final By myWishlistText = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Wishlist')]//following-sibling::android.view.ViewGroup//android.widget.TextView)[1]");
	private static final By sharedWishlistText = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Wishlist')]//following-sibling::android.view.ViewGroup//android.widget.TextView)[2]");
	private static final By myWishlist = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'My Wishlist')]");
	private static final By sharedWishlist = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Shared Wishlist')]");
//MyWishListPage	
	private static final By selectBtnInWishlist = AppiumBy.accessibilityId("Select");
	private static final By SharedBtn = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"Select\"]/preceding-sibling::android.view.ViewGroup)[2]");
	private static final By WishListedItemText(String product) {return AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'"+product+"')]/android.widget.TextView[1]");}
	private static final By WishListedItemWishListBtnChekedBox(String product) {return AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'"+product+"')]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.v/com.horcrux.svg.d0");}
	private static final By WishListedItemChekedBox(String product) {return AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'"+product+"')]/android.view.ViewGroup[1]");}
	private static final By AddtoCartBtnInWishlistPage = AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'selected item to cart')]");
	private static final By ListsOfWishListedBoxInWishListPage = AppiumBy.xpath("//android.widget.TextView[@text='My Wishlist']//following-sibling::android.widget.ScrollView//android.view.ViewGroup[contains(@content-desc,'')]//com.horcrux.svg.SvgView");
	private static final By CancelBtnInWishlist = AppiumBy.accessibilityId("Cancel");
	
//sharedWishListPage
	private static final By sharedWishlistPageHeader = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Shared Wishlist')]");
	private static final By sharedWishListedDetailsText(int index) {return AppiumBy.xpath("((//android.view.ViewGroup[@content-desc='View Items'])["+index+"]//preceding-sibling::android.widget.TextView)[1]");}
	private static final By sharedWishlistedViewItemsBtn(int index) {return AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='View Items'])["+index+"]");}
	private static final By sharedWishlistedDeleteItemsBtn(int index) {return AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Delete'])["+index+"]");}
	private static final By sharedWishlistedSharedAgainItemsBtn(int index) {return AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Share again'])["+index+"]");}
	private static final By ListsDeleteItemsBtnInsharedWishlist =AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Delete'])");
	private static final By alertHeader = AppiumBy.id("android:id/alertTitle");
	private static final By alertMessage = AppiumBy.id("android:id/message");
	private static final By YesBtnForalertMessage = AppiumBy.id("android:id/button2");
	private static final By NoBtnForalertMessage = AppiumBy.id("android:id/button1");
	private static final By Ok_BtnForalertMessage = AppiumBy.id("android:id/button1");
	
	//Methods
	
	public void ClickOnWishlistCategoryInSidemenu() throws InterruptedException {
		TouchActions.scrollSideMenuToElement("Wishlist");
		commonAct.selectCategoryInSideMenu("Wishlist");
	}
	
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
		TouchActions.clickElement(YesBtnForalertMessage, "YesBtnForalertMessage Button is clicked");
		
	} 
	
	public void AddressDeletedConfirmationToastmsg() throws InterruptedException {
		
		Waits.waitUntilElementIsVisible(Ok_BtnForalertMessage);
		TouchActions.clickElement(Ok_BtnForalertMessage, "Ok_BtnForalertMessage Button is clicked");
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
	
	public void NavigatingMyWishList() throws InterruptedException {
		
		Waits.waitUntilElementIsVisible(myWishlist);
		TouchActions.clickElement(myWishlist, "myWishlist Button is clicked");
		
	} 
	public void NavigatingSharedWishList() throws InterruptedException {
		
		Waits.waitUntilElementIsVisible(sharedWishlist);
		TouchActions.clickElement(sharedWishlist, "sharedWishlist Button is clicked");
		
	} 
	
	public void ValidatingMyWishListPageButtonsAndLinks() throws InterruptedException {
	Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(selectBtnInWishlist);
	MobWebAssertion.elementDisplayed(selectBtnInWishlist, "selectBtnInWishlist is Displayed");
	MobWebAssertion.elementDisplayed(SharedBtn, "SharedBtn is Displayed");

	}
	
	public void ValidatingSharedWishListPage() throws InterruptedException {
	Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(sharedWishlistPageHeader);
	MobWebAssertion.elementDisplayed(sharedWishlistPageHeader, "sharedWishlistPageHeader is Displayed");

	}
	
	public void ValidateItemDisplayedinWishListPage() throws InterruptedException {
		Waits.waitForGivenTime(3);
		String prod = searchPage.getItemName();
		String actualtext = GenericActions.getElements(WishListedItemText(prod), "Getting the text value").get(0).getText();
		MobWebAssertion.assertContains(actualtext, prod);
	}
	
	public void ClickedOnSelectButtonAndCheckedTheTextBoxofItem() throws InterruptedException {
		String prod = searchPage.getItemName();
		Waits.waitUntilElementIsVisible(selectBtnInWishlist);
		TouchActions.clickElement(selectBtnInWishlist, "selectBtnInWishlist Button is clicked");
		Waits.waitForGivenTime(3);
		TouchActions.clickElement(WishListedItemWishListBtnChekedBox(prod), "WishListedItemWishListBtnChekedBox(prod) Button is clicked");
	}
	
	public void validatingSelectedIteToCartBtnAndCancelBtnIsDisplayed() throws InterruptedException {
		Waits.waitForGivenTime(3);
		Waits.waitUntilElementIsVisible(AddtoCartBtnInWishlistPage);
		MobWebAssertion.elementDisplayed(AddtoCartBtnInWishlistPage, "AddtoCartBtnInWishlistPage is Displayed");
		MobWebAssertion.elementDisplayed(CancelBtnInWishlist, "CancelBtnInWishlist is Displayed");
	}
	
	public void ClickedOnSharedButtonInMyWishListPage() throws InterruptedException {
		Waits.waitForGivenTime(3);
		Waits.waitUntilElementIsVisible(SharedBtn);
		TouchActions.clickElement(SharedBtn, "SharedBtn Button is clicked");
	}
	
	public void ClearAllWishlistedItemIfItExistsInMyWishListPage() {
	    try {
	        Waits.waitForGivenTime(2);
	        List<WebElement> deleteButtons = GenericActions.getElements(ListsOfWishListedBoxInWishListPage,"Fetching  WishListBoxes");
	        
	        // If the list is not empty, proceed to remove all addresses
	        if (!deleteButtons.isEmpty() && deleteButtons.get(0).isDisplayed()) {
	            int count = deleteButtons.size();
	            
	            // Loop through and click each delete button, updating the list after each click
	            while (count > 0) {
	            	deleteButtons.get(0).click();
	                
	                Waits.waitForGivenTime(5); 

	                deleteButtons = GenericActions.getElements(ListsOfWishListedBoxInWishListPage," Fetching more WishListBoxes");
	                count = deleteButtons.size();
	            }
	        }
	    } catch (TimeoutException | InterruptedException | NoSuchElementException e) {
	        logger.info("Exception occurred: Could not find or interact with the WishListBoxes Button. Error: " + e.getMessage());
	    }
	}
	
	public void ClickedOnViewItemsButtonInSharedWishListPage() throws InterruptedException {
		Waits.waitForGivenTime(3);
		Waits.waitUntilElementIsVisible(sharedWishlistedViewItemsBtn(1));
		TouchActions.clickElement(sharedWishlistedViewItemsBtn(1), "ViewItemsBtn Button is clicked");
	}
	
	public void ClearAllSharedWishlistedDetailsIfItExists() {
	    try {
	        Waits.waitForGivenTime(2);
	        List<WebElement> deleteButtons = GenericActions.getElements(ListsDeleteItemsBtnInsharedWishlist,"Fetching  SharedListBoxes");
	        
	        // If the list is not empty, proceed to remove all addresses
	        if (!deleteButtons.isEmpty() && deleteButtons.get(0).isDisplayed()) {
	            int count = deleteButtons.size();
	            
	            // Loop through and click each delete button, updating the list after each click
	            while (count > 0) {
	            	deleteButtons.get(0).click();
	                
	            	Waits.waitForGivenTime(2); 
	                confirmDeletingAddress();
	                AddressDeletedConfirmationToastmsg();
	                Waits.waitForGivenTime(2);

	                deleteButtons = GenericActions.getElements(ListsDeleteItemsBtnInsharedWishlist," Fetching more SharedListBoxes");
	                count = deleteButtons.size();
	            }
	        }
	    } catch (TimeoutException | InterruptedException | NoSuchElementException e) {
	        logger.info("Exception occurred: Could not find or interact with the SharedListBoxes Button. Error: " + e.getMessage());
	    }
	}


}
