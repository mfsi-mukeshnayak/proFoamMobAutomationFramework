package TestCases;

import org.testng.annotations.Test;

import com.pageObjects.ProductPage;
import com.pageObjects.LoginPage;
import com.utills.BaseClass;
import com.utills.PageObjectManager;

public class ProductPage_TestCase extends BaseClass {
	
	PageObjectManager pageManager = new PageObjectManager();
	
	@Test (groups = {"smoke","Regression","ProductPage_TestCase", "ValidateButtonsInProductpage"}, description = "Validating buttons present in ProductPage")
	public void VeryFyingProductPageDisplayedFuncns() throws InterruptedException {
		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
		pageManager.getLoginPage().ValidateLoginTextBoxAndButtonInLoginPage();
		pageManager.getLoginPage().LoginToProFoamApplication();
		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
		pageManager.getProductPage().SideMenubarIsDisplayed();
		pageManager.getProductPage().cartMenuIsDisplayed();
		pageManager.getProductPage().productsTabIsDisplayed();
		pageManager.getProductPage().ProdctTabTextdisplayed();
		pageManager.getProductPage().eventsTabIsDisplayed();
		pageManager.getProductPage().EventsTabTextdisplayed();
		pageManager.getProductPage().SearchBoxIsDisplayed();
		
	}

}
