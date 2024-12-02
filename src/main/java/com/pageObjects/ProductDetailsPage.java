package com.pageObjects;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.actions.GenericActions;
import com.actions.MouseActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;

public class ProductDetailsPage extends BaseClass {
	SearchPage searchPage = new SearchPage();
	
	//Locator
	
	private static final By productDetailPageHeader= AppiumBy.xpath("//android.widget.TextView[@text='Product Details']");
	//private static final By productNameInproductPage = AppiumBy.xpath("(//com.horcrux.svg.SvgView/following-sibling::android.widget.TextView)[2]");
	private static final By productNameInproductPage = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'SKU:')]/preceding-sibling::*[last()]");
	//private static final By priceOfItem(String typeOfPrice) {return AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'"+typeOfPrice+"')]/following-sibling::android.widget.TextView)[1]");}
	private static final By priceOfItem = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'$')])[1]");
	private static final By BuyNowBtn = AppiumBy.accessibilityId("Buy now");
	private static final By productAllDetailsDD (String DDName) {return AppiumBy.xpath("//android.widget.TextView[contains(@text,'"+DDName+"')]");}
	private static final By ContShoppingBtInProdDetailsPgae =AppiumBy.id("android:id/button1");
	private static final By viewCartBtInProdDetailsPgae =AppiumBy.id("android:id/button2");
	private static final By BuyNowSuccesfulModal =AppiumBy.id("android:id/message");
	private static final By BuyNowTitlefulModal =AppiumBy.id("android:id/alertTitle");
	private static final By wishListItemBtn = AppiumBy.xpath("(//android.widget.TextView[@text='Product Details']/following-sibling::android.widget.ScrollView//com.horcrux.svg.SvgView)[1]");
	//
	private static final By ProdCost = AppiumBy.xpath("(//android.widget.TextView[@text='Product Details']//..//following-sibling::android.widget.HorizontalScrollView//following-sibling::android.widget.TextView[starts-with(@text,'$')])[1]");
	private static final By ReducedProdCost = AppiumBy.xpath("(//android.widget.TextView[@text='Product Details']//..//following-sibling::android.widget.HorizontalScrollView//following-sibling::android.widget.TextView[starts-with(@text,'$')])[2]");
	
	
	//Methods
	
	public void ValidateLandingInProductPage() {
		
		Waits.waitUntilElementIsVisible(productDetailPageHeader);
		MobWebAssertion.elementDisplayed(productDetailPageHeader, "productDetailPageHeader is Displayed");
	}
	
	public void validateThePriceOfItemInProductDetailsPage() {
		
	Waits.waitUntilElementIsVisible(priceOfItem);
	MobWebAssertion.elementDisplayed(priceOfItem, "priceOfItem is Displayed");
	}
	
	public String getThePriceOfItemInProductDetailsPage() {
	
	Waits.waitUntilElementIsVisible(priceOfItem);
	MobWebAssertion.elementDisplayed(priceOfItem, " is Displayed");
	String price = GenericActions.getElements(priceOfItem, "Getting the text value of ").get(0).getText();
	return price;
	}
	
	public void validateDESCItemInProductDetailsPage(String DDName) {
		
	Waits.waitUntilElementIsVisible(productAllDetailsDD(DDName) );
	MobWebAssertion.elementDisplayed(productAllDetailsDD(DDName), DDName+" is Displayed");
	}
	
	public void validateDisplayedItemIsEqualAsInDisplayedInSearchPage() throws InterruptedException {
		Waits.waitForGivenTime(3);	
	Waits.waitUntilElementIsVisible(productNameInproductPage);
	MobWebAssertion.elementDisplayed(productNameInproductPage, "productNameInproductPage is Displayed");
	String itemName = GenericActions.getElements(productNameInproductPage, "Getting the text value").get(0).getText();
	String expected = searchPage.getItemName();
	MobWebAssertion.assertEquals(itemName, expected);
	}
	
//	public void validateDisplayedItemOurPriceIsEqualAsInDisplayedInSearchPage() throws InterruptedException {
//		Waits.waitForGivenTime(3);	
//	Waits.waitUntilElementIsVisible(priceOfItem("Our price"));
//	MobWebAssertion.elementDisplayed(priceOfItem("Our price"), "priceOfItem(\"Our price\") is Displayed");
//	String itemPrice = GenericActions.getElements(priceOfItem("Our price"), "Getting the text value").get(0).getText();
//	String expected = searchPage.getItemOurPrice();
//	MobWebAssertion.assertEquals(itemPrice, expected);
//	}
//	
//	public void validateDisplayedItemListPriceIsEqualAsInDisplayedInSearchPage() throws InterruptedException {
//		Waits.waitForGivenTime(3);	
//	Waits.waitUntilElementIsVisible(priceOfItem("List price"));
//	MobWebAssertion.elementDisplayed(priceOfItem("List price"), "priceOfItem(\"List price\") is Displayed");
//	String itemPrice = GenericActions.getElements(priceOfItem("List price"), "Getting the text value").get(0).getText();
//	String expected = searchPage.getItemListPrice();
//	MobWebAssertion.assertEquals(itemPrice, expected);
//	}
	
	//validation after changing in UI and Database
	public void validateDisplayedItemPriceIsEqualAsInDisplayedInSearchPage() throws InterruptedException {
		Waits.waitForGivenTime(3);	
	Waits.waitUntilElementIsVisible(ProdCost);
	MobWebAssertion.elementDisplayed(ProdCost, "ProdCost is Displayed");
	String itemPrice = GenericActions.getElements(ProdCost, "Getting the text value").get(0).getText();
	String expected = searchPage.getItemListPrice();
	MobWebAssertion.assertEquals(itemPrice, expected);
	}
	
	
	public void ClickedOnBuyNowButtonInProductDetailsPage() throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		Waits.waiForAnElement(BuyNowBtn, "Wait for search btn");
		MouseActions.clickElement(BuyNowBtn, "Clicked on BuyNow button");
		
	}
	public void ClickedOnViewCartButtonInProductDetailsPage() throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		Waits.waiForAnElement(viewCartBtInProdDetailsPgae, "Wait for search btn");
		MouseActions.clickElement(viewCartBtInProdDetailsPgae, "Clicked on viewCartbtInProdDetailsPgae button");
		
	}
	
	public void ClickedOnAddTowishListItemBtnInProductDetailsPage() throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		Waits.waiForAnElement(wishListItemBtn, "Wait for search btn");
		MouseActions.clickElement(wishListItemBtn, "Clicked on wishListItemBtn button");
		
	}
	


}
