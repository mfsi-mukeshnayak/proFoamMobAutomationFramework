package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.utills.BaseClass;
import com.utills.PageObjectManager;

public class OrderPage_TestCase extends BaseClass {
	
	PageObjectManager pageManager = new PageObjectManager();

	
	@Test (groups = {"Regression", "ValidationOfOrderingAnewItemIncheckoutPage."}, description = "Adding a new order in checkoutpage")
	public void ValidationOfOrderingAnewItemIncheckoutPage() throws InterruptedException {
		System.out.println("Application is launching");
		
		pageManager.getLoginPage().ValidateWelcomeTextInWelcomePage();
		pageManager.getLoginPage().ClickOnSkipButtonInWelcomePage();
		pageManager.getLoginPage().ValidateLogin_ButtonInLoginPage();
		pageManager.getLoginPage().ClickOnLoginButtonInLoginButton();
		pageManager.getLoginPage().LoginToProFoamApplication();
		pageManager.getProductPage().LandedOnProductPageAndAbleToSeeSideMenu();
		//pageManager.getProductPage().ClickOnSideMenubar();
		//pageManager.getMyAddressesPage().ClickOnMyAddresCategoryInSidemenu();
		//pageManager.getMyAddressesPage().AddNewAddressHeaderIsDisplayed();
		//pageManager.getMyAddressesPage().AddNewAddressBtnIsDisplayed();
		//pageManager.getMyAddressesPage().ClearAllAddressIfItExists();
		//pageManager.getMyAddressesPage().clickOnaddNewaddressButton();
		//pageManager.getMyAddressesPage().AddedAnewAddressInMyAddress();
		//pageManager.getCommonActionsPage().navigatetoBackPage();
		pageManager.getSearchPage().inputProductNameAndSearchTheItem("spray foam guns");
		pageManager.getSearchPage().ClickedOnSearcheditemandNavigateToSearchedItemPage("spray foam guns");
		pageManager.getSearchPage().ClickedOnSearchButton();
		pageManager.getSearchPage().grabTheNameofSearchedItemName();
		pageManager.getSearchPage().grabOurPriceofSearchedItemName();
		pageManager.getSearchPage().grabListPriceofSearchedItemName();
		pageManager.getSearchPage().ClickedOnProductInfromthesearchedList();
		pageManager.getProdDetailsPage().ValidateLandingInProductPage();
		pageManager.getProdDetailsPage().validateDisplayedItemIsEqualAsInDisplayedInSearchPage();
		pageManager.getProdDetailsPage().validateDisplayedItemPriceIsEqualAsInDisplayedInSearchPage();
		//pageManager.getProdDetailsPage().validateDisplayedItemOurPriceIsEqualAsInDisplayedInSearchPage();
		
	}
	
	@Test (groups = {"smoke" ,"Regression", "ValidationOfACompleteOrderofAnItem"}, description = "Validation Of A Complete Order of An Item")
	public void ValidationOfACompleteOrderofAnItem() throws InterruptedException {
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
		pageManager.getCommonActionsPage().navigatetoBackPage();
		pageManager.getSearchPage().inputProductNameAndSearchTheItem("spray foam guns");
		pageManager.getSearchPage().ClickedOnSearcheditemandNavigateToSearchedItemPage("spray foam guns");
		pageManager.getSearchPage().ClickedOnSearchButton();
		pageManager.getSearchPage().grabTheNameofSearchedItemName();
		pageManager.getSearchPage().grabOurPriceofSearchedItemName();
		pageManager.getSearchPage().grabListPriceofSearchedItemName();
		pageManager.getSearchPage().ClickedOnProductInfromthesearchedList();
		pageManager.getProdDetailsPage().ValidateLandingInProductPage();
		pageManager.getProdDetailsPage().validateDisplayedItemIsEqualAsInDisplayedInSearchPage();
		pageManager.getProdDetailsPage().validateDisplayedItemPriceIsEqualAsInDisplayedInSearchPage();
		//pageManager.getProdDetailsPage().validateDisplayedItemOurPriceIsEqualAsInDisplayedInSearchPage();
		pageManager.getProdDetailsPage().ClickedOnBuyNowButtonInProductDetailsPage();
		pageManager.getProdDetailsPage().ClickedOnViewCartButtonInProductDetailsPage();
		pageManager.getOrderPage().BalancedQtyOfItemInMyBagPage();
		pageManager.getOrderPage().ClickedOnProceedToBuyButton();
		pageManager.getOrderPage().ClickedOnAddAddressButton();
		pageManager.getOrderPage().SelectPickuoLocations();
		pageManager.getOrderPage().clickedOnChekoutButton();
		pageManager.getOrderPage().EnterTheCardDetailsToPurchase();
		pageManager.getOrderPage().clickedOnPayNowButton();
		pageManager.getOrderPage().clickedOnOrderConfirmedButton();
		pageManager.getOrderPage().ValidateHeadeOfOrdersPage();
		pageManager.getOrderPage().IValidateOrderDetailsAfterSuccessfulOrder();
		pageManager.getOrderPage().ValidatedOrdeedProductPricesAfterSuccessfulOrder();
		
	}
	
	@Test (groups = {"Regression", "ValidationOfAnOrderofApplyingCouponDiscountForAnItem"}, description = "Validation Of An Order of Applying Coupon Discount For An Item")
	public void ValidationOfAnOrderofApplyingCouponDiscountForAnItem() throws InterruptedException {
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
		pageManager.getCommonActionsPage().navigatetoBackPage();
		pageManager.getSearchPage().inputProductNameAndSearchTheItem("spray foam guns");
		pageManager.getSearchPage().ClickedOnSearcheditemandNavigateToSearchedItemPage("spray foam guns");
		pageManager.getSearchPage().ClickedOnSearchButton();
		pageManager.getSearchPage().grabTheNameofSearchedItemName();
		pageManager.getSearchPage().grabOurPriceofSearchedItemName();
		pageManager.getSearchPage().grabListPriceofSearchedItemName();
		pageManager.getSearchPage().ClickedOnProductInfromthesearchedList();
		pageManager.getProdDetailsPage().ValidateLandingInProductPage();
		pageManager.getProdDetailsPage().validateDisplayedItemIsEqualAsInDisplayedInSearchPage();
		pageManager.getProdDetailsPage().validateDisplayedItemPriceIsEqualAsInDisplayedInSearchPage();
		//pageManager.getProdDetailsPage().validateDisplayedItemOurPriceIsEqualAsInDisplayedInSearchPage();
		pageManager.getProdDetailsPage().ClickedOnBuyNowButtonInProductDetailsPage();
		pageManager.getProdDetailsPage().ClickedOnViewCartButtonInProductDetailsPage();
		pageManager.getOrderPage().BalancedQtyOfItemInMyBagPage();
		pageManager.getOrderPage().ClickedOnProceedToBuyButton();
		pageManager.getOrderPage().ClickedOnAddAddressButton();
		pageManager.getOrderPage().SelectPickuoLocations();
		pageManager.getOrderPage().AppliedDiscountFoerTheOder("save99");
		pageManager.getOrderPage().ClickedOnApplyWhileApplyingDiscountCouponinOrderNowPage();
		pageManager.getOrderPage().ValidatedProductPricesAfterSuccessfulOrderAfterApplyingDiscountinOrderNowPage();
		pageManager.getOrderPage().clickedOnChekoutButton();
//		pageManager.getOrderPage().EnterTheCardDetailsToPurchase();
//		pageManager.getOrderPage().clickedOnPayNowButton();
//		pageManager.getOrderPage().clickedOnOrderConfirmedButton();
//		pageManager.getOrderPage().ValidateHeadeOfOrdersPage();
//		pageManager.getOrderPage().IValidateOrderDetailsAfterSuccessfulOrder();
//		pageManager.getOrderPage().ValidatedOrdeedProductPricesAfterSuccessfulOrder();
//		
	}
	
	@Test (groups = {"Regression", "ValidationOfAnOrderAfterAddingTaxForAnItem"}, description = "Validation Of An Order After Adding Tax For An Item")
	public void ValidationOfAnOrderAfterAddingTaxForAnItem() throws InterruptedException {
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
		pageManager.getMyAddressesPage().AddedAnewAddressInMyAddress("Georgia");
		pageManager.getCommonActionsPage().navigatetoBackPage();
		pageManager.getSearchPage().inputProductNameAndSearchTheItem("spray foam guns");
		pageManager.getSearchPage().ClickedOnSearcheditemandNavigateToSearchedItemPage("spray foam guns");
		pageManager.getSearchPage().ClickedOnSearchButton();
		pageManager.getSearchPage().grabTheNameofSearchedItemName();
		pageManager.getSearchPage().grabOurPriceofSearchedItemName();
		pageManager.getSearchPage().grabListPriceofSearchedItemName();
		pageManager.getSearchPage().ClickedOnProductInfromthesearchedList();
		pageManager.getProdDetailsPage().ValidateLandingInProductPage();
		pageManager.getProdDetailsPage().validateDisplayedItemIsEqualAsInDisplayedInSearchPage();
		pageManager.getProdDetailsPage().validateDisplayedItemPriceIsEqualAsInDisplayedInSearchPage();
		//pageManager.getProdDetailsPage().validateDisplayedItemOurPriceIsEqualAsInDisplayedInSearchPage();
		pageManager.getProdDetailsPage().ClickedOnBuyNowButtonInProductDetailsPage();
		pageManager.getProdDetailsPage().ClickedOnViewCartButtonInProductDetailsPage();
		pageManager.getOrderPage().BalancedQtyOfItemInMyBagPage();
		pageManager.getOrderPage().ClickedOnProceedToBuyButton();
		pageManager.getOrderPage().ClickedOnAddAddressButton();
		pageManager.getOrderPage().SelectPickuoLocations();
		pageManager.getOrderPage().AppliedDiscountFoerTheOder("save99");
		pageManager.getOrderPage().ClickedOnApplyWhileApplyingDiscountCouponinOrderNowPage();
		pageManager.getOrderPage().ValidatedProductPricesAfterSuccessfulOrderAfterApplyingDiscountinOrderNowPage();
		pageManager.getOrderPage().clickedOnChekoutButton();
		
	}


}
