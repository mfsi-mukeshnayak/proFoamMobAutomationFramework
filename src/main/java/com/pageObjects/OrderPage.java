package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.actions.GenericActions;
import com.actions.KeyBoardActions;
import com.actions.MouseActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.utills.GenericMethods;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;

public class OrderPage extends BaseClass {
	
	SearchPage searchPage = new SearchPage();
	MyAddressesPage myAddress = new MyAddressesPage();
	GenericMethods generic = new GenericMethods();
	
	
	private static final By proceedToBuyBtn = AppiumBy.accessibilityId("Proceed to buy");
	private static final By continueShoppingBtn = AppiumBy.accessibilityId("Continue shopping");
	private static final By QtyInMyBag(String itemName) {return AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'"+itemName+"')]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");} 
	private static final By PlusBtnQtyInMyBag(String itemName) {return AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'"+itemName+"')]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]");}
	private static final By MinusBtnQtyInMyBag(String itemName) {return AppiumBy.xpath("//android.view.ViewGroup[contains(@content-desc,'"+itemName+"')]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]");}
	private static final By AddButton = AppiumBy.xpath("//android.widget.TextView[@text='Add']");
	private static final By SelectAddressForOrder = AppiumBy.accessibilityId("Select");
	private static final By PickUpLocationRadioButtn = AppiumBy.xpath("(//android.widget.TextView[@text='Pickup Locations']//..//android.widget.ScrollView)[2]");
	private static final By BusinessNameTextBox = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Business Name')]/..//android.view.ViewGroup[3]//android.widget.EditText");
	private static final By CheckOutBtn = AppiumBy.accessibilityId("Checkout");
	private static final By CardNumberTextBox = AppiumBy.xpath("//android.widget.TextView[@text='Card number']//..");
	private static final By ExpiryDate = AppiumBy.xpath("//android.widget.TextView[@text='MM / YY']//..");
	private static final By CVV = AppiumBy.xpath("//android.widget.TextView[@text='CVC']//..");
	private static final By ZipCodeInCheckoutPage = AppiumBy.xpath("//android.widget.TextView[@text='ZIP Code']//..");
	private static final By PayBtn = AppiumBy.id("com.profoam:id/label");
	private static final By OrderConfirmedOKBtn = AppiumBy.id("android:id/button1");
	private static final By OrderConfirmedMsg = AppiumBy.id("android:id/message");
	private static final By OrderConfirmedHeader = AppiumBy.id("android:id/alertTitle");
	private static final By totalPaidInOrderDetailsPage = AppiumBy.xpath("(//android.widget.TextView[@text='Total paid: ']//following-sibling::android.widget.TextView)[1]");
	private static final By OrderDetails(String heading, int index) {return AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'"+heading+"')]/following-sibling::android.widget.TextView)["+index+"]");}
	private static final By OrderDetailsHeader = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Order details')]");
	private static final By OrderPrices(String typOfAmount) {return AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'"+typOfAmount+"')]//following-sibling::android.widget.TextView)[1]");}
	
	//methods
	
	private void adjustQtyToOne(String itemName) {
	    // Wait until the quantity element is visible
	    Waits.waitUntilElementIsVisible(QtyInMyBag(itemName));

	    try {
	    	Waits.waitForGivenTime(3);
	        // Get the current quantity from the QtyInMyBag element
	        int currentQty = Integer.parseInt(GenericActions.getElement(QtyInMyBag(itemName),"").getText());

	        // If quantity is greater than 1, click minus button until it's 1
	        while (currentQty > 1) {
	        	MouseActions.clickElement(MinusBtnQtyInMyBag(itemName), "Clicked on MinusBtnQtyInMyBag(itemName) button");
	            Waits.waitForGivenTime(3); // Short wait for UI update
	            currentQty = Integer.parseInt(GenericActions.getElement(QtyInMyBag(itemName),"").getText());
	        }

	        // If quantity is less than 1, click plus button until it's 1
	        while (currentQty < 1) {
	            MouseActions.clickElement(PlusBtnQtyInMyBag(itemName), "Clicked on MinusBtnQtyInMyBag(itemName) button");
	            Waits.waitForGivenTime(3); // Short wait for UI update
	            currentQty = Integer.parseInt(GenericActions.getElement(QtyInMyBag(itemName),"").getText());
	        }

	        // Final validation to confirm it's 1
	        if (currentQty == 1) {
	            logger.info("Quantity is 1 for item: " + itemName);
	        }

	    } catch (Exception e) {
	        System.out.println("Error occurred while adjusting the quantity for item: " + itemName);
	        e.printStackTrace();
	    }
	}
	
	public void ClickedOnProceedToBuyButton() throws InterruptedException {
		
		Waits.waitForGivenTime(1);
		Waits.waiForAnElement(proceedToBuyBtn, "Wait for proceedToBuyBtn");
		MouseActions.clickElement(proceedToBuyBtn, "Clicked on proceedToBuyBtn");
		
	}
	
	public void ClickedOnContinueShoppingButton() throws InterruptedException {
		
		Waits.waitForGivenTime(1);
		Waits.waiForAnElement(continueShoppingBtn, "Wait for continueShoppingBtn");
		MouseActions.clickElement(continueShoppingBtn, "Clicked on continueShoppingBtn");
		
	}
	
	public void BalancedQtyOfItemInMyBagPage() throws InterruptedException {
		String ItemName = searchPage.getItemName();
		Waits.waitForGivenTime(2);
		adjustQtyToOne(ItemName);
	}
	public void ClickedOnSelectAddressForTheOrder() throws InterruptedException {
		Waits.waitForGivenTime(1);
		Waits.waiForAnElement(SelectAddressForOrder, "Wait for SelectAddressForOrder");
		MouseActions.clickElement(SelectAddressForOrder, "Clicked on SelectAddressForOrder");
	}
	
	public void selectBillingAddressCheckBoxIfNotSelected(By checkBoxLocator) {
	    try {
	   
	        Waits.waitUntilElementIsVisible(checkBoxLocator);

	        WebElement checkBox = GenericActions.getElement(checkBoxLocator,"");

	    
	        if (!checkBox.isSelected()) {
	           
	            checkBox.click();
	            System.out.println("Checkbox was not selected, now it is selected.");
	        } else {
	        
	            System.out.println("Checkbox is already selected.");
	        }
	    } catch (Exception e) {
	        System.out.println("Error occurred while trying to select the checkbox.");
	        e.printStackTrace();
	    }
	}
	
	public void ClickedOnAddAddressButton() throws InterruptedException {
		
		// Wait for a short period before checking visibility
	    Waits.waitForGivenTime(1);

	    // Check if the AddButton is visible
	    if (Waits.isElementVisible(AddButton, "Checking if AddButton is visible")) {
	        // Wait until the AddButton is fully available
	        Waits.waiForAnElement(AddButton, "Wait for AddButton to be clickable");
	        // Perform the click action if AddButton is visible
	        MouseActions.clickElement(AddButton, "Clicked on AddButton");
	        
	        SelectAddressforOrderProcess();
	    } else {
	        // Log or handle the scenario where the button is not visible
	        System.out.println("AddButton is not visible, skipping the click action.");
	    }		
	}
	
	public void SelectAddressforOrderProcess() throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		Waits.waiForAnElement(SelectAddressForOrder, "Wait for SelectAddressForOrder");
		MouseActions.clickElement(SelectAddressForOrder, "Clicked on SelectAddressForOrder");
		
	}
	
	public void SelectPickuoLocations() throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		//Waits.waiForAnElement(PickUpLocationRadioButtn(address), "Wait for SelectAddressForOrder");
		MouseActions.clickElement(PickUpLocationRadioButtn, "Clicked on PickUpLocationRadioButtn");
		
	}
	public void clickedOnChekoutButton() throws InterruptedException {
		
		Waits.waitForGivenTime(10);
		Waits.waiForAnElement(CheckOutBtn, "Wait for CheckOutBtn");
		MouseActions.clickElement(CheckOutBtn, "Clicked on CheckOutBtn");
		
	}

	public void EnterTheCardNumberToPurchase() throws InterruptedException {
		String cardnumber = "4242424242424242";
		Waits.waitForGivenTime(12);
		Waits.waiForAnElement(CardNumberTextBox, "clicked on search button");
		KeyBoardActions.enterText(CardNumberTextBox, cardnumber, cardnumber+" is entered");
		
	}
	
	public void EnterTheCVVNumberToPurchase() throws InterruptedException {
		String cvvnumber = generic.generateRandomNumber(3);
		Waits.waiForAnElement(CVV, "wait for CVV textbox");
		KeyBoardActions.enterText(CVV, cvvnumber, cvvnumber+" is entered");
		
	}
	
	public void EnterTheExpiryDateToPurchase() throws InterruptedException {
		String expirydate = generic.generateExpiryDateOfCard();
		Waits.waiForAnElement(ExpiryDate, "wait for CVV textbox");
		KeyBoardActions.enterText(ExpiryDate, expirydate, expirydate+" is entered");
		
	}
	
	public void EnterTheZipcodeToPurchase() throws InterruptedException {
		String ZipCode = generic.generateRandomAlaskaZipCode();
		Waits.waiForAnElement(ZipCodeInCheckoutPage, "wait for CVV textbox");
		KeyBoardActions.enterText(ZipCodeInCheckoutPage, ZipCode, ZipCode+" is entered");
		
	}
	
	public void EnterTheCardDetailsToPurchase() throws InterruptedException {
		
		EnterTheCardNumberToPurchase();
		EnterTheExpiryDateToPurchase();
		EnterTheCVVNumberToPurchase();
		EnterTheZipcodeToPurchase();
		
	}
	
	public void clickedOnPayNowButton() throws InterruptedException {
		
		Waits.waitForGivenTime(1);
		Waits.waiForAnElement(PayBtn, "Wait for PayBtn");
		MouseActions.clickElement(PayBtn, "Clicked on PayBtn");
		
	}
	
	public void clickedOnOrderConfirmedButton() throws InterruptedException {
		
		Waits.waitForGivenTime(12);
		Waits.waiForAnElement(OrderConfirmedOKBtn, "Wait for OrderConfirmedOKBtn");
		MouseActions.clickElement(OrderConfirmedOKBtn, "Clicked on OrderConfirmedOKBtn");
		
	}
	
	public void ValidateHeadeOfOrdersPage() throws InterruptedException {
		Waits.waitForGivenTime(3);
		Waits.waitUntilElementIsVisible(OrderDetailsHeader);
		MobWebAssertion.elementDisplayed(OrderDetailsHeader, "OrderDetailsHeader is Displayed");
	}
	
	public void ValidateNameInOrdersPage() throws InterruptedException {
		Waits.waitForGivenTime(3);
		String actName = GenericActions.getElements(OrderDetails("Name",1), "Getting the text value").get(0).getText();
		MobWebAssertion.assertEquals(actName, "Mukesh");
	}
	
	public void ValidateContactOrdersPage() {
		
		String actualid = GenericActions.getElements(OrderDetails("Contact",1), "Getting the text value").get(0).getText();
		MobWebAssertion.assertContains(actualid, getPropertyValue("emailId"));
		
	//	String actualnum = GenericActions.getElements(OrderDetails("Contact",2), "Getting the text value").get(0).getText();
	//	MobWebAssertion.assertContains(actualnum, myAddress.getMobNumber() );
	}
	
	public void ValidateAddressInOrdersPage() {
		
		String actAddress = GenericActions.getElements(OrderDetails("Billing address",1), "Getting the text value").get(0).getText();
		MobWebAssertion.assertContains(actAddress, myAddress.getAddress());
	}
	
	public void IValidateOrderDetailsAfterSuccessfulOrder() throws InterruptedException {
		ValidateNameInOrdersPage();
		ValidateContactOrdersPage();
		ValidateAddressInOrdersPage();
	}
	
	public void ValidatedOrdeedProductPricesAfterSuccessfulOrder() {
		String discountedPriceString=null ;
		String expectedSubTotal = searchPage.getItemListPrice();
		String expectedTotalPaid = searchPage.getItemOurPrice();
		MouseActions.ScrollUsingUiAutomator("Total paid: ");
		String actualSubTotal = GenericActions.getElements(OrderPrices("Subtotal"), "Getting the text value").get(0).getText();
		String actualtotalpaid = GenericActions.getElements(OrderPrices("Total paid"), "Getting the text value").get(0).getText();
		String actualDiscount = GenericActions.getElements(OrderPrices("Total discount"), "Getting the text value").get(0).getText();
		MobWebAssertion.assertContains(actualSubTotal, expectedSubTotal);
		MobWebAssertion.assertContains(actualtotalpaid, expectedTotalPaid);
		
		try {
		    // Convert the prices to double (you can also use BigDecimal for better precision)
		    double subTotal = Double.parseDouble(expectedSubTotal.replaceAll("[^\\d.]", ""));  // Remove any non-numeric characters
		    double totalPaid = Double.parseDouble(expectedTotalPaid.replaceAll("[^\\d.]", ""));

		    // Calculate the discounted price
		    double expectedDiscountedPrice = subTotal - totalPaid;

		    // Format the discounted price to 2 decimal places
		    discountedPriceString = String.format("%.2f", expectedDiscountedPrice);

		    // Print the prices and result


		} catch (NumberFormatException e) {
		    System.err.println("Error parsing price: " + e.getMessage());
		}
		
		MobWebAssertion.assertContains(actualDiscount, "$"+discountedPriceString);

		
	}
	
}
