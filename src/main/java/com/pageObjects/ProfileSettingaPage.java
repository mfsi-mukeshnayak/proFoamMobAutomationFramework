package com.pageObjects;

import org.openqa.selenium.By;

import com.actions.MouseActions;
import com.utills.BaseClass;

import io.appium.java_client.AppiumBy;

public class ProfileSettingaPage extends BaseClass {
	//Profile Settings
	
	CommonActionsPage commonAct = new CommonActionsPage();
	
	//Locators
	
	private static final By headerWishList = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Profile Settings')]");
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
	
	//Methods
	
	public void ClickOnWishlistCategoryInSidemenu() throws InterruptedException {
		MouseActions.scrollSideMenuToElement("Profile Settings");
		commonAct.selectCategoryInSideMenu("Profile Settings");
	}
	
	
	

}
