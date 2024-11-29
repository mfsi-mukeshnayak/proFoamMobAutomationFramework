package com.pageObjects;

import org.openqa.selenium.By;

import com.actions.GenericActions;
import com.actions.KeyBoardActions;
import com.actions.MouseActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.utills.GenericMethods;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;

public class ProfileSettingsPage extends BaseClass {
	//Profile Settings
	
	CommonActionsPage commonAct = new CommonActionsPage();
	
	//Locators
	
	private static final By headerProfileSettings = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Profile Settings')]");
	private static final By salutationDD = AppiumBy.xpath("(//android.widget.TextView[contains(@text,'Salutation')]//following-sibling::android.view.ViewGroup)[1]");
	private static final By SelectFromSalutationDD(String input) {return AppiumBy.xpath("//android.view.ViewGroup[starts-with(@content-desc,'"+input+"')]");}
	private static final By DeleteBtn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Delete']");
	private static final By FirstNameTextBox = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'First name')]//following-sibling::android.widget.EditText)[1]");
	private static final By LastNameTextBox = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Last name')]//following-sibling::android.widget.EditText)[2]");
	private static final By MobileNumTextBox = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Mobile number')]//following-sibling::android.widget.EditText)[1]");
	private static final By EmailIdTextBox = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Email ID')]//following-sibling::android.widget.EditText)[1]");
	private static final By CountryDD = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Country')]//following-sibling::android.view.ViewGroup)[1]");
	private static final By StateDD = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'State')]//following-sibling::android.view.ViewGroup)[2]");
	private static final By CityTextBox = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'City')]//following-sibling::android.widget.EditText)[1]");
	private static final By ZipTextBox = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Zip code')]//following-sibling::android.widget.EditText)[2]");
	private static final By SaveBtn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Save']");
	private static final By AddBtn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Add']");
	private static final By BusinessNames = AppiumBy.xpath("(//android.widget.TextView[starts-with(@text,'Business Names')]//following-sibling::android.widget.EditText)[1]");
	private static final By SelectCountry(String countryName) { return AppiumBy.accessibilityId(countryName);}
	private static final By SelectState(String stateName) { return AppiumBy.accessibilityId(stateName);}
	private static final By FirstNameErrorMsg = AppiumBy.xpath("((//android.widget.TextView[starts-with(@text,'First name')]//following-sibling::android.widget.EditText)[1]//following-sibling::android.widget.TextView)[1]");
	private static final By LastNameErrorMsg = AppiumBy.xpath("((//android.widget.TextView[starts-with(@text,'Last name')]//following-sibling::android.widget.EditText)[2]//following-sibling::android.widget.TextView)[2]");
	private static final By EmailIdErrorMsg = AppiumBy.xpath("((//android.widget.TextView[starts-with(@text,'Email ID')]//following-sibling::android.widget.EditText)[1]//following-sibling::android.widget.TextView)[1]");
	
	
	//Methods
	
	public void ClickOnProfileSettingsCategoryInSidemenu() throws InterruptedException {
		MouseActions.scrollSideMenuToElement("Profile Settings");
		commonAct.selectCategoryInSideMenu("Profile Settings");
	}
	
	public  void ValidatingProfileSettingsHeader() throws InterruptedException {
	Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(headerProfileSettings);
	MobWebAssertion.elementDisplayed(headerProfileSettings, "headerProfileSettings is Displayed");

	}
	
	public  void ValidatingProfileSettingsDeleteBtn() throws InterruptedException {
	Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(DeleteBtn);
	MobWebAssertion.elementDisplayed(DeleteBtn, "DeleteBtn is Displayed");

	}
	
	public  void ValidatingAllFieldsInProfileSettings() throws InterruptedException {
	Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(FirstNameTextBox);
	MobWebAssertion.elementDisplayed(FirstNameTextBox, "FirstNameTextBox is Displayed");
	MobWebAssertion.elementDisplayed(LastNameTextBox, "LastNameTextBox is Displayed");
	MobWebAssertion.elementDisplayed(MobileNumTextBox, "MobileNumTextBox is Displayed");
	MobWebAssertion.elementDisplayed(EmailIdTextBox, "EmailIdTextBox is Displayed");
	MobWebAssertion.elementDisplayed(SaveBtn, "SaveBtn is Displayed");

	}
	
	
	public  void clearingFirstNameAndLastNameTextBox() throws InterruptedException {
	Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(FirstNameTextBox);
	KeyBoardActions.clearText(FirstNameTextBox, "FirstNameTextBox is Displayed");
	KeyBoardActions.clearText(LastNameTextBox, "LastNameTextBox is Displayed");

	}
	public  void clearingEmailIDTextBox() throws InterruptedException {
	Waits.waitForGivenTime(3);
	Waits.waitUntilElementIsVisible(EmailIdTextBox);
	KeyBoardActions.clearText(EmailIdTextBox, "EmailIdTextBox is Displayed");

	}
	
	public void ValidateFirstNameErrorMsgInProfileSettings() throws InterruptedException {
		Waits.waitForGivenTime(5);
		String actualfootertext = GenericActions.getElements(FirstNameErrorMsg, "Getting the text value").get(0).getText();
		String expectedText ="Please enter first name";
		MobWebAssertion.assertEquals(actualfootertext, expectedText);
	}
	
	public void ValidateLastNameErrorMsgInProfileSettings() throws InterruptedException {
		Waits.waitForGivenTime(2);
		String actualfootertext = GenericActions.getElements(LastNameErrorMsg, "Getting the text value").get(0).getText();
		String expectedText ="Please enter last name";
		MobWebAssertion.assertEquals(actualfootertext, expectedText);
	}
	
	public void ValidateEmailIdErrorMsgInProfileSettings() throws InterruptedException {
		Waits.waitForGivenTime(2);
		String actualfootertext = GenericActions.getElements(EmailIdErrorMsg, "Getting the text value").get(0).getText();
		String expectedText ="Please enter email id";
		MobWebAssertion.assertEquals(actualfootertext, expectedText);
	}
	
	public void ValidateEmailIdInvalidErrorMsgInProfileSettings() throws InterruptedException {
		Waits.waitForGivenTime(5);
		String actualfootertext = GenericActions.getElements(EmailIdErrorMsg, "Getting the text value").get(0).getText();
		String expectedText ="please enter valid email address";
		MobWebAssertion.assertEquals(actualfootertext, expectedText);
	}
	public void clearingAllMandatoryFieldsAndClickingOnSave() throws InterruptedException {
		
		clearingFirstNameAndLastNameTextBox();
		clearingEmailIDTextBox();
		ClickedOnSaveButton();
	}
	
	public void ValidateAllErrormsgsInProfileSettings() throws InterruptedException {
		
		ValidateFirstNameErrorMsgInProfileSettings();
		ValidateLastNameErrorMsgInProfileSettings();
		ValidateEmailIdErrorMsgInProfileSettings();
	}
	
	public void ClickedOnSaveButton() throws InterruptedException {
		
		Waits.waitForGivenTime(1);
		Waits.waiForAnElement(SaveBtn, "Wait for SaveBtn");
		MouseActions.clickElement(SaveBtn, "Clicked on SaveBtn");
		
	}
	
	public void ValidateInvalidMailIdErrorMsgInProfileSettings() throws InterruptedException {
		String invalidRandomId = GenericMethods.generateRandomLetters(6)+"@"+GenericMethods.generateRandomLetters(3);
		KeyBoardActions.enterText(EmailIdTextBox, invalidRandomId , "Entring the invalid mailId: "+ invalidRandomId);
		ClickedOnSaveButton();
		Waits.waitForGivenTime(5);
		ValidateEmailIdInvalidErrorMsgInProfileSettings();
	}
	
}
