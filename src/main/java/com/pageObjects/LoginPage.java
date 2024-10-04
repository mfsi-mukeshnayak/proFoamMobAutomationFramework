package com.pageObjects;


import org.openqa.selenium.By;

import com.actions.GenericActions;
import com.actions.MouseActions;
import com.assertions.MobWebAssertion;
import com.utills.BaseClass;
import com.utills.CustomMethods;
import com.utills.GenericMethods;
import com.waits.Waits;

import io.appium.java_client.AppiumBy;



public class LoginPage extends BaseClass {
	
	GenericMethods generic = new GenericMethods();
	CustomMethods custom = new CustomMethods();
	
	//Locators
	
	private static final By welcomeMessage = AppiumBy.xpath("(//android.widget.TextView)[2]");
	private static final By SkipButton = AppiumBy.accessibilityId("SKIP");
	private static final By LoginBtn = AppiumBy.accessibilityId("Login");
	private static final By EmailIdTextBox = AppiumBy.xpath("(//android.widget.EditText)[1]");
	private static final By PasswordTextBox = AppiumBy.xpath("(//android.widget.EditText)[2]");
	
	
	//methods
	
	public void ValidateWelcomeTextInWelcomePage() throws InterruptedException {
		Thread.sleep(7000);
		String actualfootertext = GenericActions.getElements(welcomeMessage, "Getting the text value").get(0).getText();
		String expectedText ="Welcome to Profoam Corporation’s Online Store.";
		MobWebAssertion.assertEquals(actualfootertext, expectedText);
	}
	
	public void ClickOnSkipButtonInWelcomePage() throws InterruptedException {
		Waits.waitUntilElementIsVisible(SkipButton);
		MouseActions.clickElement(SkipButton, "Skip Button is clicked");
		
	}
	public void ValidateLogin_ButtonInLoginPage() {
		
		Waits.waitUntilElementIsVisible(LoginBtn);
		MobWebAssertion.elementDisplayed(LoginBtn, "LoginBtn is Displayed");
	}
	
	public void ClickOnLoginButtonInLoginButton() throws InterruptedException {
		Waits.waitUntilElementIsVisible(LoginBtn);
		MouseActions.clickElement(LoginBtn, "Login Button is clicked");
		
	}
	
	public void ValidateLoginTextBoxAndButtonInLoginPage() {
		Waits.waitUntilElementIsVisible(EmailIdTextBox);
		MobWebAssertion.elementDisplayed(EmailIdTextBox, "EmailIdTextBox is Displayed");
		MobWebAssertion.elementDisplayed(PasswordTextBox, "PasswordTextBox is Displayed");
		MobWebAssertion.elementDisplayed(LoginBtn, "LoginBtn is Displayed");
		
	}
	
	public void LoginToProFoamApplication() throws InterruptedException {
		
		Waits.waitUntilElementIsVisible(EmailIdTextBox);
		custom.LoginToProFoamApplication(EmailIdTextBox , PasswordTextBox);
		MouseActions.clickElement(LoginBtn, "Login Button is clicked");
	}
}
