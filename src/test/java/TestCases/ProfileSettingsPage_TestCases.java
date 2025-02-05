package TestCases;

import org.testng.annotations.Test;

import com.utills.BaseClass;
import com.utills.PageObjectManager;

public class ProfileSettingsPage_TestCases extends BaseClass {
	
	
PageObjectManager pageManager = new PageObjectManager();
	
	@Test (groups = {"smoke" ,"Regression", "NavigateToProfileSettingsPageandValidateHeaders"}, description = "Validating different headers in Profile Settings Page in sideMenu")
	public void NavigateToProfileSettingsPageandValidateHeaders() throws InterruptedException {
		System.out.println("Application is launching");
		
//		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
//		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
//		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
//		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
//		pageManager.getLoginPage().LoginToProFoamApplication();
		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
		pageManager.getProductPage().ClickOnSideMenubar();
		pageManager.getProfileSettingsPage().ClickOnProfileSettingsCategoryInSidemenu();
		pageManager.getProfileSettingsPage().ValidatingProfileSettingsHeader();
		pageManager.getProfileSettingsPage().ValidatingProfileSettingsDeleteBtn();
		
	}
	
	
	@Test (groups = {"smoke" ,"Regression", "NavigateToProfileSettingsPageAndValidateButtons"}, description = "Validating different buttons in Profile Settings Page in sideMenu")
	public void NavigateToProfileSettingsPageandValidateButtons() throws InterruptedException {
		System.out.println("Application is launching");
		
//		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
//		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
//		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
//		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
//		pageManager.getLoginPage().LoginToProFoamApplication();
		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
		pageManager.getProductPage().ClickOnSideMenubar();
		pageManager.getProfileSettingsPage().ClickOnProfileSettingsCategoryInSidemenu();
		pageManager.getProfileSettingsPage().ValidatingProfileSettingsHeader();
		pageManager.getProfileSettingsPage().ValidatingProfileSettingsDeleteBtn();
		pageManager.getProfileSettingsPage().ValidatingAllFieldsInProfileSettings();
		
	}
	
	@Test (groups = {"smoke" ,"Regression","NegativeTestCase", "ValidateErrorMsgAfterClearingMandatoryFieldsInProfileSettingsPage"}, description = "Validate Error Msg After Clearing Mandatory Fields In ProfileSettingsPage")
	public void ValidateErrorMsgAfterClearingMandatoryFieldsInProfileSettingsPage() throws InterruptedException {
		System.out.println("Application is launching");
		
//		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
//		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
//		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
//		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
//		pageManager.getLoginPage().LoginToProFoamApplication();
		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
		pageManager.getProductPage().ClickOnSideMenubar();
		pageManager.getProfileSettingsPage().ClickOnProfileSettingsCategoryInSidemenu();
		pageManager.getProfileSettingsPage().ValidatingProfileSettingsHeader();
		pageManager.getProfileSettingsPage().ValidatingProfileSettingsDeleteBtn();
		pageManager.getProfileSettingsPage().ValidatingAllFieldsInProfileSettings();
		pageManager.getProfileSettingsPage().clearingAllMandatoryFieldsAndClickingOnSave();
		pageManager.getProfileSettingsPage().ValidateAllErrormsgsInProfileSettings();
		
	}
	
	@Test (groups = {"smoke" ,"Regression","NegativeTestCase", "ValidateInvalidEmailIDErrorMsgInProfileSettingsPage"}, description = "Validate In valid Email ID ErrorMsg In Profile Settings Page")
	public void ValidateInvalidEmailIDErrorMsgInProfileSettingsPage() throws InterruptedException {
		System.out.println("Application is launching");
		
//		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
//		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
//		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
//		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
//		pageManager.getLoginPage().LoginToProFoamApplication();
		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
		pageManager.getProductPage().ClickOnSideMenubar();
		pageManager.getProfileSettingsPage().ClickOnProfileSettingsCategoryInSidemenu();
		pageManager.getProfileSettingsPage().ValidatingProfileSettingsHeader();
		pageManager.getProfileSettingsPage().ValidatingProfileSettingsDeleteBtn();
		pageManager.getProfileSettingsPage().ValidatingAllFieldsInProfileSettings();
		pageManager.getProfileSettingsPage().ValidateInvalidMailIdErrorMsgInProfileSettings();
		
	}


}
