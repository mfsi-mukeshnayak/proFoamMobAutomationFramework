package com.pageObjects;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;

import com.actions.GenericActions;
import com.actions.KeyBoardActions;
import com.actions.MouseActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;

public class SearchPage extends BaseClass {
	
	public static String itemName;
	public static  String itemOurPrice;
	public static String itemListPrice;
	
	private static final By Searchbtn = AppiumBy.xpath("(//android.widget.TextView)[2]");
	private static final By searchHeader = AppiumBy.xpath("(//android.widget.TextView[@text='Search'])[1]");
	private static final By searchResultHeader = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Search result - Spray Foam')]");
	private static final By selectProductByIndex(int index) { return AppiumBy.xpath("((//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[1]/android.view.ViewGroup)[" + index + "]");}
	private static final By addToCart(int index) { return AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Add to cart'])[" + index + "]");}
	private static final By addToWishlistBtn(int index) {return AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Add to cart'])[" + index + "]//../android.view.ViewGroup[1]");}
	private static final By clearBtn = AppiumBy.xpath("//android.widget.TextView[@text='Clear']");
	private static final By productNameFromTheDDlist(String productName) { return AppiumBy.xpath("//android.view.ViewGroup[contains(translate(@content-desc, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + productName.toLowerCase() + "')]/android.widget.TextView");}	
	private static final By LoadmoreProducts = AppiumBy.accessibilityId("LOAD MORE PRODUCTS");
	private static final By SearchTab = AppiumBy.accessibilityId("Search for Products | Events");
	private static final By productNameInSearchdPage(int index) { return AppiumBy.xpath("(((//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[1]/android.view.ViewGroup)[" + index + "]//android.widget.TextView)[1]");}
	private static final By priductOurPriceInSearchdPage(int index) { return AppiumBy.xpath("(((//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[1]/android.view.ViewGroup)[" + index + "]//android.widget.TextView)[2]");}
	private static final By priductListPriceInSearchdPage(int index) { return AppiumBy.xpath("(((//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup)[1]/android.view.ViewGroup)[" + index + "]//android.widget.TextView)[3]");}
	private static final By searchBox = AppiumBy.xpath("//android.widget.EditText[starts-with(@text,'Search for Products')]");
	
	
	//Methods
	
	public void inputProductNameAndSearchTheItem(String productNmae) throws InterruptedException {
		
		Waits.waiForAnElement(SearchTab, "Wait for search btn");
		MouseActions.clickElement(SearchTab, "Clicked on search Button");
		Waits.waiForAnElement(searchBox, "clicked on search button");
		KeyBoardActions.enterText(searchBox, productNmae, productNmae+" is entered");
		
		
	}
	
	public void ClickedOnSearcheditemandNavigateToSearchedItemPage(String productNmae) throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		Waits.waiForAnElement(productNameFromTheDDlist(productNmae), "Wait for search btn");
		MouseActions.clickElement(productNameFromTheDDlist(productNmae), "Clicked on " + productNmae);
		
	}
	
	public void ClickedOnSearchButton() throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		Waits.waiForAnElement(Searchbtn, "Wait for search btn");
		MouseActions.clickElement(Searchbtn, "Clicked on Searchbtn");
		
	}
	
	public void ClickedOnProductInfromthesearchedList() throws InterruptedException {
		GenericActions.hideKeyboardIfVisible();
		int productIndex =1;
		Waits.waitForGivenTime(2);
		//Waits.waiForAnElement(selectProductByIndex(productIndex), "Wait for search btn");
		MouseActions.clickElement(selectProductByIndex(productIndex), "Clicked on Product");
		
	}
	
	public  void grabTheNameofSearchedItemName() throws InterruptedException {
		Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(productNameInSearchdPage(1));
	MobWebAssertion.elementDisplayed(productNameInSearchdPage(1), "productNameInSearchdPage(1) is Displayed");
	itemName = GenericActions.getElements(productNameInSearchdPage(1), "Getting the text value").get(0).getText();
	

	}
	
	public  void grabOurPriceofSearchedItemName() throws InterruptedException {
		Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(priductOurPriceInSearchdPage(1));
	MobWebAssertion.elementDisplayed(priductOurPriceInSearchdPage(1), "priductOurPriceInSearchdPage(1) is Displayed");
	itemOurPrice = GenericActions.getElements(priductOurPriceInSearchdPage(1), "Getting the text value").get(0).getText();
	}
	
	public  void grabListPriceofSearchedItemName() throws InterruptedException {
		Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(priductListPriceInSearchdPage(1));
	MobWebAssertion.elementDisplayed(priductListPriceInSearchdPage(1), "priductListPriceInSearchdPage(1) is Displayed");
	itemListPrice = GenericActions.getElements(priductListPriceInSearchdPage(1), "Getting the text value").get(0).getText();

	}
	
	  
    public static String getItemName() {
        return itemName;
    }
	  
    public static String getItemOurPrice() {
        return itemOurPrice;
    }
	  
    public static String getItemListPrice() {
        return itemListPrice;
    }
}
