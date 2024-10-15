package com.pageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;

import com.actions.GenericActions;
import com.actions.KeyBoardActions;
import com.actions.MouseActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.utills.CustomMethods;
import com.utills.GenericMethods;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;

public class MyAddressesPage extends BaseClass {
	private static String MobNumber;
	public static String Address;
	private static String City;
	private static String ZipCode;
	
	GenericMethods generic = new GenericMethods();
	CustomMethods custom = new CustomMethods();
	CommonActionsPage commonAct = new CommonActionsPage();
	
	private static final By AddNewAddressHeader = AppiumBy.xpath("(//android.widget.TextView)[1]");
	private static final By AddressDltBtn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Delete']/android.widget.TextView");
	private static final By AddNewAddressBtn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Add new address\"]/android.widget.TextView");
	private static final By EditAddressBtn = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"Edit Address\"])[1]");
	private static By AddressTextBox(String textboxName) {
	    int index;
	    // Using a switch case to determine the index based on the textboxName
	    switch (textboxName.toLowerCase()) {
	        case "addresstype":
	            index = 1; // AddressType is the first textbox
	            break;
	        case "mobilenumber":
	            index = 2; //  MobileNumber is the second textbox
	            break;
	        case "addressline1":
	            index = 3; //  AddressLine1 is the third textbox
	            break;
	        case "addressline2":
	            index = 4; //  AddressLine2 is the fourth textbox
	            break;
	        case "city":
	            index = 5; //  city is the fifth textbox
	            break;
	        case "zipcode":
	            index = 6; //  ZipCode is the sixth textbox
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid textbox name: " + textboxName);
	    }
	    // Constructing the XPath with the determined index
	    return AppiumBy.xpath("(//android.widget.TextView/following-sibling::android.widget.EditText)[" + index + "]");
	}
	
	private static By CountryDropDown = AppiumBy.xpath("(//android.widget.TextView[contains(@text,'State')]//following-sibling::android.view.ViewGroup)[1]");
	private static By stateDropDown = AppiumBy.xpath("(//android.widget.TextView[contains(@text,'State')]//following-sibling::android.view.ViewGroup)[2]");
	private static final By saveBtnInAddresspage = AppiumBy.accessibilityId("Save");
	
	private static By AddressTextBoxErrorTexts(String textboxName) {
	    int index;
	    // Using a switch case to determine the index based on the textboxName
	    switch (textboxName.toLowerCase()) {
	        case "addresstype":
	            index = 1; // AddressType is the first textbox
	            break;
	        case "mobilenumber":
	            index = 3; //  MobileNumber is the second textbox
	            break;
	        case "addressline1":
	            index = 5; //  AddressLine1 is the third textbox
	            break;
	        case "country":
	            index = 9; //  Country is the fourth textbox
	            break;
	        case "state":
	            index = 10; //  State is the fourth textbox
	            break;
	        case "city":
	            index = 13; //  city is the fifth textbox
	            break;
	        case "zipcode":
	            index = 14; //  ZipCode is the sixth textbox
	            break;
	            
	        default:
	            throw new IllegalArgumentException("Invalid textbox name: " + textboxName);
	    }
	    // Constructing the XPath with the determined index
	    return AppiumBy.xpath("(//android.widget.TextView/following-sibling::android.widget.EditText/following-sibling::android.widget.TextView)[" + index + "]");
	}
	private static final By SelectCountry(String countryName) { return AppiumBy.accessibilityId(countryName);}
	private static final By SelectState(String stateName) { return AppiumBy.accessibilityId(stateName);}
	private static final By alertHeader = AppiumBy.id("android:id/alertTitle");
	private static final By alertMessage = AppiumBy.id("android:id/message");
	private static final By YesBtnForalertMessage = AppiumBy.id("android:id/button2");
	private static final By NoBtnForalertMessage = AppiumBy.id("android:id/button1");
	private static final By Ok_BtnForalertMessage = AppiumBy.id("android:id/button1");
	
	
	public void ClickOnMyAddresCategoryInSidemenu() throws InterruptedException {
		
		commonAct.selectCategoryInSideMenu("My Addresses");
	}
	
	public void AddNewAddressHeaderIsDisplayed() throws InterruptedException {
		Waits.waitForGivenTime(4);
		//Waits.waitUntilElementIsVisible(AddNewAddressHeader);
		MobWebAssertion.elementDisplayed(AddNewAddressHeader, "AddNewAddressHeader is Displayed");
		
	}
	public void AddNewAddressBtnIsDisplayed() throws InterruptedException {
		Waits.waitUntilElementIsVisible(AddNewAddressBtn);
		MobWebAssertion.elementDisplayed(AddNewAddressBtn, "AddNewAddressBtn is Displayed");
		
	}
	
	public void clickOnaddNewaddressButton() throws InterruptedException {
		Waits.waitUntilElementIsVisible(AddNewAddressBtn);
		MouseActions.clickElement(AddNewAddressBtn, "AddNewAddress Button is clicked");
		
	}
	
	public void confirmDeletingAddress() throws InterruptedException {
		
		Waits.waitUntilElementIsVisible(YesBtnForalertMessage);
		MouseActions.clickElement(YesBtnForalertMessage, "YesBtnForalertMessage Button is clicked");
		
	} 
	
	public void AddressDeletedConfirmationToastmsg() throws InterruptedException {
		
		Waits.waitUntilElementIsVisible(YesBtnForalertMessage);
		MouseActions.clickElement(Ok_BtnForalertMessage, "Ok_BtnForalertMessage Button is clicked");
	}
	
	public void ClearAllAddressIfItExists() {
	    try {
	        Waits.waitForGivenTime(2);
	        List<WebElement> deleteButtons = GenericActions.getElements(AddressDltBtn,"Fetching  DeleteButtons");
	        
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

	                deleteButtons = GenericActions.getElements(AddressDltBtn," Fetching more DeleteButton");
	                count = deleteButtons.size();
	            }
	        }
	    } catch (TimeoutException | InterruptedException | NoSuchElementException e) {
	        logger.info("Exception occurred: Could not find or interact with the Address Delete Button. Error: " + e.getMessage());
	    }
	}
	
	public void FilledAddressTypeField(String HomeOroffice ) throws InterruptedException {
		Waits.waitForGivenTime(2);
		KeyBoardActions.enterText(AddressTextBox("AddressType"), HomeOroffice , HomeOroffice+" is entered");
	}
	
	public void FilledMobileNumber(String MobNum ) throws InterruptedException {
		Waits.waitForGivenTime(2);
		KeyBoardActions.enterText(AddressTextBox("MobileNumber"), MobNum , MobNum+" is entered");
	}
	public void FilledAddressLine(String AdressLine1 ) throws InterruptedException {
		Waits.waitForGivenTime(2);
		KeyBoardActions.enterText(AddressTextBox("AddressLine1"), AdressLine1 , AdressLine1+" is entered");
	}
	
	public void SelectCountryInAddressFieldDropDown(String countryName ) throws InterruptedException {
		Waits.waitForGivenTime(2);
		MouseActions.clickElement(CountryDropDown, "CountryDropDown Button is clicked");
		Waits.waitForGivenTime(2);
		MouseActions.clickElement(SelectCountry(countryName), countryName+" is selected as Country");
	}
	
	public void SelectStateInAddressFieldDropDown(String stateName ) throws InterruptedException {
		Waits.waitForGivenTime(2);
		MouseActions.clickElement(stateDropDown, "stateDropDown Button is clicked");
		Waits.waitForGivenTime(2);
		MouseActions.swipeUntilElementIsVisible(SelectState(stateName));
		MouseActions.clickElement(SelectState(stateName), stateName+" is selected as state");
	}
	
	public void FilledCityName(String cityName ) throws InterruptedException {
		Waits.waitForGivenTime(2);
		KeyBoardActions.enterText(AddressTextBox("city"), cityName , cityName+" is entered");
	}
	
	public void FilledZipCode(String zipcode ) throws InterruptedException {
		Waits.waitForGivenTime(2);
		KeyBoardActions.enterText(AddressTextBox("ZipCode"), zipcode , zipcode+" is entered");
	}
	public void AddedAnewAddressInMyAddress(String State) throws InterruptedException {
		 if (State == null || State.isEmpty()) {
		        State = "Alaska";
		    }
		
		Address = generic.generateRandomAddress();
		MobNumber = generic.generateRandomMobileNumber();
		City = generic.getRandomCity(State);
		ZipCode = generic.generateRandomZipCode(State); 
		
		FilledAddressTypeField("Home");
		FilledMobileNumber(MobNumber);
		FilledAddressLine(Address);
		SelectCountryInAddressFieldDropDown("United States");
		SelectStateInAddressFieldDropDown(State);
		FilledCityName(City);
		FilledZipCode(ZipCode);
		MouseActions.clickElement(saveBtnInAddresspage, "Save Button is Clicked");
		Waits.waitForGivenTime(4);
		
	}
	
    public static String getAddress() {
        return Address;
    }
    public static String getMobNumber() {
        return MobNumber;
    }


	
}
