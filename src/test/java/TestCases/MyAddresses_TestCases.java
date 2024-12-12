package TestCases;

import org.testng.annotations.Test;

import com.reports.ExtentReport;
import com.utills.BaseClass;
import com.utills.PageObjectManager;

public class MyAddresses_TestCases extends BaseClass {
	PageObjectManager pageManager = new PageObjectManager();
	
	@Test (groups = {"smoke" ,"Regression", "NavigateToMyaddressPageandvalidateButtons"}, description = "Validating different buttons in MyAddress in sideMenu")
	public void NavigateToMyaddressPageandvalidateButtons() throws InterruptedException {
		System.out.println("Application is launching");
		
//		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
//		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
//		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
//		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
//		pageManager.getLoginPage().LoginToProFoamApplication();
		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
		pageManager.getProductPage().ClickOnSideMenubar();
		pageManager.getMyAddressesPage().ClickOnMyAddresCategoryInSidemenu();
		pageManager.getMyAddressesPage().AddNewAddressHeaderIsDisplayed();
		pageManager.getMyAddressesPage().AddNewAddressBtnIsDisplayed();
	
	}
	
	@Test (groups = {"smoke" ,"Regression", "AddAnewAddressInMyAddressPage"}, description = "Adding a newaddress in MyAddress in sideMenu")
	public void AddAnewAddressInMyAddressPage() throws InterruptedException {
		System.out.println("Application is launching");
		
//		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
//		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
//		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
//		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
//		pageManager.getLoginPage().LoginToProFoamApplication();
		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
		pageManager.getProductPage().ClickOnSideMenubar();
		pageManager.getMyAddressesPage().ClickOnMyAddresCategoryInSidemenu();
		pageManager.getMyAddressesPage().AddNewAddressHeaderIsDisplayed();
		pageManager.getMyAddressesPage().AddNewAddressBtnIsDisplayed();
		pageManager.getMyAddressesPage().ClearAllAddressIfItExists();
		pageManager.getMyAddressesPage().clickOnaddNewaddressButton();
		pageManager.getMyAddressesPage().AddedAnewAddressInMyAddress("");
	
	}

}
