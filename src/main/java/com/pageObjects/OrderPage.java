package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.actions.GenericActions;
import com.actions.KeyBoardActions;
import com.actions.MouseActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.utills.GenericMethods;
import com.waits.Waits;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import io.appium.java_client.AppiumBy;
import java.text.NumberFormat;
import java.util.Locale;

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
	private static final By AvailbleCoupnBtn = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Available Coupons')]");
	private static final By ApplyCouponBtn(String couponName) {return AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'"+couponName+"')]//following-sibling::android.view.ViewGroup[@content-desc='Apply']");}
	private static final By CouponConfirmedOKApplyBtn = AppiumBy.id("android:id/button2");
	private static final By CouponConfirmedAlertdMsg = AppiumBy.id("android:id/message");
	private static final By ApplyCouponInOrderNowPage = AppiumBy.xpath("//android.widget.TextView[@text='APPLY']");
	
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
		String ZipCode = generic.generateRandomZipCode("");
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
	
public void ClickedOnAvailableButton() throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		Waits.waitUntilElementIsVisible(AvailbleCoupnBtn);
		MouseActions.clickElement(AvailbleCoupnBtn, "Clicked on AvailbleCoupnBtn");
		
	}
	public void ClickedOnApplyCouponButton(String couponName) throws InterruptedException {
		
		Waits.waitForGivenTime(3);
		Waits.waitUntilElementIsVisible(ApplyCouponBtn(couponName));
		MouseActions.clickElement(ApplyCouponBtn(couponName), "Clicked on ApplyCouponBtn(couponName)");
		
	}
	
	public void AppliedDiscountFoerTheOder(String couponName) throws InterruptedException {
		MouseActions.scrollToElementUsingUIwithSwipe(AvailbleCoupnBtn);
		ClickedOnAvailableButton();
		ClickedOnApplyCouponButton(couponName);
		Waits.waitForGivenTime(4);
	}
	
	public void ValidatedOrderedProductPricesAfterSuccessfulOrderAfterApplyingDiscount() {
		String expectedDiscountedString=null ;
		String expectedTotalPriceString=null;
	//	String expectedSubTotal = searchPage.getItemListPrice();
	//	String expectedTotalPaid = searchPage.getItemOurPrice();
		MouseActions.ScrollUsingUiAutomator("Total paid: ");
		String actualSubTotal = GenericActions.getElements(OrderPrices("Subtotal"), "Getting the text value").get(0).getText();
		String actualtotalpaid = GenericActions.getElements(OrderPrices("Total paid"), "Getting the text value").get(0).getText();
		String actualDiscount = GenericActions.getElements(OrderPrices("Total discount"), "Getting the text value").get(0).getText();
		
		try {
		    // Convert the prices to double (you can also use BigDecimal for better precision)
		    double subTotal = Double.parseDouble(actualSubTotal.replaceAll("[^\\d.]", ""));  // Remove any non-numeric characters
		    double totalDiscount = Double.parseDouble(actualDiscount.replaceAll("[^\\d.]", ""));

		    // Calculate the total price
		    double expectedDiscountedTotalPrice = subTotal - totalDiscount;

		    // Format the discounted price to 2 decimal places
		    expectedTotalPriceString = String.format("%.2f", expectedDiscountedTotalPrice);

		} catch (NumberFormatException e) {
		    System.err.println("Error parsing price: " + e.getMessage());
		}

		//MobWebAssertion.assertContains(actualSubTotal, expectedSubTotal);
		MobWebAssertion.assertContains(actualtotalpaid, "$"+expectedTotalPriceString);
		
		try {
		    double subTotal = Double.parseDouble(actualSubTotal.replaceAll("[^\\d.]", "")); 
		    double totalPaid = Double.parseDouble(actualtotalpaid.replaceAll("[^\\d.]", ""));

		    double expectedDiscountedPrice = subTotal - totalPaid;

		    expectedDiscountedString = String.format("%.2f", expectedDiscountedPrice);

		} catch (NumberFormatException e) {
		    System.err.println("Error parsing price: " + e.getMessage());
		}
		
		MobWebAssertion.assertContains(actualDiscount, "$"+expectedDiscountedString);

	}
	

	public void ValidatedProductPricesAfterSuccessfulOrderAfterApplyingDiscountinOrderNowPage() {
	    String expectedDiscountedString = null;
	    String expectedTotalPriceString = null;
	    String expectedTaxString = null;
	    String expectedShippingString = null;

	    // Scroll to the element with the total price
	    MouseActions.scrollToElementUsingUIwithSwipe(OrderPrices("Total payable"));

	    // Fetch the actual prices displayed on the screen
	    String actualSubTotal = GenericActions.getElements(OrderPrices("Subtotal"), "Getting the text value").get(0).getText();
	    String actualtotalpaid = GenericActions.getElements(OrderPrices("Total payable"), "Getting the text value").get(0).getText();
	    String actualDiscount = GenericActions.getElements(OrderPrices("Total Discount0"), "Getting the text value").get(0).getText();
	    String actualTax = GenericActions.getElements(OrderPrices("Tax"), "Getting the text value").get(0).getText();
	    String actualShipping = GenericActions.getElements(OrderPrices("Shipping"), "Getting the text value").get(0).getText();

//ValidatingTotalPaid
	    try {
	        // Convert the prices to double (you can also use BigDecimal for better precision)
	        double subTotal = Double.parseDouble(actualSubTotal.replaceAll("[^\\d.]", ""));  // Remove any non-numeric characters
	        double totalDiscount = Double.parseDouble(actualDiscount.replaceAll("[^\\d.]", ""));
	        double taxAmount = Double.parseDouble(actualTax.replaceAll("[^\\d.]", ""));
	        double shippingAmount = Double.parseDouble(actualShipping.replaceAll("[^\\d.]", ""));

	        // Calculate the total price (Subtotal - Discount + Tax + Shipping)
	        double expectedDiscountedTotalPrice = subTotal - totalDiscount + taxAmount + shippingAmount;

	        // Format the discounted price with commas and 2 decimal places
	        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	        numberFormat.setMinimumFractionDigits(2);
	        numberFormat.setMaximumFractionDigits(2);
	        expectedTotalPriceString = numberFormat.format(expectedDiscountedTotalPrice);

	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing price: " + e.getMessage());
	    }

	    // Return formatted expected total price as string with a dollar sign prefix
	    String expectedTotalPrice= "$" + expectedTotalPriceString;

	    MobWebAssertion.assertEquals(actualtotalpaid, expectedTotalPrice);
//ValidatingTaxPaid	    
	    try {
	        // Convert the prices to double (you can also use BigDecimal for better precision)
	        double subTotal = Double.parseDouble(actualSubTotal.replaceAll("[^\\d.]", ""));  // Remove any non-numeric characters
	        double totalDiscount = Double.parseDouble(actualDiscount.replaceAll("[^\\d.]", ""));
	        double totalPaid = Double.parseDouble(actualtotalpaid.replaceAll("[^\\d.]", ""));
	        double shippingAmount = Double.parseDouble(actualShipping.replaceAll("[^\\d.]", ""));

	        // Calculate the total price (Subtotal - Discount + Tax)
	        double expectedTax = totalPaid - subTotal + totalDiscount;

	        // Format the discounted price with commas and 2 decimal places
	        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	        numberFormat.setMinimumFractionDigits(2);
	        numberFormat.setMaximumFractionDigits(2);
	        expectedTaxString = numberFormat.format(expectedTax);

	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing price: " + e.getMessage());
	    }

	    // Validate tax
	    String expectedTax = "$" + expectedTaxString;
	    MobWebAssertion.assertEquals(actualTax, expectedTax);
//ValidatingDiscount	
	    try {
	        // Recalculate the expected discounted amount
	    	double subTotal = Double.parseDouble(actualSubTotal.replaceAll("[^\\d.]", ""));
	        double totalPaid = Double.parseDouble(actualtotalpaid.replaceAll("[^\\d.]", ""));
	        double taxAmount = Double.parseDouble(actualTax.replaceAll("[^\\d.]", ""));
	        double shippingAmount = Double.parseDouble(actualShipping.replaceAll("[^\\d.]", ""));

	        double SubstractedPrice = Math.abs((subTotal - totalPaid));
	        double expectedDiscountedPrice = Math.abs(SubstractedPrice - taxAmount);
	        
	        

	        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	        numberFormat.setMinimumFractionDigits(2);
	        numberFormat.setMaximumFractionDigits(2);
	        expectedDiscountedString = numberFormat.format(expectedDiscountedPrice);

	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing price: " + e.getMessage());
	    }
	    
	    String expectedDiscount = "$" + expectedDiscountedString;
	    // Validate discount
	    MobWebAssertion.assertContains(actualDiscount, expectedDiscount);
//ValidatingShippingPrice
	    try { 
	    double subTotal = Double.parseDouble(actualSubTotal.replaceAll("[^\\d.]", ""));  // Clean non-numeric characters
	    double totalDiscount = Double.parseDouble(actualDiscount.replaceAll("[^\\d.]", ""));
	    double taxAmount = Double.parseDouble(actualTax.replaceAll("[^\\d.]", ""));
	    double totalPaid = Double.parseDouble(actualtotalpaid.replaceAll("[^\\d.]", ""));

	    // Calculate the expected shipping price
	    double expectedShippingPrice = totalPaid - (subTotal - totalDiscount + taxAmount);

	    // Format the expected shipping price with commas and 2 decimal places
	    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	    numberFormat.setMinimumFractionDigits(2);
	    numberFormat.setMaximumFractionDigits(2);
	    expectedShippingString = numberFormat.format(expectedShippingPrice);
	    
	    // Return formatted expected shipping price as a string with a dollar sign prefix
	    String expectedShipping = "$" + expectedShippingString;

	    // Validate shipping amount
	    MobWebAssertion.assertEquals(actualShipping, expectedShipping);  // Validate shipping charge

	} catch (NumberFormatException e) {
	    System.err.println("Error parsing price: " + e.getMessage());
	
	}
}
	public void ClickedOnApplyWhileApplyingDiscountCouponinOrderNowPage() throws InterruptedException {

		if (Waits.isElementVisible(ApplyCouponInOrderNowPage, "waiting for CouponConfirmedAlertdMsg")) {
	    MouseActions.clickElement(ApplyCouponInOrderNowPage, "Clicked on ApplyCouponInOrderNowPage");
		}
	    String expectedMsg1 = "This coupon doesn't have permission to apply with other discount.\r\n"
	            + "Applying this coupon code will remove discounts from the items in cart.";
	    String expectedMsg2 = "This coupon doesn't have permission to apply with other discount";

	    try {
	        Waits.waitForGivenTime(3);
	        if (Waits.isElementVisible(CouponConfirmedAlertdMsg, "waiting for CouponConfirmedAlertdMsg")) {
	            String actualMessage = GenericActions.getElements(CouponConfirmedAlertdMsg, "Getting the text value").get(0).getText();
	            if (actualMessage.contains(expectedMsg1) ||actualMessage.contains(expectedMsg2)) {
	               
	                MouseActions.clickElement(CouponConfirmedOKApplyBtn, "Clicked on CouponConfirmedOKApplyBtn");
	                logger.info("Coupon applied successfully with confirmation message: " + actualMessage);
	            } else {
	                logger.info("Unexpected message: " + actualMessage);
	            }
	        } else {
	            logger.info("Alert message element is not displayed.");
	        }

	    } catch (TimeoutException | NoSuchElementException e) {
	        logger.info("Exception occurred: The DiscountCouponAlertMsg element was not found within the specified timeout or is missing. " + e.getMessage());
	    }
	}

}
